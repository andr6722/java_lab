
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedData {
    private String data;
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Integer countWriter = 0;

    public void read() {
        readWriteLock.readLock().lock();
        try {
            // Логика для чтения данных
            System.out.println(Thread.currentThread().getName() + " started.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished read: " + data);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void write(String newData) {
        readWriteLock.writeLock().lock();
        try {
            // Логика для записи данных
            System.out.println(Thread.currentThread().getName() + " started");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished write: " + newData);
            data = newData;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}