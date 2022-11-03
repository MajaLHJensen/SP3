public class User extends StartMenu
{
    public String userLog;
import java.util.ArrayList;

public class User extends StartMenu {

    public String userName;

    public User()
    {

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

            medias.get(i).categories();

        }





    }
}
