package guava.eventbus;

import com.google.common.eventbus.AsyncEventBus;

public class EventClient {
    public static void main(String[] args) {
        AsyncEventBus asyncEventBus = EventBusCenter.getInstance();
        asyncEventBus.register(new EventListener1());
        asyncEventBus.register(new EventListener2());

        asyncEventBus.post(new MsgEvent("event"));
    }
}
