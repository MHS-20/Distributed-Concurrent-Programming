package pcd.lab08.actors.step2_counter;

import akka.actor.ActorRef;

public class CounterMsgProtocol {

	static public record CounterMsg() {}

	static public record CounterUserMsg(ActorRef counter) {}

	static public record IncMsg() {}
	
	static public record GetValueMsg(ActorRef replyTo) {}

	static public record CounterValueMsg(int value) {} 

}
