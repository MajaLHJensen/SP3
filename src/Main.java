import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello world!");

        ArrayList<Media>medias = new ArrayList<>();
        medias.add(new Movies());


        User.pickMedia(medias);
    }
//oprat alle film / serieer

}