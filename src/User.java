import java.util.ArrayList;

public class User extends StartMenu
{
    public String userName;
    public int userPass;


    public User(String userName, int userPass) {

        this.userName = userName;
        this.userPass = userPass;

    }
// getting the username login
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
// getting the user password login
    public int getUserPass() {
        return userPass;
    }

    public void setUserPass(int userPass) {
        this.userPass = userPass;
    }

    @Override
    public String toString() {
        return "You are now logged in as: " + userName;



    }

    // TODO: 03-11-2022 Lav constructor i Media, så Media kan returneres i metoden savedList
    //public static Media savedList()
    public static void savedList()
    {

    }


    //public static Media watchedList()
    public static void watchedList()
    {

    }




    public static void pickMedia(ArrayList<Media> medias){

        //categories - movies - series
        System.out.println("choose category: ");

        for(int i = 0; i < medias.size(); i++){

            medias.get(i);

        }





    }
}
