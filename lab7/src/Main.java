// Пример использования
public class Main {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread readerThread1 = new Thread(() -> {
            sharedData.read();
        }, "Read1");

        Thread readerThread2 = new Thread(() -> {
            sharedData.read();
        }, "Read2");

        Thread readerThread3 = new Thread(() -> {
            sharedData.read();
        }, "Read3");

        Thread readerThread4 = new Thread(() -> {
            sharedData.read();
        }, "Read4");

        Thread writerThread1 = new Thread(() -> {
            sharedData.write("data1");
        }, "Writer1");

        Thread writerThread2 = new Thread(() -> {
            sharedData.write("Data2");
        }, "Writer2");

        readerThread1.start();
        readerThread2.start();
        writerThread1.start();
        readerThread3.start();
        readerThread4.start();
        writerThread2.start();
    }
}