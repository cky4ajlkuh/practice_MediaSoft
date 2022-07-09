package context;

public class UserContext {
    private static String userLogin = null;

    public static String getUserLogin() {
        return userLogin;
    }

    public static void setUserLogin(String userLogin) {
        UserContext.userLogin = userLogin;
    }
}
