import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.Scanner;
public class User extends FileIO {

    public String userName;
    public int userPass;

    public Media movie;

    public User(String userName, int userPass){
        this.userName = userName;
        this.userPass = userPass;
    }


    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public int getUserPass(){
        return userPass;
    }

    public void setUserPass(int userPass){
        this.userPass = userPass;
    }

    @Override
    public String toString(){
        return "You are now logged in as: " + userName;
    }




}
