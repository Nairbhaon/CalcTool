package CalcTool;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class CalcTool
{
    public static void main(String[] args) throws Exception {

        //window
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Calc Tool");
        window.setSize(800, 640);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.add(new MainPanel());
        window.setVisible(true);
    }    
}