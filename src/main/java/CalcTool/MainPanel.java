package CalcTool;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Implemented the GUI part of the Math GPT
 * @author Kenjie DeCastro, Shoyo Ko, Yichen Hu, Nairbhaon Durand
 * @version 9/16/2023
 */
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
        inputInstruction.setFont(new Font("Tahoma", Font.BOLD, 24));
        inputInstruction.setPreferredSize(new Dimension(760, 50));
        this.add(inputInstruction);

        //input
        JTextArea input = new JTextArea("");
        input.setFont(input.getFont().deriveFont(15f));
        input.setEditable(true);
        input.setPreferredSize(new Dimension(640, 25));
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
        clear.setPreferredSize(new Dimension(110, 25));
        this.add(clear);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(760, 280));
        buttonPanel.setLayout(new GridLayout(0, 9));
        this.add(Box.createRigidArea(new Dimension(760, 10)));
        this.add(buttonPanel);

        JLabel tokenInstruction = new JLabel("Enter API Key here");
        tokenInstruction.setFont(new Font("Tahoma", Font.BOLD, 12));
        tokenInstruction.setPreferredSize(new Dimension(760, 20));
        this.add(Box.createRigidArea(new Dimension(760, 10)));
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
        this.add(Box.createRigidArea(new Dimension(760, 10)));
        scroll.setPreferredSize(new Dimension(760, 80));
        this.add(scroll);

        JButton one = new JButton("1");
        one.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        two.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        three.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        four.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        five.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        six.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        seven.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        eight.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        nine.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        zero.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        plus.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        minus.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        multiply.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        divide.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        enter.setFont(new Font("Tahoma", Font.BOLD, 17));
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
                    else if (inputMessage.toUpperCase().equals("RICKROLL") ||
                            inputMessage.toUpperCase().equals("NEVER GONNA GIVE YOU UP") ||
                            inputMessage.toUpperCase().equals("NGGYU") ||
                            inputMessage.toUpperCase().equals("RICK ROLL"))
                    {
                        openURL("https://www.youtube.com/watch?v=xvFZjo5PgG0");
                        System.exit(0);
                    }
                    else if (inputMessage.toUpperCase().equals("JINITAIMEI") ||
                            inputMessage.toUpperCase().equals("JI NI TAI MEI") ||
                            inputMessage.toUpperCase().equals("JNTM") ||
                            inputMessage.toUpperCase().equals("CXK"))
                    {
                        openURL("https://www.youtube.com/watch?v=FrMMQW0fygo");
                        System.exit(0);
                    }
                    else if (token.isEmpty())
                    {
                        output.setText("No API key received");
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
        root.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        rootOf.setFont(new Font("Tahoma", Font.BOLD, 17));
        rootOf.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    if(inputMessage.isEmpty())
                    {
                        inputMessage += " th root of ";
                    }
                    else
                    {
                        switch(inputMessage.charAt(inputMessage.length() - 1)) {
                            case '1':
                                if (inputMessage.length() > 1) {
                                    if (inputMessage.charAt(inputMessage.length() - 2) == '1')
                                        inputMessage += "th root of ";
                                    else
                                        inputMessage += "st root of ";
                                } else
                                    inputMessage += "st root of ";
                                break;
                            case '2':
                                if (inputMessage.length() > 1) {
                                    if (inputMessage.charAt(inputMessage.length() - 2) == '1')
                                        inputMessage += "th root of ";
                                    else
                                        inputMessage += "nd root of ";
                                } else
                                    inputMessage += "nd root of ";
                                break;
                            case '3':
                                if (inputMessage.length() > 1) {
                                    if (inputMessage.charAt(inputMessage.length() - 2) == '1')
                                        inputMessage += "th root of ";
                                    else
                                        inputMessage += "rd root of ";
                                } else
                                    inputMessage += "rd root of ";
                                break;
                            default:
                                inputMessage += "th root of ";
                        }
                    }
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton equal = new JButton("=");
        equal.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        less.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        larger.setFont(new Font("Tahoma", Font.BOLD, 17));
        larger.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        lessEqual.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        largerEqual.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        power.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        absolute.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        leftPar.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        rightPar.setFont(new Font("Tahoma", Font.BOLD, 17));
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

        JButton logn = new JButton("log");
        logn.setFont(new Font("Tahoma", Font.BOLD, 17));
        logn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += " log () of () ";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton ln = new JButton("ln");
        ln.setFont(new Font("Tahoma", Font.BOLD, 17));
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
        comma.setFont(new Font("Tahoma", Font.BOLD, 17));
        comma.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += ", ";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton dot = new JButton(".");
        dot.setFont(new Font("Tahoma", Font.BOLD, 17));
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

        JButton infinity = new JButton("∞");
        infinity.setFont(new Font("Tahoma", Font.BOLD, 17));
        infinity.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "∞";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton x = new JButton("x");
        x.setFont(new Font("Tahoma", Font.BOLD, 17));
        x.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "x";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton y = new JButton("y");
        y.setFont(new Font("Tahoma", Font.BOLD, 17));
        y.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "y";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton z = new JButton("z");
        z.setFont(new Font("Tahoma", Font.BOLD, 17));
        z.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "z";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton θ = new JButton("θ");
        θ.setFont(new Font("Tahoma", Font.BOLD, 17));
        θ.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "θ";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton modulus = new JButton("%");
        modulus.setFont(new Font("Tahoma", Font.BOLD, 17));
        modulus.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += " % ";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton sin = new JButton("sin");
        sin.setFont(new Font("Tahoma", Font.BOLD, 17));
        sin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "sin";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton cos = new JButton("cos");
        cos.setFont(new Font("Tahoma", Font.BOLD, 17));
        cos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "cos";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton tan = new JButton("tan");
        tan.setFont(new Font("Tahoma", Font.BOLD, 17));
        tan.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "tan";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton sec = new JButton("sec");
        sec.setFont(new Font("Tahoma", Font.BOLD, 17));
        sec.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "sec";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton csc = new JButton("csc");
        csc.setFont(new Font("Tahoma", Font.BOLD, 17));
        csc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "csc";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton cot = new JButton("cot");
        cot.setFont(new Font("Tahoma", Font.BOLD, 17));
        cot.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "cot";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton defIntegral = new JButton("def ∫");
        defIntegral.setFont(new Font("Tahoma", Font.BOLD, 17));
        defIntegral.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += " ∫()dx with bounds () to () ";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton indefIntegral = new JButton("indef ∫");
        indefIntegral.setFont(new Font("Tahoma", Font.BOLD, 14));
        indefIntegral.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += " ∫()dx ";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton dydx = new JButton("dydx");
        dydx.setFont(new Font("Tahoma", Font.BOLD, 17));
        dydx.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += " dy/dx()";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });


        JButton arcsin = new JButton("arcsin");
        arcsin.setFont(new Font("Tahoma", Font.BOLD, 15));
        arcsin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "arcsin";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton arccos = new JButton("arccos");
        arccos.setFont(new Font("Tahoma", Font.BOLD, 15));
        arccos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "arccos";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton arctan = new JButton("arctan");
        arctan.setFont(new Font("Tahoma", Font.BOLD, 15));
        arctan.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "arctan";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton arcsec = new JButton("arcsec");
        arcsec.setFont(new Font("Tahoma", Font.BOLD, 15));
        arcsec.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "arcsec";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton arccsc = new JButton("arccsc");
        arccsc.setFont(new Font("Tahoma", Font.BOLD, 15));
        arccsc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "arccsc";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton arccot = new JButton("arccot");
        arccot.setFont(new Font("Tahoma", Font.BOLD, 15));
        arccot.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "arccot";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton limit = new JButton("lim");
        limit.setFont(new Font("Tahoma", Font.BOLD, 17));
        limit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += " lim x → () ";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton e = new JButton("e");
        e.setFont(new Font("Tahoma", Font.BOLD, 17));
        e.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "e^";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton pi = new JButton("\u03C0");
        pi.setFont(new Font("Times New Roman", Font.BOLD, 17));
        pi.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += " \u03C0 ";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton sum = new JButton("\u2211");
        sum.setFont(new Font("Tahoma", Font.BOLD, 17));
        sum.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += " \u2211 () from () to ()";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton partialDev = new JButton("\u2202");
        partialDev.setFont(new Font("Tahoma", Font.BOLD, 17));
        partialDev.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += " \u2202/\u2202x()";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton doubleDefInt = new JButton("def \u222B\u222B");
        doubleDefInt.setFont(new Font("Tahoma", Font.BOLD, 16));
        doubleDefInt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += " \u222C()dxdy from () to () and () to ()";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton doubleInt = new JButton("indef \u222B\u222B");
        doubleInt.setFont(new Font("Tahoma", Font.BOLD, 12));
        doubleInt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "\u222C()dxdy";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton tripleDefInt = new JButton("def \u222B\u222B\u222B");
        tripleDefInt.setFont(new Font("Tahoma", Font.BOLD, 12));
        tripleDefInt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += " \u222D()dxdydz from () to () and () to ()";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton tripleInt = new JButton("indef \u222B\u222B\u222B");
        tripleInt.setFont(new Font("Tahoma", Font.BOLD, 10));
        tripleInt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += " \u222D()dxdydz";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton twoDVec = new JButton("( , )");
        twoDVec.setFont(new Font("Tahoma", Font.BOLD, 10));
        twoDVec.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "( , )";
                    input.setText(inputMessage);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton threeDVec = new JButton("( , , )");
        threeDVec.setFont(new Font("Tahoma", Font.BOLD, 10));
        threeDVec.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    inputMessage += "( , , )";
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
        buttonPanel.add(infinity);
        buttonPanel.add(x);
        buttonPanel.add(y);
        buttonPanel.add(z);
        buttonPanel.add(θ);
        buttonPanel.add(modulus);

        buttonPanel.add(sin);
        buttonPanel.add(cos);
        buttonPanel.add(tan);
        buttonPanel.add(sec);
        buttonPanel.add(csc);
        buttonPanel.add(cot);
        buttonPanel.add(defIntegral);
        buttonPanel.add(indefIntegral);
        buttonPanel.add(doubleDefInt);

        buttonPanel.add(doubleInt);
        buttonPanel.add(tripleDefInt);
        buttonPanel.add(tripleInt);
        buttonPanel.add(dydx);
        buttonPanel.add(partialDev);
        buttonPanel.add(arcsin);
        buttonPanel.add(arccos);
        buttonPanel.add(arctan);
        buttonPanel.add(arcsec);

        buttonPanel.add(arccsc);
        buttonPanel.add(arccot);
        buttonPanel.add(limit);
        buttonPanel.add(e);
        buttonPanel.add(pi);
        buttonPanel.add(twoDVec);
        buttonPanel.add(threeDVec);
        buttonPanel.add(sum);
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
                AudioSystem.getAudioInputStream(new File("src\\Troll\\" + name));
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }

    public void openURL(String url)
    {
        try
        {
            Desktop.getDesktop().browse(new URL(url).toURI());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}