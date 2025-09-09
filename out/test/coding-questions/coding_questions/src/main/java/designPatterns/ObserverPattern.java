package designPatterns;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    /**
     * What it means:<br>
     * When a YouTuber uploads a new video, all subscribers get notified. That's Observer Pattern!
     * <br>
     * <br>
     * Real-life analogy:<br>
     * You have multiple dashboards. When test status changes, you want all dashboards to update.
     */

    interface Subscriber {
        void notify(String msg);
    }

    static class Follower implements Subscriber {
        String name;

        public Follower(String name) {
            this.name = name;
        }

        public void notify(String msg) {
            System.out.println(name + " got: " + msg);
        }
    }

    static class Channel {
        List<Subscriber> subs = new ArrayList<>();

        public void subscribe(Subscriber s) {
            subs.add(s);
        }

        public void publish(String video) {
            for (Subscriber s : subs) {
                s.notify("New video: " + video);
            }
        }
    }

    public static void main(String[] args) {
        Channel yt = new Channel();
        yt.subscribe(new Follower("Alice"));
        yt.subscribe(new Follower("Bob"));

        yt.publish("Java Design Patterns Explained");
    }
}
