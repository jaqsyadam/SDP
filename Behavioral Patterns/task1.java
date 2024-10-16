import java.util.function.Predicate;

abstract class Handler {
    protected Handler nextHandler;

    public Handler setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public abstract void handle(Request request);
}

// Request class that stores the data to be processed
class Request {
    public boolean carsAvailable;
    public boolean sufficientBalance;
    public boolean locationAccessible;

    public Request(boolean carsAvailable, boolean sufficientBalance, boolean locationAccessible) {
        this.carsAvailable = carsAvailable;
        this.sufficientBalance = sufficientBalance;
        this.locationAccessible = locationAccessible;
    }
}

// Concrete handler that accepts a check function (Predicate)
class FunctionalHandler extends Handler {
    private Predicate<Request> check;
    private String successMessage;
    private String failureMessage;

    public FunctionalHandler(Predicate<Request> check, String successMessage, String failureMessage) {
        this.check = check;
        this.successMessage = successMessage;
        this.failureMessage = failureMessage;
    }

    @Override
    public void handle(Request request) {
        if (check.test(request)) {
            System.out.println(successMessage);
            if (nextHandler != null) {
                nextHandler.handle(request);
            }
        } else {
            System.out.println(failureMessage);
        }
    }
}

// Main class
public class TaxiDispatchSystem {
    public static void main(String[] args) {
        // Create the chain of handlers using functional handlers
        Handler carAvailabilityHandler = new FunctionalHandler(
            req -> req.carsAvailable,
            "Cars are available.",
            "No cars available."
        );
        Handler balanceHandler = new FunctionalHandler(
            req -> req.sufficientBalance,
            "Client has sufficient balance.",
            "Insufficient balance."
        );
        Handler locationHandler = new FunctionalHandler(
            req -> req.locationAccessible,
            "Location is accessible.",
            "Location is not accessible."
        );

        carAvailabilityHandler.setNext(balanceHandler).setNext(locationHandler);

        // Process the request
        Request request = new Request(true, false, true);
        carAvailabilityHandler.handle(request);
    }
}
