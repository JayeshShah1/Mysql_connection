import java.sql.*;

public class demo {

    public static void main(String args[])
    {
        String url = "jdbc:mysql://localhost:3306/connect";
        String user = "root";
        String password = "Jayessh@@@123";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connection is Successfull to the database"+url);
            //String query = "Insert into student(id,name) values(101,'ram')";
            String query = " Select* from connect.department";
           Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            /*String name= rs.getString("DeptName");
            System.out.println(name);*/
            while(rs.next())
            {
                int DeptID = rs.getInt("DeptID");
                String DeptName = rs.getString("DeptName");
                String DeptZone = rs.getString("DeptZone");

                System.out.println(DeptID+" " + DeptName + " " + DeptZone);

            }
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
