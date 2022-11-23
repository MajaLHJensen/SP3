import java.sql.*;
import java.util.ArrayList;

public class MediaDB implements IConnect
{
    private Connection connection;

    String url = "jdbc:mysql://localhost:3306/?user=root" + "autoReconnect=true&useSSL=false";
    String username = "root";
    String password = "1692";
    ArrayList<Movies> movieM = new ArrayList<>();

    public void run()
    {
        establishConnection();

        //Statement
        String query = "SELECT * FROM movie.mytable;";
        try
        {
            Statement statement = this.connection.createStatement();
            statement.execute(query);

            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next())
            {
                String movieID = resultSet.getString("MovieID");
                String movieName = resultSet.getString("MovieName");
                String movieYear = resultSet.getString("MovieYear");
                String movieCategory = resultSet.getString("MovieCategory");
                String movieRating = resultSet.getString("MovieRating");
                Movies movies = new Movies(movieID, movieName, movieYear, movieCategory, movieRating);

                this.movieM.add(movies);

            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void establishConnection()
    {
        //Connection
        try
        {
            connection = DriverManager.getConnection(url, username, password);
            //assertEquals(true, connection.isValid(1));
            //connection.close();
            //assertEquals(false, connection.isValid(1));
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void printMovies()
    {
        for (Movies m : this.movieM)
        {
            System.out.println(m.movieID + " : " + m.name + " : " + m.year + " : " + m.categoryDB + " : " + m.rating);
        }
    }

    public void createMovies(IConnect con)
    {
    }
}

