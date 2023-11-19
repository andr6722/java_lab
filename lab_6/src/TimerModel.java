import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

class TimerModel {
    private LocalTime alarmTime;
    private ActionListener action;
    private int timeRemaining;
    private boolean isRunning;

    public TimerModel() {
        timeRemaining = 0;
        isRunning = false;
    }

    public void setTime(int time) {
        timeRemaining = time;
    }

    public int getTime() {
        return timeRemaining;
    }

    public void decrementTime() {
        timeRemaining--;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public void setAlarmTime(LocalTime alarmTime){
        this.alarmTime = alarmTime;
    }

    public void setActionListener(ActionListener action) {
        this.action = action;
    }

    public void checkAlarmTime() {
        if (LocalTime.now().isAfter(alarmTime)) {
            action.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
        }
    }
}