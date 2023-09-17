package CalcTool;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MainPanel extends JPanel
{
    private String inputMessage = "";
    private String token = "";

    private Clip clip;

    public MainPanel() throws Exception
    {
        setClip("Kahoot.wav");

        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel inputInstruction = new JLabel("Please enter your question");
        inputInstruction.setPreferredSize(new Dimension(760, 20));
        this.add(inputInstruction);

        //input
        JTextArea input = new JTextArea("");
        input.setEditable(true);
        input.setFont(new Font("TimesRoman", Font.BOLD, 24));
        input.setPreferredSize(new Dimension(640, 40));
        input.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(input);

        input.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                try {
                    changed(e);
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
            }

            public void removeUpdate(DocumentEvent e) {
                try {
                    changed(e);
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
            }

            public void changedUpdate(DocumentEvent e) {
                try {
                    changed(e);
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
            }
            public void changed(DocumentEvent e) throws BadLocationException {
                inputMessage = e.getDocument().getText(0,e.getDocument().getLength());
            }
        });
        this.add(input);

        JButton clear = new JButton("Clear");
        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage = "";
                    input.setText("");
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        clear.setPreferredSize(new Dimension(110, 40));
        this.add(clear);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(760, 280));
        buttonPanel.setLayout(new GridLayout(0, 9));
        this.add(Box.createRigidArea(new Dimension(5, 10)));
        this.add(buttonPanel);

        JLabel tokenInstruction = new JLabel("Enter API Key here");
        tokenInstruction.setPreferredSize(new Dimension(760, 20));
        this.add(Box.createRigidArea(new Dimension(5, 10)));
        this.add(tokenInstruction);

        JTextArea tokenInput = new JTextArea();
        tokenInput.setBorder(BorderFactory.createLineBorder(Color.black));
        tokenInput.setPreferredSize(new Dimension(760, 20));
        JPanel tokenPanel = new JPanel(new GridLayout(1,1));
        tokenPanel.add(tokenInput);
        this.add(tokenPanel);

        JTextArea output = new JTextArea("Output will be displayed here", 1, 1);
        output.setEditable(false);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(output);
        scroll.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(Box.createRigidArea(new Dimension(5, 10)));
        scroll.setPreferredSize(new Dimension(760, 80));
        this.add(scroll);

        JButton one = new JButton("1");
        one.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) 
            { 
                try 
                {
                    inputMessage += "1";
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
                    inputMessage += " + ";
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
                    inputMessage += " - ";
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
                    inputMessage += " \u00D7 ";
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
                    inputMessage += " \u00F7 ";
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
                    if(inputMessage.length() > 0)
                    {
                        inputMessage = inputMessage.substring(0, inputMessage.length() - 1);
                        input.setText(inputMessage);
                    }
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
                        output.setText(ChatInterface.explainEquation(token, inputMessage));
                    }
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton root = new JButton("\u221A");
        root.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "\u221A";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton rootOf = new JButton("n\u221Ax");
        rootOf.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += " root of ";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton equal = new JButton("=");
        equal.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += " = ";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton less = new JButton("<");
        less.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += " < ";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton larger = new JButton(">");
        larger.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += " > ";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton lessEqual = new JButton("<=");
        lessEqual.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += " <= ";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton largerEqual = new JButton(">=");
        largerEqual.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += " >= ";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton power = new JButton("^");
        power.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "^";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton absolute = new JButton("|");
        absolute.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "|";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton leftPar = new JButton("(");
        leftPar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "(";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton rightPar = new JButton(")");
        rightPar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += ")";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton logn = new JButton("log n");
        logn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "log of _ in base _";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton ln = new JButton("ln");
        ln.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += " ln ";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton comma = new JButton(",");
        comma.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += ",";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton dot = new JButton(".");
        dot.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += ".";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        buttonPanel.add(seven);
        buttonPanel.add(eight);
        buttonPanel.add(nine);
        buttonPanel.add(plus);
        buttonPanel.add(minus);
        buttonPanel.add(multiply);
        buttonPanel.add(divide);
        buttonPanel.add(equal);
        buttonPanel.add(backspace);

        buttonPanel.add(four);
        buttonPanel.add(five);
        buttonPanel.add(six);
        buttonPanel.add(less);
        buttonPanel.add(larger);
        buttonPanel.add(lessEqual);
        buttonPanel.add(largerEqual);
        buttonPanel.add(power);
        buttonPanel.add(absolute);

        buttonPanel.add(one);
        buttonPanel.add(two);
        buttonPanel.add(three);
        buttonPanel.add(root);
        buttonPanel.add(rootOf);
        buttonPanel.add(leftPar);
        buttonPanel.add(rightPar);
        buttonPanel.add(logn);
        buttonPanel.add(ln);

        buttonPanel.add(comma);
        buttonPanel.add(zero);
        buttonPanel.add(dot);
        buttonPanel.add(enter);
    }

    public void setClip(String name)
            throws Exception
    {
        if (clip != null)
        {
            clip.close();
        }
        AudioInputStream audioInputStream =
                AudioSystem.getAudioInputStream(new File("src\\BGM\\" + name));
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }
}