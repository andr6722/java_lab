import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class TimerController {
    private TimerModel model;
    private TimerView view;
    private Timer timer;

    public TimerController(TimerModel model, TimerView view) {
        this.model = model;
        this.view = view;

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalTime alarmTime = view.getAlarmTime();
                model.setAlarmTime(alarmTime);
                model.checkAlarmTime();
            }
        });

        model.setActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.showMessage("Time is up alarm!");
            }
        });

        this.view.setStartButtonActionListener(new StartButtonListener());
        this.view.setPauseButtonActionListener(new PauseButtonListener());
        this.view.setResetButtonActionListener(new ResetButtonListener());
    }

    class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!model.isRunning()) {
                try {
                    int time = Integer.parseInt(view.getTime());
                    model.setTime(time);
                    timer = new Timer();
                    timer.start();
                    model.setRunning(true);
                } catch (NumberFormatException ex) {
                    view.showMessage("Invalid time format");
                }
            }
        }
    }

    class PauseButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (model.isRunning()) {
                timer.stop();
                model.setRunning(false);
            }
        }
    }

    // ActionListener for the Reset button
    class ResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!model.isRunning()) {
                view.setTime("");
            }
        }
    }

    // Timer thread
    class Timer extends Thread {
        @Override
        public void run() {
            while (model.getTime() > 0) {
                if (!model.isRunning()) {
                    break;
                }

                model.decrementTime();
                view.setTime(String.valueOf(model.getTime()));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (model.getTime() == 0) {
                view.showMessage("Time is up!");
                model.setRunning(false);
            }
        }
    }
}