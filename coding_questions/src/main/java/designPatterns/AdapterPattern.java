package designPatterns;

public class AdapterPattern {

    /**
     * 🧠 What it means:
     * 
     * You have a UK plug and an Indian socket. They don't match. So you use an adapter to connect them.
     * 
     * 💼 Real-life analogy:
     * 
     * You have an old payment system that outputs XML, but your new app understands JSON. You create an adapter to convert between them.
     */

    interface USB {
        void connectUSB();
    }
    
    static class OldCharger {
        void connectOldPlug() {
            System.out.println("Charging with old plug");
        }
    }
    
    // Adapter to connect old charger to USB
    static class ChargerAdapter implements USB {
        OldCharger charger = new OldCharger();
    
        public void connectUSB() {
            charger.connectOldPlug(); // adapts to USB
        }
    }

    public static void main(String[] args) {
        USB myCharger = new ChargerAdapter();
myCharger.connectUSB(); // Output: Charging with old plug
    }
}
