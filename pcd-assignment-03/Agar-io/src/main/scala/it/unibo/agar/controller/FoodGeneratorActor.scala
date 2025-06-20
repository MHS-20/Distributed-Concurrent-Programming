package it.unibo.agar.controller

import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.{Behaviors}
import akka.actor.typed.receptionist.{Receptionist, ServiceKey}
import scala.concurrent.duration._
import it.unibo.agar.model.Food

object FoodGeneratorActor {
  val FoodGeneratorServiceKey: ServiceKey[FoodGeneratorCommand] = ServiceKey[FoodGeneratorCommand]("FoodGenerator")
  val WorldServiceKey: ServiceKey[WorldCommand] = ServiceKey[WorldCommand]("GameManager")

  def apply(): Behavior[FoodGeneratorCommand] =
    Behaviors.setup { context =>

      //      val listingAdapter: ActorRef[Receptionist.Listing] =
      //        context.messageAdapter(listing => GameManagerListing(listing))

      val listingAdapter = context.messageAdapter[Receptionist.Listing] { listing =>
        WorldListing(listing.serviceInstances(WorldServiceKey))
      }

      // context.system.receptionist ! Receptionist.Register(FoodGeneratorServiceKey, context.self)
      context.system.receptionist ! Receptionist.Subscribe(WorldServiceKey, listingAdapter)

      Behaviors.withTimers { timers =>
        timers.startTimerAtFixedRate(GenerateFood, 1.seconds)
        active(None)
      }
    }

  def active(gameManagerOpt: Option[ActorRef[WorldCommand]]): Behavior[FoodGeneratorCommand] =
    Behaviors.receive { (context, message) =>
      message match {
        case WorldListing(gameManagers) =>
          gameManagers.headOption match {
            case Some(gmRef) if gameManagerOpt.isEmpty =>
              context.log.info("GameManager found, storing its reference")
              active(Some(gmRef))
            case _ => Behaviors.same
          }
        case GenerateFood =>
          gameManagerOpt.foreach { gmRef =>
            val food = Food(
              id = java.util.UUID.randomUUID().toString,
              x = scala.util.Random.nextDouble() * 1000,
              y = scala.util.Random.nextDouble() * 1000
            )
            gmRef ! FoodGenerated(food)
          }
          Behaviors.same
      }
    }
}