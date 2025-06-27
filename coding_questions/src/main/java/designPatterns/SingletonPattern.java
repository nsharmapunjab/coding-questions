package designPatterns;

public class SingletonPattern {

    /**
     * 🧠 What it means:<br>
     * Imagine a country—it can only have one President at a time. Even if people try to create new Presidents, they must always point to the same one.
     * <p>
     * 💼 Real-life analogy:<br>
     * You want only one instance of a printer manager in your office system. Everyone who wants to print something must use the same printer manager to avoid confusion.
     */

    static class PrinterManager {
        private static PrinterManager instance; // the only one
    
        private PrinterManager() {} // private constructor
    
        public static PrinterManager getInstance() {
            if (instance == null) {
                instance = new PrinterManager(); // create only once
            }
            return instance;
        }
    
        public void print(String doc) {
            System.out.println("Printing: " + doc);
        }
    }

    public static void main(String[] args) {
        PrinterManager manager = PrinterManager.getInstance();
        manager.print("Report.pdf");
    }
}
