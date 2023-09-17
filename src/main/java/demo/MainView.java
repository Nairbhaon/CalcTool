package demo;

import CalcTool.ChatInterface;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {
    public MainView() {
        // Initialize equation string
        final String[] equationString = {""};
        final String[] token = {""};

        //region Initializations
        // Initialize all the buttons required
        // Numbers
        var zero = new Button("0");
        var one = new Button("1");
        var two = new Button("2");
        var three = new Button("3");
        var four = new Button("4");
        var five = new Button("5");
        var six = new Button("6");
        var seven = new Button("7");
        var eight = new Button("8");
        var nine = new Button("9");

        // Variables
        var x = new Button("x");
        var y = new Button("y");
        var z = new Button("z");
        var theta = new Button("θ");
        var euler = new Button("e");
        var pi = new Button("π");

        // Basic Operations
        var plus = new Button("+");
        var minus = new Button("-");
        var times = new Button("×");
        var divide = new Button("÷");

        // Roots & Powers
        var sqrt = new Button("√");
        var nthRoot = new Button("n√x");
        var power = new Button("^");

        // Equal Signs
        var greater = new Button(">");
        var less = new Button("<");
        var greaterEqual = new Button("≥");
        var lessEqual = new Button("≤");
        var equals = new Button("=");

        // Trig
        var sin = new Button("sin");
        var cos = new Button("cos");
        var tan = new Button("tan");
        var sec = new Button("sec");
        var csc = new Button("csc");
        var cot = new Button("cot");
        var arcsin = new Button("arcsin");
        var arccos = new Button("arccos");
        var arctan = new Button("arctan");
        var arcsec = new Button("arcsec");
        var arccsc = new Button("arccsc");
        var arccot = new Button("arccot");

        // Derivative & Integral
        var derivative = new Button("dy/dx");
        var defIntegral = new Button("def∫");
        var indefIntegral = new Button("indef∫");
        var limit = new Button("lim");

        // Logarithms
        var log = new Button("log");
        var ln = new Button("ln");

        // Misc
        var abs = new Button("|");
        var frontPar = new Button("(");
        var backPar = new Button(")");
        var comma = new Button(",");
        var period = new Button(".");
        var infinity = new Button("∞");
        var percent = new Button("%");
        var backspace = new Button("⌫");

        // Initialize all the text fields
        // Equation Input Text Field
        TextArea equationInputArea = new TextArea("Equation");
        equationInputArea.setWidthFull();
        equationInputArea.setPlaceholder("Please Input your Equation Here");
        equationInputArea.setTooltipText("Type Equation Here");
        equationInputArea.setClearButtonVisible(true);
        equationInputArea.setMinHeight("100px");
        equationInputArea.setMaxHeight("150px");

        // Token Input Text Field
        TextArea tokenInputArea = new TextArea();
        tokenInputArea.setWidthFull();
        tokenInputArea.setLabel("Token");
        tokenInputArea.setPlaceholder("Please Input your ChatGPT API Token Here");
        tokenInputArea.setClearButtonVisible(true);
        tokenInputArea.setMinHeight("50px");
        tokenInputArea.setMaxHeight("75px");
        tokenInputArea.addValueChangeListener( e -> {
            token[0] = tokenInputArea.getValue();
        });

        // Equation Output Text Field
        TextArea equationOutputArea = new TextArea();
        equationOutputArea.setWidthFull();
        equationOutputArea.setLabel("Output");
        equationOutputArea.setValue("Equation Output Here");
        equationOutputArea.setTooltipText("Click to copy");
        equationOutputArea.setMinHeight("100px");
        equationOutputArea.setMaxHeight("150px");
        equationOutputArea.setReadOnly(true);

        //endregion

        // Website
        // Create a vertical layout
        VerticalLayout mainContent = new VerticalLayout();
        mainContent.setSizeFull();

        // Button for enter
        Button enterPrompt = new Button("Submit!");
        enterPrompt.addClickListener(e ->{
            equationOutputArea.setValue(ChatInterface.explainEquation(token[0], equationString[0]));
        });
        enterPrompt.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        enterPrompt.addThemeVariants(ButtonVariant.LUMO_LARGE);
        enterPrompt.setHeight("80px");


        // Create horizontal layout
        H1 title = new H1("MathGPT");
        HorizontalLayout equationInput = new HorizontalLayout(equationInputArea, enterPrompt);
        equationInput.setAlignSelf(Alignment.END, enterPrompt);
        equationInput.setWidthFull();
        HorizontalLayout inputFieldLineOne = new HorizontalLayout(seven, eight, nine, plus, minus, times, divide, equals, backspace);
        HorizontalLayout inputFieldLineTwo = new HorizontalLayout(four, five, six, less, greater, lessEqual, greaterEqual, power, abs);
        HorizontalLayout inputFieldLineThree = new HorizontalLayout(one, two, three, sqrt, nthRoot, frontPar, backPar, log, ln);
        HorizontalLayout inputFieldLineFour = new HorizontalLayout(comma, zero, period, infinity, x, y, z, theta, percent);
        HorizontalLayout inputFieldLineFive = new HorizontalLayout(sin, cos, tan, sec, csc, cot, defIntegral, indefIntegral, derivative);
        HorizontalLayout inputFieldLineSix = new HorizontalLayout(arcsin, arccos, arctan, arcsec, arccsc, arccot, limit, euler, pi);
        HorizontalLayout tokenInput = new HorizontalLayout(tokenInputArea);
        tokenInput.setWidthFull();
        HorizontalLayout equationOutput = new HorizontalLayout(equationOutputArea);
        equationOutput.setWidthFull();

        //region Button Listeners
        // Click Event Addition
        zero.addClickListener(e -> {
            equationString[0] += "0";
            equationInputArea.setValue(equationString[0]);
        });
        one.addClickListener(e -> {
            equationString[0] += "1";
            equationInputArea.setValue(equationString[0]);
        });
        two.addClickListener(e -> {
            equationString[0] += "2";
            equationInputArea.setValue(equationString[0]);
        });
        three.addClickListener(e -> {
            equationString[0] += "3";
            equationInputArea.setValue(equationString[0]);
        });
        four.addClickListener(e -> {
            equationString[0] += "4";
            equationInputArea.setValue(equationString[0]);
        });
        five.addClickListener(e -> {
            equationString[0] += "5";
            equationInputArea.setValue(equationString[0]);
        });
        six.addClickListener(e -> {
            equationString[0] += "6";
            equationInputArea.setValue(equationString[0]);
        });
        seven.addClickListener(e -> {
            equationString[0] += "7";
            equationInputArea.setValue(equationString[0]);
        });
        eight.addClickListener(e -> {
            equationString[0] += "8";
            equationInputArea.setValue(equationString[0]);
        });
        nine.addClickListener(e -> {
            equationString[0] += "9";
            equationInputArea.setValue(equationString[0]);
        });
        x.addClickListener(e -> {
            equationString[0] += "x";
            equationInputArea.setValue(equationString[0]);
        });
        y.addClickListener(e -> {
            equationString[0] += "y";
            equationInputArea.setValue(equationString[0]);
        });
        z.addClickListener(e -> {
            equationString[0] += "z";
            equationInputArea.setValue(equationString[0]);
        });
        theta.addClickListener(e -> {
            equationString[0] += "θ";
            equationInputArea.setValue(equationString[0]);
        });
        euler.addClickListener(e -> {
            equationString[0] += "e";
            equationInputArea.setValue(equationString[0]);
        });
        pi.addClickListener(e -> {
            equationString[0] += "π";
            equationInputArea.setValue(equationString[0]);
        });
        plus.addClickListener(e -> {
            equationString[0] += "+";
            equationInputArea.setValue(equationString[0]);
        });
        minus.addClickListener(e -> {
            equationString[0] += "-";
            equationInputArea.setValue(equationString[0]);
        });
        times.addClickListener(e -> {
            equationString[0] += "×";
            equationInputArea.setValue(equationString[0]);
        });
        divide.addClickListener(e -> {
            equationString[0] += "÷";
            equationInputArea.setValue(equationString[0]);
        });
        backspace.addClickListener(e -> {
            equationString[0] = equationString[0].substring(0 , equationString[0].length() - 1);
            equationInputArea.setValue(equationString[0]);
        });
        sqrt.addClickListener(e -> {
            equationString[0] += "√";
            equationInputArea.setValue(equationString[0]);
        });
        nthRoot.addClickListener(e -> {
            switch(equationString[0].charAt(equationString[0].length() - 1))
            {
                case '1':
                    if (equationString[0].length() > 1)
                    {
                        if (equationString[0].charAt(equationString[0].length() - 2) == '1')
                            equationString[0] += "th root of ";
                        else
                            equationString[0] += "st root of ";
                    }
                    else
                        equationString[0] += "st root of ";
                    break;
                case '2':
                    if (equationString[0].length() > 1)
                    {
                        if (equationString[0].charAt(equationString[0].length() - 2) == '1')
                            equationString[0] += "th root of ";
                        else
                            equationString[0] += "nd root of ";
                    }
                    else
                        equationString[0] += "nd root of ";
                    break;
                case '3':
                    if (equationString[0].length() > 1)
                    {
                        if (equationString[0].charAt(equationString[0].length() - 2) == '1')
                            equationString[0] += "th root of ";
                        else
                            equationString[0] += "rd root of ";
                    }
                    else
                        equationString[0] += "rd root of ";
                    break;
                default:
                    equationString[0] += "th root of ";
            }

            equationInputArea.setValue(equationString[0]);
        });
        power.addClickListener(e -> {
            equationString[0] += "^";
            equationInputArea.setValue(equationString[0]);
        });
        greater.addClickListener(e -> {
            equationString[0] += ">";
            equationInputArea.setValue(equationString[0]);
        });
        less.addClickListener(e -> {
            equationString[0] += "<";
            equationInputArea.setValue(equationString[0]);
        });
        greaterEqual.addClickListener(e -> {
            equationString[0] += "≥";
            equationInputArea.setValue(equationString[0]);
        });
        lessEqual.addClickListener(e -> {
            equationString[0] += "≤";
            equationInputArea.setValue(equationString[0]);
        });
        equals.addClickListener(e -> {
            equationString[0] += "=";
            equationInputArea.setValue(equationString[0]);
        });
        sin.addClickListener(e -> {
            equationString[0] += "sin";
            equationInputArea.setValue(equationString[0]);
        });
        cos.addClickListener(e -> {
            equationString[0] += "cos";
            equationInputArea.setValue(equationString[0]);
        });
        tan.addClickListener(e -> {
            equationString[0] += "tan";
            equationInputArea.setValue(equationString[0]);
        });
        sec.addClickListener(e -> {
            equationString[0] += "sec";
            equationInputArea.setValue(equationString[0]);
        });
        csc.addClickListener(e -> {
            equationString[0] += "csc";
            equationInputArea.setValue(equationString[0]);
        });
        cot.addClickListener(e -> {
            equationString[0] += "cot";
            equationInputArea.setValue(equationString[0]);
        });
        arcsin.addClickListener(e -> {
            equationString[0] += "arcsin";
            equationInputArea.setValue(equationString[0]);
        });
        arccos.addClickListener(e -> {
            equationString[0] += "arccos";
            equationInputArea.setValue(equationString[0]);
        });
        arctan.addClickListener(e -> {
            equationString[0] += "arctan";
            equationInputArea.setValue(equationString[0]);
        });
        arcsec.addClickListener(e -> {
            equationString[0] += "arcsec";
            equationInputArea.setValue(equationString[0]);
        });
        arccsc.addClickListener(e -> {
            equationString[0] += "arccsc";
            equationInputArea.setValue(equationString[0]);
        });
        arccot.addClickListener(e -> {
            equationString[0] += "arccot";
            equationInputArea.setValue(equationString[0]);
        });
        derivative.addClickListener(e -> {
            equationString[0] += "dy/dx";
            equationInputArea.setValue(equationString[0]);
        });
        defIntegral.addClickListener(e -> {
            equationString[0] += "∫( )dx with bounds () to ()";
            equationInputArea.setValue(equationString[0]);
        });
        indefIntegral.addClickListener(e -> {
            equationString[0] += "∫( )dx";
            equationInputArea.setValue(equationString[0]);
        });
        limit.addClickListener(e -> {
            equationString[0] += "lim x → ()";
            equationInputArea.setValue(equationString[0]);
        });
        log.addClickListener(e -> {
            equationString[0] += "log() of ()";
            equationInputArea.setValue(equationString[0]);
        });
        ln.addClickListener(e -> {
            equationString[0] += "ln()";
            equationInputArea.setValue(equationString[0]);
        });
        abs.addClickListener(e -> {
            equationString[0] += "|";
            equationInputArea.setValue(equationString[0]);
        });
        frontPar.addClickListener(e -> {
            equationString[0] += "(";
            equationInputArea.setValue(equationString[0]);
        });
        comma.addClickListener(e -> {
            equationString[0] += ",";
            equationInputArea.setValue(equationString[0]);
        });
        period.addClickListener(e -> {
            equationString[0] += ".";
            equationInputArea.setValue(equationString[0]);
        });
        infinity.addClickListener(e -> {
            equationString[0] += "∞";
            equationInputArea.setValue(equationString[0]);
        });
        percent.addClickListener(e -> {
            equationString[0] += "%";
            equationInputArea.setValue(equationString[0]);
        });

        //endregion


        equationInputArea.addValueChangeListener(e -> {
            equationString[0] = e.getValue();
            equationInputArea.setValue(equationString[0]);
        });

        // Set component alignment in the vertical layout
        mainContent.setAlignItems(Alignment.CENTER);
        mainContent.add(title);
        mainContent.add(equationInput, inputFieldLineOne, inputFieldLineTwo, inputFieldLineThree, inputFieldLineFour, inputFieldLineFive, inputFieldLineSix, tokenInput, equationOutput);


        add(mainContent);

    }

}