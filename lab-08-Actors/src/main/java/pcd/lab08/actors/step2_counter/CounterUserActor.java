package pcd.lab08.actors.step2_counter;

import akka.actor.*;
import static pcd.lab08.actors.step2_counter.CounterMsgProtocol.*;

public class CounterUserActor extends AbstractActor {

	@Override
	public Receive createReceive() {
		return receiveBuilder()
				.match(CounterUserMsg.class, this::onStartMsg)
				.match(CounterValueMsg.class, this::onCounterValueMsg)
				.build();		
	}

	private void onStartMsg(CounterUserMsg msg) {
		msg.counter().tell(new IncMsg(), this.getSelf());
		msg.counter().tell(new IncMsg(), this.getSelf());
		msg.counter().tell(new GetValueMsg(this.getContext().getSelf()), this.getSelf());
	}

	private void onCounterValueMsg(CounterValueMsg msg){
		log("value: " + msg.value());
	}

	private void log(String msg) {
		System.out.println("[CounterUserActor] " + msg);
	}
}
