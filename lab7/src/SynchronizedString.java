public class SynchronizedString {
    private String data;

    // синхронный метод записи
    public synchronized void write(String newData){
        while (data != null){
            try {
                wait(); // если переменная уже занята, поток блокируется с помощью вызова wait()
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        // записываем новые данные
        data = newData;
        notifyAll(); // уведомляем ожидающих читателей
    }

    //синхронный медот чтения
    public synchronized String read(){
        while(data == null){
            try{
                // Если записи нет, ждем ее
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        // читаем данные
        String result = data;
        data = null;
        notifyAll();
        return result;
    }
}
