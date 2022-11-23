import java.util.ArrayList;

abstract public class Media{
    private  final String category;
    private final String name;
    private final String year;
    private final String rating;

    public String getName(){
        return this.name;
    }

    public Media(String name, String year, String category, String rating){
        this.category = category;
        this.name = name;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public String toString(){
        return "category: " + category +
                ", name: " + name + '\'' +
                ", year: " + year + '\'' +
                ", rating: " + rating;
    }
}