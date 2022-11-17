import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StartMenu extends Main{
    protected final Scanner scanner = new Scanner(System.in);
    ArrayList<User> users = new ArrayList<>();

    public void clearTheConsole(){
        for (int i = 0; i < 100; i++){
            System.out.println();
        }
    }

    public void startStreaming(){

        System.out.println("Welcome to J.E.M.S Play");
        System.out.println("Press ENTER to login or sign up");

        scanner.nextLine();
        clearTheConsole();

        System.out.println("Do you want to create a new account or login into an existing account? ");
        System.out.println("Press 1 to login ");
        System.out.println("Press 2 to create a new account ");
        String name = "";
        String userName = "";

        while (true){
            String answer = scanner.nextLine();
            if ("1".equals(answer)){
                clearTheConsole();
                System.out.println("Username: ");
                name = scanner.nextLine();
                System.out.println("Password: ");
                int password = scanner.nextInt();

                if (checkUser(name, password)){

                    System.out.println("Great!You have officially logged in as ");
                    System.out.println("Welcome Back" + name);
                    System.out.println("please pres ENTER to continue");
                    scanner.nextLine();
                    clearTheConsole();

                    break;
                }else{
                    System.out.println("Incorrect username or password");
                }
            }

            if ("2".equals(answer)){
                clearTheConsole();
                System.out.println("Create username with only letters: ");
                userName = scanner.nextLine();
                System.out.println("Create password with only numbers: ");
                int userPassword = scanner.nextInt();


                if (checkUserSignUp(userName))
                {
                    register(userName, userPassword);
                    scanner.nextLine();
                    clearTheConsole();
                    System.out.println("Welcome " + userName);
                    System.out.println("please pres ENTER to continue");
                    scanner.nextLine();
                    clearTheConsole();
                    break;
                } else{
                    System.out.println("");
                    System.out.println("Username does already exist, please login or change username");
                    System.out.println(" ");
                    scanner.nextLine();
                    Main.mainCaller();
                }

                register(userName, userPassword);
                scanner.nextLine();
                clearTheConsole();
                System.out.println("Welcome to J.E.M.S- Play " + userName);
                System.out.println("Please press ENTER to continue to see your options");
                scanner.nextLine();
                clearTheConsole();
                break;
            }
        }
    }

    public boolean checkUser(String name, int password){
        try{
            File file = new File("data/UserLogin.csv");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){
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

        }catch (FileNotFoundException e){
            System.out.println("UserLogin.csv does not exist");
            System.out.println("No users found, please register:");
            String userName = scanner.nextLine();
            int userPassword = scanner.nextInt();
            register(userName, userPassword);
            e.printStackTrace();
        }
        scanner.close();
        return false;
    }

    private void register(String userName, int userPassword){

        try{
            File file = new File("data/UserLogin.csv");
            if (!file.exists()){
                //file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            String userLogin = userName + ", " + userPassword;
            bw.write(userLogin);
            bw.close();
            User newUser = new User(userName, userPassword);
            users.add(newUser);

        } catch (Exception e){
            System.out.println(e);
        }
    }



    // check user is already registered on UserLogin.csv when they are trying to create a new account
    public boolean checkUserSignUp(String userName){
        try{
            File file = new File("data/UserLogin.csv");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] user = line.split(", ");
                String userNameFromFile = user[0];

                if (userName.equals(userNameFromFile))
                    return false;
            }

        }catch (FileNotFoundException e){
            System.out.println("UserLogin.csv does not exist");
            userName = scanner.nextLine();
            e.printStackTrace();
        }
        return true;
    }



}