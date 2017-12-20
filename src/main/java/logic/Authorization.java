package logic;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Authorization {
    private Boolean log=false;
    public User checkUser(String fileName, String sverkaPassword){
        File myFile = new File(fileName);
        String text="";
        if(myFile.exists()) {
            //System.out.println("Логин правильный, введите пароль");
            try {
                FileReader fileread = new FileReader(myFile);
                BufferedReader filepersreader = new BufferedReader(fileread);
                String line = null;

                while ((line = filepersreader.readLine()) != null) {

                    text = text + line;
                }
                int passStart =text.indexOf("<pass>")+6;
                int passFinish = text.indexOf("</pass>");
                String passGet = text.substring(passStart, passFinish);
                if (sverkaPassword.equals(passGet)){
                    System.out.println("Авторизация успешна");
                   // User user
                    setLog(true);
                }filepersreader.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Такого логина нет");
            setLog(true);
        }
        return null;
    }


    public Boolean getLog() {
        return log;
    }

    public void setLog(Boolean log) {
        this.log = log;
    }
}

