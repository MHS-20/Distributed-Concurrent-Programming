package pcd.lab08.actors.step0_hello;

import akka.actor.AbstractActor;
import pcd.lab08.actors.step0_hello.HelloWorldMsgProtocol.*;

public class HelloWorldActor extends AbstractActor {

	private int helloCounter;
	
	/* configure message handlers */
	
	public Receive createReceive() {
		return receiveBuilder()
				.match(SayHello.class, this::onSayHello)
	            .build();
	}

	/* message handlers */
	
	private void onSayHello(SayHello msg) {
 	   helloCounter++;
 	   System.out.println("Hello " + msg.content() + " from " + this.getContext().getSelf() + " - count " + helloCounter);	
	}
}