package moviebot;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.rivescript.macro.Subroutine;

import javax.xml.transform.Result;
import java.sql.*;

public class DBConnection implements Subroutine {

    @Override
    public String call(com.rivescript.RiveScript rs, String[] DBGEV){
        String host = DBGEV[0];
        String port = DBGEV[1];
        String db = DBGEV[2];
        String username = DBGEV[3];
        String password = DBGEV[4];
        String sql = "";
        String result = "";
        for (int i = 5; i<DBGEV.length; i++)
            sql = sql + " " + DBGEV[i];
        sql = sql.trim();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            conn = (Connection)DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db + "?autoReconnect=true&useSSL=false",username,password);

            if(conn!=null)
            {
                System.out.println("connected successfully to database");
            }

            statement=(Statement) connection.createStatement();

            resultSet=statement.executeQuery(sql);
            while(resultSet.next()) {
                int i = resultSet.getMetaData().getColumnCount();
                for (int j = 1; j <= i; j++) {
                    if (result.equals("")) {
                        result = resultSet.getString(j);
                    } else {
                        result += resultSet.getString(j) + " ";
                    }
                }
                if (!result.equals(""))
                    result += "\n";
            }

        } catch (SQLException ex){
            System.out.println("not connected to database");
        }finally {
            try{
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex){}
        }
        return result;
    }
}



