import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
public class MainPanel extends JPanel
{
    private String inputMessage = "";
    private String inputPrompt = "";
    private String token = "";

    public MainPanel()
    {
        //this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        //input
        JTextArea input = new JTextArea("Please enter your question");
        input.setEditable(true);
        input.setPreferredSize(new Dimension(460, 40));
        input.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(input);

        //button 
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 7));
        this.add(Box.createRigidArea(new Dimension(5, 20)));
        this.add(buttonPanel);

        //token input
        JTextArea tokenInput = new JTextArea("Enter API Key here", 1, 1);
        tokenInput.setBorder(BorderFactory.createLineBorder(Color.black));
        JPanel tokenPanel = new JPanel(new GridLayout(1,1));
        tokenPanel.add(tokenInput);
        this.add(Box.createRigidArea(new Dimension(5, 20)));
        this.add(tokenPanel);

        //output
        JTextArea output = new JTextArea("Output will be displayed here", 1, 1);
        output.setEditable(false);
        JPanel test = new JPanel();
        JScrollPane scroll = new JScrollPane(output);
        scroll.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(Box.createRigidArea(new Dimension(5, 20)));
        this.add(scroll);

        JButton one = new JButton("1");
        one.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) 
            { 
                try 
                {
                    inputMessage += "1";
                    inputPrompt += "1";
                    input.setText(inputMessage);
                } 
                catch (Exception e1) 
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton two = new JButton("2");
        two.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) 
            { 
                try 
                {
                    inputMessage += "2";
                    inputPrompt += "2";
                    input.setText(inputMessage);
                } 
                catch (Exception e1) 
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton three = new JButton("3");
        three.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) 
            { 
                try 
                {
                    inputMessage += "3";
                    inputPrompt += "3";
                    input.setText(inputMessage);
                } 
                catch (Exception e1) 
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton four = new JButton("4");
        four.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) 
            { 
                try 
                {
                    inputMessage += "4";
                    inputPrompt += "4";
                    input.setText(inputMessage);
                } 
                catch (Exception e1) 
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton five = new JButton("5");
        five.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) 
            { 
                try 
                {
                    inputMessage += "5";
                    inputPrompt += "5";
                    input.setText(inputMessage);
                } 
                catch (Exception e1) 
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton six = new JButton("6");
        six.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) 
            { 
                try 
                {
                    inputMessage += "6";
                    inputPrompt += "6";
                    input.setText(inputMessage);
                } 
                catch (Exception e1) 
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton seven = new JButton("7");
        seven.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) 
            { 
                try 
                {
                    inputMessage += "7";
                    inputPrompt += "7";
                    input.setText(inputMessage);
                } 
                catch (Exception e1) 
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton eight = new JButton("8");
        eight.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) 
            { 
                try 
                {
                    inputMessage += "8";
                    inputPrompt += "8";
                    input.setText(inputMessage);
                } 
                catch (Exception e1) 
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton nine = new JButton("9");
        nine.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) 
            { 
                try 
                {
                    inputMessage += "9";
                    inputPrompt += "9";
                    input.setText(inputMessage);
                } 
                catch (Exception e1) 
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton zero = new JButton("0");
        zero.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) 
            { 
                try 
                {
                    inputMessage += "0";
                    inputPrompt += "0";
                    input.setText(inputMessage);
                } 
                catch (Exception e1) 
                {
                    e1.printStackTrace();
                }
            }
        });
        
        JButton plus = new JButton("+");
        plus.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) 
            { 
                try 
                {
                    inputMessage += "+";
                    inputPrompt += "+";
                    input.setText(inputMessage);
                } 
                catch (Exception e1) 
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton minus = new JButton("-");
        minus.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) 
            { 
                try 
                {
                    inputMessage += "-";
                    inputPrompt += "-";
                    input.setText(inputMessage);
                } 
                catch (Exception e1) 
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton multiply = new JButton("\u00D7");
        multiply.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) 
            { 
                try 
                {
                    inputMessage += "\u00D7";
                    inputPrompt += "\u00D7";
                    input.setText(inputMessage);
                } 
                catch (Exception e1) 
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton divide = new JButton("\u00F7");
        divide.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) 
            { 
                try 
                {
                    inputMessage += "\u00F7";
                    inputPrompt += "\u00F7";
                    input.setText(inputMessage);
                } 
                catch (Exception e1) 
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton backspace = new JButton("\u232B");
        backspace.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    if(inputMessage.length() > 1)
                    {
                        inputMessage = inputMessage.substring(0, inputMessage.length() - 1);
                        inputPrompt = inputPrompt.substring(0, inputPrompt.length() - 1);     //fix later
                        input.setText(inputMessage);
                    }
                    else if(inputMessage.length() == 1)
                    {
                        inputMessage = "";
                        inputPrompt += "";
                        input.setText("Please enter your question");
                    }
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton clear = new JButton("Clear");
        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage = "";
                    inputPrompt += "";
                    input.setText("Please enter your question");
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton enter = new JButton("Enter");
        enter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    token = tokenInput.getText();
                    if (inputMessage.isEmpty())
                    {
                        output.setText("No input received");
                    }
                    else if (token.isEmpty())
                    {
                        output.setText("No Token received");
                    }
                    else
                    {
                        output.setText("Please wait for the answer to be generated");
                        output.setText(ChatInterface.explainEquation(token, inputPrompt));
                    }
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        buttonPanel.add(one);
        buttonPanel.add(two);
        buttonPanel.add(three);
        buttonPanel.add(plus);
        buttonPanel.add(minus);
        buttonPanel.add(multiply);
        buttonPanel.add(divide);

        buttonPanel.add(four);
        buttonPanel.add(five);
        buttonPanel.add(six);

        buttonPanel.add(seven);
        buttonPanel.add(eight);
        buttonPanel.add(nine);

        buttonPanel.add(zero);
        buttonPanel.add(backspace);
        buttonPanel.add(clear);
        buttonPanel.add(enter);
    }
}