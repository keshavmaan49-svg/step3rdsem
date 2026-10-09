import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract String getQuestionType();
    public abstract double evaluateScore();
}

class McqQuestion extends Question {
    public McqQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getQuestionType() {
        return "MCQ";
    }

    @Override
    public double evaluateScore() {
        return studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim()) ? points : 0.0;
    }
}

class TrueFalseQuestion extends Question {
    public TrueFalseQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getQuestionType() {
        return "TF";
    }

    @Override
    public double evaluateScore() {
        return studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim()) ? points : 0.0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getQuestionType() {
        return "ESSAY";
    }

    @Override
    public double evaluateScore() {
        String[] keywords = correctAnswer.split(",");
        int matched = 0;
        String studentLower = studentAnswer.toLowerCase();

        for (String kw : keywords) {
            String cleanKw = kw.trim().toLowerCase();
            if (!cleanKw.isEmpty() && studentLower.contains(cleanKw)) {
                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        } else {
            return 0.0;
        }
    }
}

public class ExamQuestionGrader {
    public static void gradeExam(List<Question> questions) {
        double totalScore = 0.0;
        for (Question q : questions) {
            double score = q.evaluateScore();
            totalScore += score;
            System.out.printf("%s: %.2f%n", q.getQuestionType(), score);
        }
        System.out.printf("Total Score: %.2f%n", totalScore);
    }

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new McqQuestion("What is the capital of France?", "Paris", "Paris", 10));
        questions.add(new TrueFalseQuestion("The Earth is flat?", "False", "True", 5));
        questions.add(new EssayQuestion("Name two primary OOP principles.", "Inheritance, Polymorphism, Encapsulation", "Polymorphism is one.", 20));
        questions.add(new EssayQuestion("Describe abstraction and composition.", "Abstraction, Composition", "I talked about abstraction.", 15));

        gradeExam(questions);
    }
}
