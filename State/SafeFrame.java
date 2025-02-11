import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.TextArea;
import java.awt.TextField;

public class SafeFrame extends Frame implements ActionListener, Context {
    private TextField textClock = new TextField(60); // Current time display
    private TextArea textScreen = new TextArea(10, 60); // Security center display
    private Button buttonUse = new Button("Use safe"); // Safe use button
    private Button buttonAlarm = new Button("Alarm bell"); // Alarm button
    private Button buttonPhone = new Button("Call"); // Phone button
    private Button buttonExit = new Button("Exit"); // Exit button

    private State state = DayState.getInstance(); // Current state

    public SafeFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        // Add textClock to the north end of the window
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);
        // Add textScreen to the center of the window
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);
        // Create a panel p for the buttons
        Panel panel = new Panel();
        // Add buttons to the panel
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        // Add the panel to the south end of the window
        add(panel, BorderLayout.SOUTH);
        // Display
        pack();
        setVisible(true);
        // Set listeners
        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }

    // Button click event
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        if (e.getSource() == buttonUse) { // Safe use button
            state.doUse(this);
        } else if (e.getSource() == buttonAlarm) { // Alarm button
            state.doAlarm(this);
        } else if (e.getSource() == buttonPhone) { // Phone button
            state.doPhone(this);
        } else if (e.getSource() == buttonExit) { // Exit button
            System.exit(0);
        } else {
            System.out.println("?");
        }
    }

    // Set the time
    @Override
    public void setClock(int hour) {
        String clockstring = "Current time is ";
        if (hour < 10) {
            clockstring += "0" + hour + ":00";
        } else {
            clockstring += hour + ":00";
        }
        System.out.println(clockstring);
        textClock.setText(clockstring);
        state.doClick(this, hour);
    }

    // Change state
    @Override
    public void changeState(State state) {
        System.out.println(this.state + " -> " + state);
        this.state = state;
    }

    // Call the security center
    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append("call! " + msg + "\n");
    }

    // Record log
    @Override
    public void recordLog(String msg) {
        textScreen.append("record ... " + msg + "\n");
    }
}