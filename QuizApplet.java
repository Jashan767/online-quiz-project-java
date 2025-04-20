
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

/*
<applet code="QuizApplet.class" width=600 height=400></applet>
*/

public class QuizApplet extends Applet implements ActionListener {
    String[] questions = {
        "What is the capital of India?",
        "Which language is used for Android development?",
        "Who invented Java?",
        "Which one is not OOP concept?",
        "What is the extension of Java files?",
        "Which company developed Java?",
        "What is JVM?",
        "Which keyword is used to inherit a class in Java?",
        "Which is not a Java datatype?",
        "Which method is used to start a thread?"
    };

    String[][] options = {
        {"Delhi", "Mumbai", "Kolkata", "Chennai"},
        {"Java", "Python", "C#", "Swift"},
        {"James Gosling", "Dennis Ritchie", "Bjarne Stroustrup", "Guido van Rossum"},
        {"Inheritance", "Polymorphism", "Compilation", "Abstraction"},
        {".class", ".java", ".cpp", ".exe"},
        {"Microsoft", "Apple", "Sun Microsystems", "Google"},
        {"Java Virtual Machine", "Java Variable Memory", "Joint Visual Model", "Java Visual Method"},
        {"this", "import", "extends", "implement"},
        {"int", "String", "float", "real"},
        {"begin()", "start()", "run()", "init()"}
    };

    int[] correctAnswers = {0, 0, 0, 2, 1, 2, 0, 2, 3, 1};
    int[] userAnswers = new int[questions.length];

    Label questionLabel, timerLabel;
    CheckboxGroup group;
    Checkbox opt1, opt2, opt3, opt4;
    Button nextButton;
    int current = 0, score = 0, timeLeft = 10;
    Timer timer;

    public void init() {
        setLayout(new GridLayout(7, 1));

        questionLabel = new Label();
        timerLabel = new Label("Time left: 10s");
        add(questionLabel);
        add(timerLabel);

        group = new CheckboxGroup();
        opt1 = new Checkbox("", group, false);
        opt2 = new Checkbox("", group, false);
        opt3 = new Checkbox("", group, false);
        opt4 = new Checkbox("", group, false);

        add(opt1);
        add(opt2);
        add(opt3);
        add(opt4);

        nextButton = new Button("Next");
        add(nextButton);
        nextButton.addActionListener(this);

        loadQuestion();

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                timerLabel.setText("Time left: " + timeLeft + "s");
                if (timeLeft == 0) {
                    autoSubmit();
                }
            }
        });
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        submitAnswer();
    }

    void submitAnswer() {
        int selected = -1;
        if (opt1.getState()) selected = 0;
        else if (opt2.getState()) selected = 1;
        else if (opt3.getState()) selected = 2;
        else if (opt4.getState()) selected = 3;

        userAnswers[current] = selected;

        timer.stop();
        current++;

        if (current < questions.length) {
            loadQuestion();
            timer.restart();
        } else {
            showResult();
        }
    }

    void autoSubmit() {
        submitAnswer();
    }

    void loadQuestion() {
        timeLeft = 10;
        timerLabel.setText("Time left: 10s");
        questionLabel.setText("Q" + (current + 1) + ": " + questions[current]);
        opt1.setLabel(options[current][0]);
        opt2.setLabel(options[current][1]);
        opt3.setLabel(options[current][2]);
        opt4.setLabel(options[current][3]);
        group.setSelectedCheckbox(null);
    }

    void showResult() {
        for (int i = 0; i < questions.length; i++) {
            if (userAnswers[i] == correctAnswers[i]) {
                score++;
            }
        }

        removeAll();
        setLayout(new FlowLayout());
        add(new Label("Quiz Completed! Your Score: " + score + " out of " + questions.length));
        repaint();
    }
}
