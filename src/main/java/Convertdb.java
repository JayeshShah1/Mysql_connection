import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class Convertdb {

    public static void main(String args[]) throws IOException {
        String url = "jdbc:mysql://localhost:3306/connect";
        String user = "root";
        String password = "Jayessh@@@123";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connection is Successfull to the database"+url);
            //String query = "Insert into student(id,name) values(101,'ram')";
            String query = " SELECT * FROM connect.department;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            /*String name= rs.getString("DeptName");
            System.out.println(name);*/
            demo2 dm = new demo2();
           while(rs.next())
           {
               int DeptID = rs.getInt("DeptID");
               String DeptName = rs.getString("DeptName");
               String DeptZone = rs.getString("DeptZone");
                dm.setDeptID(DeptID);
                dm.setDeptName(DeptName);
                dm.setDeptZone(DeptZone);
               //System.out.println(DeptID+" " + DeptName + " " + DeptZone);

           }
          // System.out.println(dm.getDeptID());
           // System.out.println(dm.getDeptName());

            File jsonfile = new File("C:\\Users\\u1124560\\IdeaProjects\\Mysql_connection\\stud.json");
            ObjectMapper om = new ObjectMapper();
            om.writeValue(jsonfile , dm);

            statement.close();
            connection.close();
            System.out.println("Done");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
