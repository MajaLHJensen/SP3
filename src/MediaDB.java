import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;

public class MediaDB{
    private Connection connection;
    String url = "jdbc:mysql://localhost:3306/?user=root" + "autoReconnect=true&useSSL=false";


    String username = "root";
    String password = "Krusell123";

   // static ArrayList<Media> movieM = new ArrayList<>();
    ArrayList<Movies> movieM = new ArrayList<>();

    //public ArrayList<Media> getAllMovies()
    public void getAllMovies(){
        establishConnection();

        //Statement
        String query = "SELECT * FROM movie.mytable;";
        try {
            Statement statement = this.connection.createStatement();
            statement.execute(query);

            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                String movieID = resultSet.getString("MovieID");
                String movieName = resultSet.getString("MovieName");
                String movieYear = resultSet.getString("MovieYear");
                String movieCategory = resultSet.getString("MovieCategory");
                String movieRating = resultSet.getString("MovieRating");
                Movies movies = new Movies(movieID, movieName, movieYear, movieCategory, movieRating);
                this.movieM.add(movies);
                /*
                movieM.add(movies);
                System.out.println(movies);
                 */
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void establishConnection() {
        //Connection
        try {
            connection = DriverManager.getConnection(url, username, password);
           // connection.close();
            //assertEquals(true, connection.isValid(1));
            //assertEquals(false, connection.isValid(1));
            //catch (NullPointerException | SQLException e){
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void printMovies() {
        for (Movies m : this.movieM){
            System.out.println(m.movieID + ":" + m.name);
        }
    }
}