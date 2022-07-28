package ch.tacocat.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.Objects;

public class console {
    public JPanel panelConsole;
    private JTextArea textAreaConsole;
    private JTextField textFieldInput;
    private JScrollPane scrollPaneConsole;

    public console() { textFieldInput.addKeyListener(new KeyAdapter() { } );
        textFieldInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Objects.equals(textFieldInput.getText(), ".exit")) {
                    System.exit(0);
                    ConsoleWrite("Bruh, gn");
                }
                ConsoleWrite(textFieldInput.getText());
                ScrollToCaret();
                textFieldInput.setText("");
            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void ConsoleWrite(String input) {
        textAreaConsole.append(input + "\n");
        ScrollToCaret();
    }

    private void ScrollToCaret() {
        textAreaConsole.setCaretPosition(textAreaConsole.getDocument().getLength());
    }
}
