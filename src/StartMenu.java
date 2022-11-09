import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StartMenu extends Main
{

    protected final Scanner scanner = new Scanner(System.in);

    ArrayList<User> users = new ArrayList<>();
    public void clearTheConsole()
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.println();
        }
    }

    public void startStreaming()
    {
        System.out.println("Welcome to Jems play");
        System.out.println("Press ENTER to login");
        scanner.nextLine();
        clearTheConsole();

        System.out.println("Do you want to sign in or login? ");
        System.out.println("Press 1 to login ");
        System.out.println("Press 2 to sign in ");
        String name = "";

        while (true)
        {
            String answer = scanner.nextLine();
            if ("1".equals(answer))
            {
                clearTheConsole();
                System.out.println("Username: ");
                name = scanner.nextLine();
                System.out.println("Password: ");
                int password = scanner.nextInt();



                if (checkUser(name, password))
                {
                    System.out.println("I HAVE ZE ACCESS!");
                    System.out.println("Welcome " + name);
                }
                else
                {
                    System.out.println("Incorrect username or password");
                }
            }

            if ("2".equals(answer))
            {
                clearTheConsole();
                System.out.println("Create username with only letters: ");
                String userName = scanner.nextLine();
                System.out.println("Create password with only numbers: ");
                int userPassword = scanner.nextInt();

                register(userName, userPassword);
                scanner.nextLine();
                clearTheConsole();
                System.out.println("Welcome " + userName);
                System.out.println("please pres ENTER to continue");
                scanner.nextLine();
                clearTheConsole();
                break;
            }
        }
    }

    public boolean checkUser(String name, int password)
    {
        try
        {
            File file = new File("SP3/data/UserLogin.csv");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] user = line.split(", ");
                String userNameFromFile = user[0];
                int passwordFromFile = Integer.parseInt(user[1]);

                if (name.equals(userNameFromFile))
                    if (password == passwordFromFile)
                        return true;
                System.out.println(name);
                System.out.println("Username does exist");
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println("UserLogin.csv does not exist");
            System.out.println("No users found, please register:");
            String userName = scanner.nextLine();
            int userPassword = scanner.nextInt();
            register(userName, userPassword);
            // hvis ikke der allerede findes denm her fil. Hvorfor skal man så overhovedet kunne checkUser() ???

            e.printStackTrace();
        }

        scanner.close();
        return false;
    }

    private void register(String userName, int userPassword)
    {


        // Filewriter: transfer new login to the file UserLogin.csv
        try
        {
            File file = new File("SP3/data/UserLogin.csv");
            if (!file.exists())
            {
                file.createNewFile();
            }


            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            String userLogin = userName + ", " + userPassword;
            bw.write(userLogin);
            bw.close();
            User newUser = new User(userName, userPassword);
            users.add(newUser);

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}