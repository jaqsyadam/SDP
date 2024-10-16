// Command interface with undo capability
interface Command {
    void execute();
    void undo();
}

// Receiver class: TaxiOrder
class TaxiOrder {
    private String destination;

    public void createOrder(String destination) {
        this.destination = destination;
        System.out.println("Order created to " + destination);
    }

    public void cancelOrder() {
        System.out.println("Order canceled.");
    }

    public void changeDestination(String newDestination) {
        this.destination = newDestination;
        System.out.println("Order destination changed to " + newDestination);
    }
}

// Concrete command: CreateOrder with undo functionality
class CreateOrderCommand implements Command {
    private TaxiOrder taxiOrder;
    private String destination;

    public CreateOrderCommand(TaxiOrder taxiOrder, String destination) {
        this.taxiOrder = taxiOrder;
        this.destination = destination;
    }

    @Override
    public void execute() {
        taxiOrder.createOrder(destination);
    }

    @Override
    public void undo() {
        System.out.println("Undoing order creation.");
        taxiOrder.cancelOrder();
    }
}

// Concrete command: CancelOrder with undo functionality
class CancelOrderCommand implements Command {
    private TaxiOrder taxiOrder;

    public CancelOrderCommand(TaxiOrder taxiOrder) {
        this.taxiOrder = taxiOrder;
    }

    @Override
    public void execute() {
        taxiOrder.cancelOrder();
    }

    @Override
    public void undo() {
        System.out.println("Undoing order cancellation.");
    }
}

// Invoker class with undo functionality
class CommandInvoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }

    public void undoCommand() {
        command.undo();
    }
}

// Main class
public class TaxiCommandSystem {
    public static void main(String[] args) {
        TaxiOrder order = new TaxiOrder();

        Command createOrder = new CreateOrderCommand(order, "Downtown");
        Command cancelOrder = new CancelOrderCommand(order);

        CommandInvoker invoker = new CommandInvoker();

        invoker.setCommand(createOrder);
        invoker.executeCommand();
        invoker.undoCommand();

        invoker.setCommand(cancelOrder);
        invoker.executeCommand();
    }
}
