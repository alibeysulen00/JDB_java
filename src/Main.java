import java.io.IOException;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {
        Connection connection=null;
        DbHelper helper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet;
        try{

            connection=helper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select Code,Name,Continent,Region from country\n");

            while (resultSet.next()){
                System.out.println(resultSet.getString("Name"));
            }
        }
        catch (SQLException exception){
            helper.showErrorMessage(exception);
        }
        finally {
            connection.close();
        }
    }
}
