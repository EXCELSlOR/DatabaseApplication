import java.sql.*;
import java.util.ArrayList;

public class DatabaseService {

    final static String URL = "jdbc:mysql://127.0.0.1:3306/test" +
            "?serverTimezone=Europe/Moscow&useSSL=false";
    final static String LOGIN = "root";
    final static String PASSWORD = "mysql";
    private static Connection connection;

    private static Connection getConnection() {
        if (connection != null) {
            return connection;
        }
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            return connection;
        }
    }

    public static ArrayList<User> selectUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM test.users;");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String login = resultSet.getNString("login");
                String password = resultSet.getString("password");
                Date birthdate = resultSet.getDate("birthdate");
                boolean gender = resultSet.getBoolean("gender");
                users.add(new User(id, login, password, birthdate, gender));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            return users;
        }
    }

    public static boolean createUser(User user) {
        boolean result = false;
        try {
            String commandText = "INSERT INTO users (login, password, birthdate, gender) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = getConnection().prepareStatement(commandText);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setDate(3, user.getBirthdate());
            preparedStatement.setBoolean(4, user.isGender());
            result = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public static boolean updateUser(User user) {
        boolean result = false;
        try {
            String commandText = "UPDATE users SET login = ?, password = ?, birthdate = ?, gender = ? WHERE id = ?";
            PreparedStatement preparedStatement = getConnection().prepareStatement(commandText);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setDate(3, user.getBirthdate());
            preparedStatement.setBoolean(4, user.isGender());
            preparedStatement.setInt(5, user.getId());
            result = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public static boolean deleteUser(User user) {
        boolean result = false;
        try {
            String commandText = "DELETE FROM users WHERE id = ?";
            PreparedStatement preparedStatement = getConnection().prepareStatement(commandText);
            preparedStatement.setInt(1, user.getId());
            result = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}