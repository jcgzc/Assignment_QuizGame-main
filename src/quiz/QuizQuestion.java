package quiz;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


//Skapa en klass som håller reda på frågor och svaralternativ och vilket svarsalternativ som är rätt.
public class QuizQuestion implements Serializable {


    String question;
    String answer1;
    String answer2;
    String answer3;

    public QuizQuestion(String newQuestion, String newAnswer1, String newAnswer2, String newAnswer3) {
        this.question = newQuestion;
        this.answer1 = newAnswer1;
        this.answer2 = newAnswer2;
        this.answer3 = newAnswer3;

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    //Ska också innehålla en metod som ska läsa in de serialiserade frågeobjekten från en fil.

    public static void main(String[] args) throws Exception{




        //Frågebanken

        QuizQuestion q1 = new QuizQuestion("Hur många landskap har Sverige?", "20 stycken.", "25 stycken.", "28 stycken.");
        QuizQuestion q2 = new QuizQuestion("Vad heter det tyska flygbolaget?", "Lufthansa", "SAS", "WizzAir");
        QuizQuestion q3 = new QuizQuestion("Hur gammal var Einstein när han dog?", "56 år gammal.", "66 år gammal.", "76 år gammal.");
        QuizQuestion q4 = new QuizQuestion("Hur många länder ingår i EU?", "26 stycken.", "27 stycken.", "28 stycken.");
        QuizQuestion q5 = new QuizQuestion("Hur gammalt är JAVA?", "20 år gammalt.", "30 år gammalt.", "40 år gammalt.");
        QuizQuestion q6 = new QuizQuestion("Hur stort är Sverige till ytan?", "450 295 km².", "400 295 km².", "445 295 km².");



        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Johan\\Assignment_QuizGame-main\\src\\quiz\\questions.txt"));

        out.writeObject(q1);
        out.writeObject(q2);
        out.writeObject(q3);
        out.writeObject(q4);
        out.writeObject(q5);
        out.writeObject(q6);
        out.flush();
        out.close();

        // Reads from .ser
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\Johan\\Assignment_QuizGame-main\\src\\quiz\\questions.txt"));

        QuizQuestion a1 = (QuizQuestion) in.readObject();
        QuizQuestion a2 = (QuizQuestion) in.readObject();
        QuizQuestion a3 = (QuizQuestion) in.readObject();
        QuizQuestion a4 = (QuizQuestion) in.readObject();
        QuizQuestion a5 = (QuizQuestion) in.readObject();
        QuizQuestion a6 = (QuizQuestion) in.readObject();
        /*
        System.out.println("----------------------------------------");
        System.out.println(a1.question);
        System.out.println("----------------------------------------");
        System.out.println("1. " + a1.answer1);
        System.out.println("2. " + a1.answer2);
        System.out.println("3. " + a1.answer3);

        System.out.println("----------------------------------------");
        System.out.println(a2.question);
        System.out.println("----------------------------------------");
        System.out.println("1. " + a2.answer1);
        System.out.println("2. " + a2.answer2);
        System.out.println("3. " + a2.answer3);

        System.out.println("----------------------------------------");
        System.out.println(a3.question);
        System.out.println("----------------------------------------");
        System.out.println("1. " + a3.answer1);
        System.out.println("2. " + a3.answer2);
        System.out.println("3. " + a3.answer3);

        System.out.println("----------------------------------------");
        System.out.println(a4.question);
        System.out.println("----------------------------------------");
        System.out.println("1. " + a4.answer1);
        System.out.println("2. " + a4.answer2);
        System.out.println("3. " + a4.answer3);

        System.out.println("----------------------------------------");
        System.out.println(a5.question);
        System.out.println("----------------------------------------");
        System.out.println("1. " + a5.answer1);
        System.out.println("2. " + a5.answer2);
        System.out.println("3. " + a5.answer3);

        System.out.println("----------------------------------------");
        System.out.println(a6.question);
        System.out.println("----------------------------------------");
        System.out.println("1. " + a6.answer1);
        System.out.println("2. " + a6.answer2);
        System.out.println("3. " + a6.answer3);
*/
        in.close();

        // List<QuizQuestion> questionList = new ArrayList<QuizQuestion>();


        Scanner input = new Scanner(System.in);

        System.out.println("-------------------------------------------");
        System.out.println("Tryck in en siffra för vad du vill göra");
        System.out.println("-------------------------------------------");
        System.out.println(" 1. Spela spelet ");
        System.out.println(" 2. Visa en lista med frågorna ");
        System.out.println(" 3. Lägg till en fråga ");
        System.out.println(" 4. Ta bort en fråga ");
        System.out.println(" 5. Redigera en fråga ");
        System.out.println("-------------------------------------------");

        int nr = input.nextInt();

        switch (nr) {
            case 1:
                // kod block
                break;
            case 2:
                System.out.println(a1.question);
                System.out.println(a2.question);
                System.out.println(a3.question);
                System.out.println(a4.question);
                System.out.println(a5.question);
                System.out.println(a6.question);

                break;
            case 3:
                System.out.println("Skriv in frågan: ");


                break;
            case 4:
                // kod block
                break;
            case 5:
                // kod block
                break;
            default:
                // code block
        }

    }
}
