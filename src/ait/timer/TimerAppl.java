package ait.timer;

import ait.timer.task.Timer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimerAppl {
    public static void main(String[] args) throws IOException {
        Timer timer = new Timer();          // добавляем таймер
        Thread thread = new Thread(timer);  // положим в поток
        thread.setDaemon(true);          // этот поток остановит ОП
        thread.start();                 // запускаем поток
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // сканер
        while (true){
            System.out.println("Enter time  interval, or press q for exit");
            String str = br.readLine();
            if ("q".equalsIgnoreCase(str)){
                thread.interrupt();  // метод остановит поток
                break;
            }else {
                timer.setClockPeriod(Integer.parseInt(str));
            }
        }
        System.out.println("Main thread finished");
    }
}
