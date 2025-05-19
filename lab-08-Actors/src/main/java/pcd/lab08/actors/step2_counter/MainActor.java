package pcd.lab08.actors.step2_counter;

import akka.actor.*;
import static pcd.lab08.actors.step2_counter.CounterMsgProtocol.*;

public class MainActor extends AbstractActor {

	@Override
	public Receive createReceive() {
		return receiveBuilder()
				.match(BootMsg.class, this::onBootMsg)
				.build();	
	}

	private void onBootMsg(BootMsg msg) {
		ActorRef counter = this.getContext().actorOf(Props.create(CounterActor.class), "myCounter");
		ActorRef counterUser = this.getContext().actorOf(Props.create(CounterUserActor.class), "myCounterUser");
		counterUser.tell(new CounterUserMsg(counter), this.getSelf());
	}

	/* types of messages */
	
	static public final class BootMsg {}
}
