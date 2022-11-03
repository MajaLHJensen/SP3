import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello world!");

        ArrayList<Media>medias = new ArrayList<>();
        medias.add(new Movies());
        Media movie1 = new Movies();

        User.pickMedia(medias);
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




    static void categories()
    {
        System.out.println();
    }

    static void  searchBar()
    {
        System.out.println();
    }
//oprat alle film / serieer

}