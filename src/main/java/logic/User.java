package logic;

public class User {
    private String FILE_NAME_AUTHORIZATION;
    private String loginAuth;
    private String passwordAuth;

    public String getLoginAuth() {
        return loginAuth;
    }

    public void setLoginAuth(String loginAuth) {
        this.loginAuth = loginAuth;
    }

    public String getPasswordAuth() {
        return passwordAuth;
    }

    public void setPasswordAuth(String passwordAuth) {
        this.passwordAuth = passwordAuth;
    }

    public String getFILE_NAME_AUTHORIZATION() {
        return FILE_NAME_AUTHORIZATION;
    }

    public void setFILE_NAME_AUTHORIZATION(String FILE_NAME_AUTHORIZATION) {
        this.FILE_NAME_AUTHORIZATION = FILE_NAME_AUTHORIZATION;
    }
}
