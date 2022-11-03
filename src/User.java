import java.util.ArrayList;

public class User extends StartMenu {

    public String userName;

    public User()
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
