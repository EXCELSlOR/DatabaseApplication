import java.sql.Date;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {/*
        User newUser = new User(0, "dasha", "162534",
                new Date(106, 5, 4), false);
        boolean success = DatabaseService.createUser(newUser);
        System.out.println("Пользователь " + (success
                ? "успешно добавлен" : "не добавлен"));*/
        ArrayList<User> users = DatabaseService.selectUsers();
        /*
        User updateUser = users.get(2);
        updateUser.setBirthdate(new Date(106, 4, 4));
        boolean success = DatabaseService.updateUser(updateUser);
        System.out.println("Пользователь " + (success
                ? "успешно изменён" : "не изменён"));
        */
        /*
        User deleteUser = users.get(2);
        boolean success = DatabaseService.deleteUser(deleteUser);
        System.out.println("Пользователь " + (success
                ? "успешно удалён" : "не удалён"));
        users = DatabaseService.selectUsers();
        */
        for (User user : users) {
            System.out.println(user.getId() + "\t" +
                    user.getLogin() + "\t" +
                    user.getPassword() + "\t" +
                    user.getBirthdate() + "\t" +
                    (user.isGender() ? "мужской" : "женский"));
        }
    }
}