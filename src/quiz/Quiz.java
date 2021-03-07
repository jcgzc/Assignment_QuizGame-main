package quiz;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//Skapa en klass som håller reda på frågor och svaralternativ och vilket svarsalternativ som är rätt.
public class Quiz implements Serializable {

    String question;
    String answer1;
    String answer2;
    String answer3;


    public Quiz(String newQuestion, String newAnswer1, String newAnswer2, String newAnswer3) {
        this.question = newQuestion;
        this.answer1 = newAnswer1;
        this.answer2 = newAnswer2;
        this.answer3 = newAnswer3;

    }

    static LinkedList<Quiz> testList = new LinkedList<>();
    //Ska också innehålla en metod som ska läsa in de serialiserade frågeobjekten från en fil.

    public static void startGame() throws Exception {


        Quiz q1 = new Quiz("Hur många landskap har Sverige?", "20 stycken.", "25 stycken.", "28 stycken.");
        Quiz q2 = new Quiz("Vilket av dessa flygbolag är tyskt?", "Lufthansa", "SAS", "WizzAir");
        Quiz q3 = new Quiz("Hur gammal var Einstein när han dog?", "56 år gammal.", "66 år gammal.", "76 år gammal.");
        Quiz q4 = new Quiz("Hur många länder ingår i EU?", "26 stycken.", "27 stycken.", "28 stycken.");
        Quiz q5 = new Quiz("Hur gammalt är JAVA?", "20 år gammalt.", "30 år gammalt.", "40 år gammalt.");
        Quiz q6 = new Quiz("Hur stort är Sverige till ytan?", "450 295 km².", "400 295 km².", "445 295 km².");


        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("questions_ser.txt"));

        out.writeObject(q1);
        out.writeObject(q2);
        out.writeObject(q3);
        out.writeObject(q4);
        out.writeObject(q5);
        out.writeObject(q6);
        //out.writeObject(testList.get(0));

        out.flush();
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("questions_ser.txt"));

        Quiz a1 = (Quiz) in.readObject();
        Quiz a2 = (Quiz) in.readObject();
        Quiz a3 = (Quiz) in.readObject();
        Quiz a4 = (Quiz) in.readObject();
        Quiz a5 = (Quiz) in.readObject();
        Quiz a6 = (Quiz) in.readObject();
        //Quiz a7 = (Quiz) in.readObject();
        testList.add(a1);
        testList.add(a2);
        testList.add(a3);
        testList.add(a4);
        testList.add(a5);
        testList.add(a6);

        in.close();


        Scanner input = new Scanner(System.in);
        System.out.println(a1.question);
        System.out.println("1. " + a1.answer1);
        System.out.println("2. " + a1.answer2);
        System.out.println("3. " + a1.answer3);
        System.out.println("Skriv svaret här: ");


        int nr2 = input.nextInt();
        if (nr2 == 2) {
            System.out.println("Rätt svar");
        } else {
            System.out.println("Fel svar ");
        }



    }

    public static void startMenu() throws IOException, Exception {


        System.out.println("-------------------------------------------");
        System.out.println("Tryck in en siffra för vad du vill göra");
        System.out.println("-------------------------------------------");
        System.out.println(" 1. Spela spelet ");
        System.out.println(" 2. Visa en lista med frågorna ");
        System.out.println(" 3. Lägg till en fråga ");
        System.out.println(" 4. Ta bort en fråga ");
        System.out.println(" 5. Redigera en fråga ");
        System.out.println("-------------------------------------------");

        Scanner input = new Scanner(System.in);
        int nr = input.nextInt();

        switch (nr) {
            case 1:
                Player.createNewPlayer();
                startGame();
                break;
            case 2:

                questionsFile();
                startMenu();

                break;
            case 3:

                addQuestion();
                startMenu();

                break;
            case 4:
                removeQuestion();
                startMenu();
                break;
            case 5:
                manageQuestions();
                startMenu();

                break;
            default:
        }
    }


    public static void questionsFile() throws IOException, Exception {

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("questions_ser.txt"));

        Quiz a1 = (Quiz) in.readObject();
        Quiz a2 = (Quiz) in.readObject();
        Quiz a3 = (Quiz) in.readObject();
        Quiz a4 = (Quiz) in.readObject();
        Quiz a5 = (Quiz) in.readObject();
        Quiz a6 = (Quiz) in.readObject();


        testList.add(a1);
        testList.add(a2);
        testList.add(a3);
        testList.add(a4);
        testList.add(a5);
        testList.add(a6);

        in.close();


        LinkedList<Quiz> questions = testList;

        Collections.shuffle(questions);
        questions.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Question= " + question
                ;
    }

    public static void addQuestion() {
        System.out.println("Lägg till fråga och svarsalternativ");

        Scanner sc = new Scanner(System.in);

        System.out.println("Lägg till din fråga");
        String questionAdd = sc.nextLine();
        System.out.println("Lägg ditt första svar");
        String answer1Add = sc.nextLine();
        System.out.println("Lägg ditt andra svar");
        String answer2Add = sc.nextLine();
        System.out.println("Lägg ditt tredje svar");
        String answer3Add = sc.nextLine();


        testList.add(new Quiz(questionAdd,answer1Add,answer2Add,answer3Add));

    }

    public static void removeQuestion(){

        testList.remove();

    }

    public static void manageQuestions(){



     testList.set(0,new Quiz("TESTING","testanwser1","testanswer2","testanswer3"));
        System.out.println(testList);
    }


}


