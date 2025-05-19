package pcd.lab08.actors.step1_pingpong;

import akka.actor.ActorRef;

public interface PingerPongerProtocol {
	static public record PongMsg(long count, ActorRef ponger) {}
	static public record PingMsg (long count, ActorRef pinger) {}
	static public record BootMsg (ActorRef ponger) {}
}
