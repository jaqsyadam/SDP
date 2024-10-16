import java.util.HashMap;
import java.util.Map;

// Mediator interface
interface Mediator {
    void sendMessage(String message, String participantName);
}

// Abstract class Participant
abstract class Participant {
    protected Mediator mediator;
    protected String name;

    public Participant(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void receive(String message);

    public void send(String message) {
        System.out.println(name + " sends: " + message);
        mediator.sendMessage(message, name);
    }
}

// Concrete Mediator with dynamic participant management
class DispatcherMediator implements Mediator {
    private Map<String, Participant> participants = new HashMap<>();

    public void registerParticipant(Participant participant) {
        participants.put(participant.name, participant);
    }

    @Override
    public void sendMessage(String message, String participantName) {
        participants.forEach((name, participant) -> {
            if (!name.equals(participantName)) {
                participant.receive(message);
            }
        });
    }
}

// Concrete Participant: Client
class Client extends Participant {
    public Client(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void receive(String message) {
        System.out.println("Client " + name + " received: " + message);
    }
}

// Concrete Participant: Driver
class Driver extends Participant {
    public Driver(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void receive(String message) {
        System.out.println("Driver " + name + " received: " + message);
    }
}

// Main class
public class TaxiMediatorSystem {
    public static void main(String[] args) {
        DispatcherMediator mediator = new DispatcherMediator();

        Client client = new Client(mediator, "John");
        Driver driver = new Driver(mediator, "Alice");

        mediator.registerParticipant(client);
        mediator.registerParticipant(driver);

        client.send("I need a taxi.");
        driver.send("On my way.");
    }
}
