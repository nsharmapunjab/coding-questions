package designPatterns;

public class DecoratorPattern {

    /**
     *  What it means:
     *
     *  You buy a gift. Then you wrap it in a box. Then you add a ribbon. Then a tag.
     *  You’re adding new features to an object without changing it.
     *
     *  Real-life analogy:
     *
     *  Imagine you have a TestLogger. You want to add timestamp, color, and file logging one after another.
     *  You wrap it step by step.
     */

    interface Coffee {
        String getDescription();
        int cost();
    }
    
    static class BasicCoffee implements Coffee {
        public String getDescription() { return "Basic Coffee"; }
        public int cost() { return 5; }
    }
    
    static class MilkDecorator implements Coffee {
        private Coffee coffee;
        public MilkDecorator(Coffee coffee) {
            this.coffee = coffee;
        }
        public String getDescription() {
            return coffee.getDescription() + ", Milk";
        }
        public int cost() {
            return coffee.cost() + 2;
        }
    }

    public static void main(String[] args) {
        Coffee coffee = new MilkDecorator(new BasicCoffee());
        System.out.println(coffee.getDescription()); // Basic Coffee, Milk
        System.out.println(coffee.cost()); // 7
    }
}
