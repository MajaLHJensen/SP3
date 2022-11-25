import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;

public class MediaDB implements IConnect{
    private Connection connection;
    String url = "jdbc:mysql://localhost:3306/?user=root" + "autoReconnect=true&useSSL=false";


    String username = "root";
    String password = "Krusell123";
    ArrayList<Media> movieM = new ArrayList<>();

    public ArrayList<Media> getAllMovies(){
        establishConnection();
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
                movieM.add(movies);
                //System.out.println(movies);
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("This option does not exist. Try again.");
        }
        return movieM;
    }

    private void establishConnection(){
        try{
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}