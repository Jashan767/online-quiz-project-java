# online-quiz-project-java
Introduction
QuizApplet.java is a Java Applet-based application that provides an online quiz experience. The applet presents 10 multiple-choice questions to the user, each with four options, and includes a countdown timer of 10 seconds per question. The application evaluates the user's responses and displays the final score at the end of the quiz.
How to Run
1. Ensure Java Development Kit (JDK) is installed on your computer.
2. Save the file as QuizApplet.java.
3. Compile the applet using the following command:
   javac QuizApplet.java
4. Create an HTML file (e.g., quiz.html) to embed the applet:

<html>
<body>
<applet code='QuizApplet.class' width='800' height='600'></applet>
</body>
</html>

5. Open the HTML file in a Java-enabled browser or use appletviewer:
   appletviewer quiz.html
Features
- 10 multiple-choice questions.
- 10-second timer for each question.
- Automatic transition to next question if time runs out.
- Final score display after quiz completion.
Requirements
- Java Development Kit (JDK) 8 or higher.
- Text editor (e.g., Notepad++, VS Code) or Java IDE (e.g., NetBeans, Eclipse).
- Java-enabled browser or appletviewer.
Conclusion
The QuizApplet.java project provides an engaging and educational platform for users to test their knowledge interactively. It demonstrates the use of GUI components, event handling, and timing mechanisms in Java Applets.
