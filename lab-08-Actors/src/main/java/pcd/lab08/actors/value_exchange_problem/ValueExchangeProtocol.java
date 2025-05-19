package pcd.lab08.actors.value_exchange_problem;

import java.util.List;

import akka.actor.ActorRef;

public interface ValueExchangeProtocol {

	public record BootMsg (List<ActorRef> peers) {}
	public record ValueMsg (int value) {}
	
	

}
