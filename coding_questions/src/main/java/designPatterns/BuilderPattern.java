package designPatterns;

public class BuilderPattern {

    /**
     * 🧠 What it means:
     * 
     * You go to a burger shop and say:
     *  •	I want cheese ✅
     *  •	I want lettuce ✅
     *  •	No onions ❌
     * 
     * You’re building a custom burger step-by-step.
     * 
     * 💼 Real-life analogy:
     * 
     * When creating a complex object like a Pizza or a Test Report, you may want to build it with only some options and not all.
     */

    static class Burger {
        private String bun, cheese, veggies;
    
        public static class Builder {
            private String bun, cheese, veggies;
    
            public Builder bun(String bun) { this.bun = bun; return this; }
            public Builder cheese(String cheese) { this.cheese = cheese; return this; }
            public Builder veggies(String veggies) { this.veggies = veggies; return this; }
    
            public Burger build() {
                Burger b = new Burger();
                b.bun = this.bun;
                b.cheese = this.cheese;
                b.veggies = this.veggies;
                return b;
            }
        }
    
        public void show() {
            System.out.println("Burger with " + bun + ", " + cheese + ", " + veggies);
        }
    }

    public static void main(String[] args) {
        Burger myBurger = new Burger.Builder()
        .bun("Whole Wheat")
        .cheese("Cheddar")
        .veggies("Lettuce, Tomato")
        .build();

    myBurger.show(); // Burger with Whole Wheat, Cheddar, Lettuce, Tomato
    }
}
