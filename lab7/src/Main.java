// Пример использования
public class Main {
    public static void main(String[] args) {
        final SynchronizedString synchronizedString = new SynchronizedString();

        // Поток-писатель
        Thread writerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedString.write("Hello, World!");
            }
        });

        // Поток-читатель
        Thread readerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String data = synchronizedString.read();
                System.out.println("Read: " + data);
            }
        });

        // Запускаем потоки
        writerThread.start();
        readerThread.start();
    }
}