package guava.eventbus;

import com.google.common.eventbus.Subscribe;

public class EventListener2 {
    @Subscribe
    public void handle(MsgEvent msgEvent) {
        System.out.println("guava eventbus");
    }
}
