package pcd.boidActor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class BoidsSimulation {

    final static int N_BOIDS = 1500;

    final static double SEPARATION_WEIGHT = 1.0;
    final static double ALIGNMENT_WEIGHT = 1.0;
    final static double COHESION_WEIGHT = 1.0;

    final static int ENVIRONMENT_WIDTH = 1000;
    final static int ENVIRONMENT_HEIGHT = 1000;
    static final double MAX_SPEED = 4.0;
    static final double PERCEPTION_RADIUS = 50.0;
    static final double AVOID_RADIUS = 20.0;

    final static int SCREEN_WIDTH = 800;
    final static int SCREEN_HEIGHT = 800;

    public static void main(String[] args) {
        var model = new BoidsModel(
                N_BOIDS,
                SEPARATION_WEIGHT, ALIGNMENT_WEIGHT, COHESION_WEIGHT,
                ENVIRONMENT_WIDTH, ENVIRONMENT_HEIGHT,
                MAX_SPEED,
                PERCEPTION_RADIUS,
                AVOID_RADIUS);

        var system = ActorSystem.create("boid-actor-system");
        var view = new BoidsView(model, SCREEN_WIDTH, SCREEN_HEIGHT, N_BOIDS);

        var managerActor = system.actorOf(
                BoidsManagerActor.props(model, N_BOIDS, view),
                "simulation-manager");

        view.setManager(managerActor);
        managerActor.tell(new BoidProtocol.BootSimulation(model), ActorRef.noSender());
        //managerActor.tell(new BoidProtocol.StartSimulation(), ActorRef.noSender());
    }
}