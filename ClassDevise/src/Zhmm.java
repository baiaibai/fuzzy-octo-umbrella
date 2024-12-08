import java.sql.*;

public class Zhmm implements DBConfig{

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    public static Connection getConnection(){
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,user,password);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    static Statement openStatement(){
        try {
            stmt=conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    static int update(String sql){
        int n = 0;
        try {
            n=stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("数量为"+n);
        return n;
    }

    static ResultSet query(String sql){

        try {
            rs=stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }


    static void closeAll() {
        // 如果rs不空，关闭rs
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 如果stmt不空，关闭stmt
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 如果conn不空，关闭conn
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
