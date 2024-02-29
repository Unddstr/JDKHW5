public class Fork {
    private static int count = 0;
    private final int ID;
    private volatile boolean forkIsOnTheTable;

    public Fork() {
        count++;
        ID = count;
        forkIsOnTheTable = true;
    }

    public void takeFork() {
        forkIsOnTheTable = false;
    }

    public void putDownTheFork() {
        forkIsOnTheTable = true;
    }

    public boolean checkFork() {
        return forkIsOnTheTable;
    }

    @Override
    public String toString() {
        return "№" + ID;
    }
}
