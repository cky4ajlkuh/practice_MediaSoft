package authentication;

import context.UserContext;

import java.util.Scanner;

public class Authentication {
    private static final String LOGIN = "админ";
    private static final String PASSWORD = "1";

    public static void authenticate() {
        int numberOfAttempt = 3;
        boolean isSuccessfully = false;
        Scanner scanner = new Scanner(System.in);
        while (numberOfAttempt > 0) {
            System.out.print("Логин: ");
            String login = scanner.nextLine();
            System.out.print("Пароль: ");
            String password = scanner.nextLine();
            if (login.equals(LOGIN) && password.equals(PASSWORD)) {
                isSuccessfully = true;
                UserContext.setUserLogin(login);
                System.out.println("Вы вошли!");
                break;
            } else {
                System.out.println("Пароль/Логин неверный! Попробуйте снова! \n");
            }
            numberOfAttempt--;
        }
        if (!isSuccessfully) {
            throw new RuntimeException("Пароль/Логин неверный! Попробуйте позже!");
        }
    }
}
