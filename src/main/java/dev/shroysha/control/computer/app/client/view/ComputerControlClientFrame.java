package dev.shroysha.control.computer.app.client.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;


public class ComputerControlClientFrame extends JFrame {

    private final JPanel contentPane = new JPanel(new BorderLayout());
    private final JPanel inputPanel = new JPanel();
    private final JScrollPane scrollPane = new JScrollPane();
    private final JTextArea messageBox = new JTextArea();
    private final JTextField inputField = new JTextField();
    private final JButton sendButton = new JButton("Send");

    public ComputerControlClientFrame() {
        super("Terminal");
        init();
    }

    public static String getCurrentDateString() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        return date.toString();
    }

    private void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        messageBox.setEditable(false);
        messageBox.setLineWrap(true);
        messageBox.setWrapStyleWord(true);
        messageBox.setBackground(Color.BLACK);
        messageBox.setForeground(Color.GREEN);
        scrollPane.setBackground(Color.BLACK);
        scrollPane.setViewportView(messageBox);

        sendButton.setBackground(Color.BLACK);
        inputField.setBackground(Color.BLACK);
        inputField.setForeground(Color.GREEN);
        inputPanel.setBackground(Color.BLACK);
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(Color.BLACK);
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        inputField.addActionListener(ae -> sendButton.doClick());
        sendButton.addActionListener(ae -> {
            sendCommand(inputField.getText().trim());
            inputField.setText("");
        });

        this.add(contentPane, BorderLayout.CENTER);
        this.setSize(400, 300);
    }

    private void sendCommand(String command) {
        try {
            // TODO: send command
            messageBox.append("Sent " + command + " at " + getCurrentDateString() + "\n");
            // TODO: receive response
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            messageBox.append("Exception thrown while sending command:" + command + "\n");
            messageBox.append(ex.getMessage());
            StackTraceElement[] stackTrace = ex.getStackTrace();
            for (StackTraceElement ele : stackTrace) {
                messageBox.append(ele.toString() + "\n");
            }
        }
    }

    public void receiveResponse(String response) {
        messageBox.append("Received \"" + response + "\" @ " + getCurrentDateString() + "\n");
    }

}
