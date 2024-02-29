public class Main {

    static volatile Fork fork1 = new Fork();
    static volatile Fork fork2 = new Fork();
    static volatile Fork fork3 = new Fork();
    static volatile Fork fork4 = new Fork();
    static volatile Fork fork5 = new Fork();

    public static void main(String[] args) {

        Thread t1 = new Thread(new Philosopher(fork1, fork2));
        Thread t2 = new Thread(new Philosopher(fork2, fork3));
        Thread t3 = new Thread(new Philosopher(fork3, fork4));
        Thread t4 = new Thread(new Philosopher(fork4, fork5));
        Thread t5 = new Thread(new Philosopher(fork5, fork1));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}