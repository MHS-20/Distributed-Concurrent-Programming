package pcd.lab08.actors.step2_counter;

import akka.actor.*;

public class RunActorSystem {
		
  public static void main(String[] args) throws Exception  {

	final ActorSystem system = ActorSystem.create("my-actor-system");		
	final ActorRef bootActor =  system.actorOf(Props.create(MainActor.class), "main-actor");
	bootActor.tell(new MainActor.BootMsg(), null);
  }
}
