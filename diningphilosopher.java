public class DiningPhilosophers {

    private final Object[] forks = new Object[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new Object();
        }
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;

        Object firstFork = forks[Math.min(leftFork, rightFork)];
        Object secondFork = forks[Math.max(leftFork, rightFork)];

        synchronized (firstFork) {
            synchronized (secondFork) {

                pickLeftFork.run();
                pickRightFork.run();

                eat.run();

                putLeftFork.run();
                putRightFork.run();
            }
        }
    }
}
