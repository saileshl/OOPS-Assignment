class NumberPrinter implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class CharacterPrinter implements Runnable {
    public void run() {
        for (char ch = 'A'; ch <= 'J'; ch++) {
            System.out.println("Character: " + ch);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class MultiThreadPrinting {
    public static void main(String[] args) {
        Thread numberThread = new Thread(new NumberPrinter());
        Thread charThread = new Thread(new CharacterPrinter());

        numberThread.start();
        charThread.start();
    }
}
