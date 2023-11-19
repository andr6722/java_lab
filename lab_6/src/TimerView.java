import javax.swing.*;
import java.awt.event.ActionListener;
import java.time.LocalTime;


public class TimerView {

    private JFrame frame;
    private JTextField timeField;
    private JButton startButton;
    private JButton pauseButton;
    private JButton resetButton;
    private JTextField hoursField;
    private JTextField minutesField;
    private JButton setButton;
    public TimerView(){
        frame = new JFrame("Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();

        hoursField = new JTextField(2);
        minutesField = new JTextField(2);
        setButton = new JButton("Set Alarm");

        panel.add(new JLabel("Hours:"));
        panel.add(hoursField);
        panel.add(new JLabel("Minutes:"));
        panel.add(minutesField);
        panel.add(setButton);

        timeField = new JTextField(10);
        panel.add(timeField);

        startButton = new JButton("Start");
        panel.add(startButton);

        pauseButton = new JButton("Pause");
        panel.add(pauseButton);

        resetButton = new JButton("Reset");
        panel.add(resetButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public String getTime() {
        return timeField.getText();
    }

    public void setTime(String time) {
        timeField.setText(time);
    }

    public void setStartButtonActionListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    public void setPauseButtonActionListener(ActionListener listener) {
        pauseButton.addActionListener(listener);
    }

    public void setResetButtonActionListener(ActionListener listener) {
        resetButton.addActionListener(listener);
    }


    public LocalTime getAlarmTime() {
        int hours = Integer.parseInt(hoursField.getText().trim());
        int minutes = Integer.parseInt(minutesField.getText().trim());
        return LocalTime.of(hours, minutes);
    }

    public void addActionListener(ActionListener action) {
        setButton.addActionListener(action);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

}