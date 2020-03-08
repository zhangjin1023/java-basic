package guava.eventbus;

import com.google.common.eventbus.AsyncEventBus;

import java.util.concurrent.Executors;

public class EventBusCenter {
    private static AsyncEventBus asyncEventBus = new AsyncEventBus(Executors.newFixedThreadPool(3));

    public static AsyncEventBus getInstance() {
        return asyncEventBus;
    }

}
