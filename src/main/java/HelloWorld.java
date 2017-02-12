import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Vova_Levitski on 09.02.2017.
 */
public class HelloWorld {

    private static Scanner scan = new Scanner(System.in);
    private static Factorial factorial = new Factorial();

    public static void main(String[] args) {

        System.out.println("Hello World!"); //scan.nextLine();
        System.out.print("Будь ласка, введіть ваше ім'я: " );
        String name = scan.nextLine();
        System.out.println("Привіт, " + name + "!");

        System.out.println("Ваше ім'я складається з " + name.length() + Sufix(name.length())
                + name.length() + "! = " + factorial.factorial(name.length()));
      //  scan.nextLine();
        System.out.print("Будь ласка, введіть дату народження у форматі (дд.мм.рррр): ");

        Date a = Calendar.getInstance().getTime();
        String date = scan.nextLine();

        try {
            Date mne = new SimpleDateFormat("dd.MM.yyyy").parse(date);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            System.out.print("Сьогодні " + dateFormat.format(a)
                    + ", Вам " + ((a.getTime() - mne.getTime())/86400000/365) + " років ("
                    + ((a.getTime() - mne.getTime())/86400000)+" днів).");
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Помилка!!! Неправильно введено дату!");
        }
    }

    private static String Sufix(int j){
        int jj = j%10;
        switch (jj){
            case 1: return "-ї букви, ";
            case 2:
            case 3:
            case 4: return "-x букв, ";
            default:
                if(j>0)return "-и букв, ";
                else return "-я букв, ";
        }
    }

}
