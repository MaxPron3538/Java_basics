import java.io.File;
import java.sql.*;

public class DBConnection {

    private static Connection connection;
    private static String dbName = "learn";
    private static String dbUser = "root";
    private static String dbPass = "tiptop";
    private static int buffSize = 10000000;

    private static StringBuilder insertQuery = new StringBuilder();

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + dbName +
                        "?user=" + dbUser + "&password=" + dbPass);
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                    "id INT NOT NULL AUTO_INCREMENT, " +
                    "name TINYTEXT NOT NULL, " +
                    "birthDate DATE NOT NULL, " +
                    "`count` INT NOT NULL, " +
                    "PRIMARY KEY(id))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    public static void countVoter(String name, String birthDay,boolean isEnd) throws SQLException {
        birthDay = birthDay.replace('.', '-');

        if(insertQuery.length() > buffSize || isEnd) {
            executeMultiInsert();
            insertQuery = new StringBuilder();
        }
        else{
            if(!birthDay.equals("")) {
                insertQuery.append(insertQuery.length() == 0 ? "" : ",").append("('").append(name).append("', '").append(birthDay).append("', 1)");
            }
        }
    }
    public static void executeMultiInsert() throws SQLException {
        String sql = "INSERT INTO voter_count(name, birthDate, `count`) " +
                "VALUES" + insertQuery.toString();
        DBConnection.getConnection().createStatement().execute(sql);
    }
    public static void printVoterCounts() throws SQLException {
        String sql = "SELECT name,birthDate,COUNT(*) as `count` from voter_count  group by name,birthDate having count > 1;";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        while (rs.next()) {
            System.out.println("\t" + rs.getString("name") + " (" +
                rs.getString("birthDate") + ") - " + rs.getInt("count"));
        }
    }
}
