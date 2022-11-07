import java.io.File;
import java.util.Scanner;

public class StartMenu extends Main
{
    protected static final Scanner scanner = new Scanner(System.in);

    static void createUser() {

}

    public static void clearTheConsole()
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.println();
        }
    }



    public static void startStreaming()
    {
        System.out.println("Welcome to Jems play");
        System.out.println("Press ENTER to login");
        scanner.nextLine();
        clearTheConsole();


        System.out.println("Do you want to sign in or login? ");
        System.out.println("Press 1 to login ");
        System.out.println("Press 2 to sign in ");
        String name ="";
        while(true)
        {
            String answer = scanner.nextLine();
            if("1".equals(answer))
            {
                clearTheConsole();
                System.out.println("Username: ");
                name = scanner.nextLine();
                System.out.println("Password: ");
                int password = scanner.nextInt();

            }
            if("2".equals(answer))
            {
                clearTheConsole();
                System.out.println("Create username with only letters: ");
                System.out.println("Create password with only numbers: ");
            }
            System.out.println("Welcome "+name);
        }

    }

    public static boolean checkUser(String name, int password)
    {
        File file = new File("Userlogin.csv");

        //The loop will read the file line by line
        while (scanner.hasNextLine())
        {
            //The loop will check if the file has a boolean value
            if(scanner.hasNextBoolean())
            {
                //In the loop it will return the boolean if it exist.
                if(scanner.nextBoolean())
                {
                    //Print the boolean value
                    System.out.println(scanner.nextLine());
                }
                else
                {
                    //Will continue running till the file ends
                    System.out.println(scanner.nextLine());
                }
            }
            //Closing the file
            scanner.close();
        }
        return false;
    }
}
