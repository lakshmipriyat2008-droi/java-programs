public class FooBar {
    private int n;
    private Semaphore foosem = new Semaphore(1);
    private Semaphore barsem = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            foosem.acquire();
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            barsem.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            barsem.acquire();
            
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            foosem.release();
        }
    }
}