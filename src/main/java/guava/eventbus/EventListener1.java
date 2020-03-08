package guava.eventbus;

import com.google.common.eventbus.Subscribe;

public class EventListener1 {
    @Subscribe
    public void handle(MsgEvent msgEvent) {
        System.out.println(msgEvent.getMsg());
    }
}
