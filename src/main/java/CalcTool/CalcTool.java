package CalcTool;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

/**
 * Implemented the GUI part of the Math GPT
 * @author Kenjie DeCastro, Shoyo Ko, Yichen Hu, Nairbhaon Durand
 * @version 9/16/2023
 */
@SpringBootApplication
public class CalcTool
{
    public static void main(String[] args) throws Exception {

        //window
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("MATH GPT");
        window.setSize(800, 640);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.add(new MainPanel());
        window.setVisible(true);
    }    
}
