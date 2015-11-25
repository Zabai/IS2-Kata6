package kata6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonLoader {
    public static ArrayList<Person1> read () throws ClassNotFoundException, SQLException{
        ArrayList<Person1> list = new ArrayList<>();
        
        Class.forName("org.sqlite.JDBC");
        Connection connect = DriverManager.getConnection("jdbc:sqlite:Kata.sDB");
        Statement state = connect.createStatement();
        ResultSet rs = state.executeQuery("Select * from PEOPLE");
        
        while(rs.next()){
            Integer id = rs.getInt(1);
            String name = rs.getString(2);
            String gender = rs.getString(3);
            String birthday = rs.getString(4);
            String mail = rs.getString(6);
            Float weight = rs.getFloat(5);
            list.add(new Person1(id,name,gender,birthday, mail, weight));
        }
        
        
        return list;
    }
}
