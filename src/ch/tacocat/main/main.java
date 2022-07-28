package ch.tacocat.main;

import ch.tacocat.gui.console;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) {
        System.out.println("main function here, we have lift off!");

        try {
            //Starting new console Window
            console cns = new console();
            JFrame formConsole = new JFrame("Console");
            formConsole.setContentPane(cns.panelConsole);
            formConsole.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            formConsole.pack();
            formConsole.setVisible(true);
            cns.ConsoleWrite("Console has started successfully!");

            //start application process
            String application = "C:\\Users\\802042\\IdeaProjects\\application_console\\out\\artifacts\\application_example\\application_console.jar";
            ProcessBuilder appBuild = new ProcessBuilder("java.exe", "-jar", application);
            appBuild.redirectErrorStream(true);
            Process app = appBuild.start();

            BufferedReader appIn = new BufferedReader(new InputStreamReader(app.getInputStream()));



            //Starting new application runner Tread
            new Thread(() -> {
                String line;
                while (app.isAlive()) {
                    try{
                        while((line = appIn.readLine()) != null){
                            cns.ConsoleWrite(line);
                        }
                    } catch (Exception e) {
                        cns.ConsoleWrite("failed to read :(");
                        break;
                    }
                }
            }).start();

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to start console :(");
        }
    }
}
