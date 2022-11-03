import java.util.Scanner;

public class StartMenu extends Main
{
    public static void clearTheConsole()
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.println();
        }
    }
    protected static final Scanner scanner = new Scanner(System.in);
    public static void startStreaming()
    {
        System.out.println("Welcome to Jems HUB");
        System.out.println("Press ENTER to login");
        scanner.nextLine();
        clearTheConsole();


        System.out.println("Do you want to sign in or login? ");
        System.out.println("Press 1 to login ");
        System.out.println("Press 2 to sign in ");
        while(true)
        {
            String answer = scanner.nextLine();
            if("1".equals(answer))
            {
                clearTheConsole();
                System.out.println("Username: ");
                System.out.println("Password: ");
                get.userName();
                get.userPass();
            }
            if("2".equals(answer))
            {
                clearTheConsole();
                System.out.println("Create username with only letters: ");
                System.out.println("Create password with only numbers: ");
            }
        }
        System.out.println("Welcome: " + get.userName());
    }
}
