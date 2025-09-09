package designPatterns;

public class StrategyPattern {

    /**
     * <pre>
     * &#x1F916; What it means:
     * 
     * You go to an online store. You can pay with PayPal, credit card, or UPI. The strategy to pay is chosen at runtime.
     * 
     * &#x1F3E2; Real-life analogy:
     * 
     * Your QA tool can generate reports in PDF, HTML, or JSON&mdash;strategy is selected based on environment.
     * </pre>
     */

    interface PaymentStrategy {
        void pay(int amount);
    }
    
    static class CreditCard implements PaymentStrategy {
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using Credit Card");
        }
    }
    
    static class PayPal implements PaymentStrategy {
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using PayPal");
        }
    }
    
    static class Checkout {
        PaymentStrategy strategy;
        public void setStrategy(PaymentStrategy strategy) {
            this.strategy = strategy;
        }
    
        public void payBill(int amount) {
            strategy.pay(amount);
        }
    }

    public static void main(String[] args) {
        Checkout cart = new Checkout();
        cart.setStrategy(new CreditCard());
        cart.payBill(1000); // Paid 1000 using Credit Card
    }
}
