public class ZeroEvenOdd {
    private int n;
    private Semaphore zerosem = new Semaphore(1);
    private Semaphore evensem = new Semaphore(0);
    private Semaphore oddsem = new Semaphore(0);
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i++){
            zerosem.acquire();
            printNumber.accept(0);
            if(i%2==0)evensem.release();
            else oddsem.release();
        }
        
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2;i<=n;i+=2){
            evensem.acquire();
            printNumber.accept(i);
            zerosem.release();
        }
        
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i+=2){
            oddsem.acquire();
            printNumber.accept(i);
            zerosem.release();
        }
        
    }
}