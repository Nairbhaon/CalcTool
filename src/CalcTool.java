import javax.swing.*;
public class calcTool
{
    public static void main(String[] args)
    {

        //window
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Calc Tool");
        window.setSize(500, 400);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.add(new mainPanel());
        window.setVisible(true);
    }    
}
