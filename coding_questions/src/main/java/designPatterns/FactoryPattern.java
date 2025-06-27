package designPatterns;

public class FactoryPattern {

    /**
     *  What it means:
     *  You go to an ice cream shop and say "I want chocolate", and the shop knows how to create it for you.
     *  You don't care how it's made—you just ask for it.
     *  
     *  Real-life analogy:
     *  Let's say your app sends notifications. Based on the type ("Email", "SMS"), you create the right notification sender.
     *  That's the Factory pattern!
     */

    interface Notification {
        void send();
    }
    
    static class EmailNotification implements Notification {
        public void send() {
            System.out.println("Sending Email");
        }
    }
    
    static class SMSNotification implements Notification {
        public void send() {
            System.out.println("Sending SMS");
        }
    }
    
    static class NotificationFactory {
        public static Notification getNotification(String type) {
            if (type.equals("EMAIL")) return new EmailNotification();
            else return new SMSNotification();
        }
    }

    public static void main(String[] args) {
        Notification notif = NotificationFactory.getNotification("EMAIL");
        notif.send(); // Output: Sending Email
        
    }
}
