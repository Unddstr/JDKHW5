import java.util.Random;

public class Philosopher implements Runnable{
    private static int count = 0;
    private int hunger;
    private final int ID;
    Fork leftFork;
    Fork rightFork;

    public Philosopher(Fork leftFork, Fork rightFork) {
        count++;
        hunger = 3;
        ID = count;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        while(hunger > 0){
            try {
                eating();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Философ " + ID + " наелся и спит");
    }

    public void eating() throws InterruptedException{
        if (leftFork.checkFork() && rightFork.checkFork() && hunger > 0){
            leftFork.takeFork();
            rightFork.takeFork();
            System.out.println("Философ " + ID + " кушает вермишель, используя вилки: " + leftFork + " и " + rightFork);
            Thread.sleep(1000 + new Random().nextInt(1000));
            hunger--;

            leftFork.putDownTheFork();
            rightFork.putDownTheFork();
            thinking();
        }
    }

    public void thinking() throws InterruptedException{
        System.out.println("Философ " + ID + " размышляет, не забыв при этом вернуть вилки: " + leftFork + " и " + rightFork);
        Thread.sleep(1000 + new Random().nextInt(2000));
    }

    public String toString() {
        return "№" + ID;
    }
}
