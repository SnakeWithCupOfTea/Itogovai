package logic;

import java.io.*;
import java.util.*;
public class FileHandler {

    private boolean fileHowAreYou = false;

    public void chtenieFile(String log, String pass,String fileName) {
        File myFile = new File(fileName);
        String text = "";
        if (myFile.exists()) {
            try {
                FileReader fileread = new FileReader(myFile);
                BufferedReader filepersreader = new BufferedReader(fileread);
                String line = null;
                while ((line = filepersreader.readLine()) != null) {
                    text = text + line;
                }
                User user = setUser(text);
                Personaj personaj = setPersonaj(text);




                if (pass.equals(user.getPasswordAuth())) {
                    System.out.println("Авторизация успешна");
                    setFileHowAreYou(true);
                }
                filepersreader.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Такого логина нет");
            setFileHowAreYou(false);
        }

    }


    public void revriteFile(String fileName, String lvlChange,String expChange ){
        File myFile = new File(fileName);
        String text = "";

        int lastitem=0;
        String[] fulltextend = new String[1000];
        try {
            int i=0;
            FileReader fileread = new FileReader(myFile);
            BufferedReader filepersreader = new BufferedReader(fileread);

            String line = null;
            while ((line = filepersreader.readLine()) != null) {
                text = text + line;
                fulltextend[i]=line;
                i++;
            }
            User user = setUser(text);
            Personaj personaj = setPersonaj(text);
            System.out.println("Ваше имя: "+personaj.getNameC());
            System.out.println("Ваш уровень: "+personaj.getLvlC());
            System.out.println("Ваш опыт равен: "+personaj.getExpirienceC());
            //getPers(personaj,user);
            lastitem = fulltextend.length;
            int son1=personaj.getExpirienceC()+Integer.parseInt(expChange);
            String son2=String.valueOf(son1);
            fulltextend[3]=("<exp>"+son2+"</exp>");
            int son=personaj.getLvlC()+Integer.parseInt(lvlChange);
            String son3=String.valueOf(son);
            fulltextend[2]=("<lvl>"+son3+"</lvl>");
            fileread.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(myFile,false))
        {

            for (int i=0; i<lastitem; i++){
                writer.write(fulltextend[i]);
                writer.append(System.lineSeparator());

            }
            writer.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }


    }


    public void createFile(String newLogin, String newPassword,String newLvl,String newExp,String newNick,String newPeace,String newProfe ){
        File myFile = new File(newLogin+".txt");
        if(myFile.exists()) {
            System.out.println("Такой ник уже существует");
        } else {
            System.out.println("Персонаж создан");
            String[] fulltextend = new String[100];
            fulltextend[0]="<log>"+newLogin+"</log>";
            fulltextend[1]="<pass>"+newPassword+"</pass>";
            fulltextend[2]="<lvl>"+newLvl+"</lvl>";
            fulltextend[3]="<exp>"+newExp+"</exp>";
            fulltextend[4]="<nickname>"+newLogin+"</nickname>";
            fulltextend[5]="<peace>stormgrad</peace>";
            fulltextend[6]="proff fishing";
            fulltextend[7]="<lvlF>1</lvlF>";
            try(FileWriter writer = new FileWriter(myFile, false))
            {
                for (int i=0; i<8; i++){
                    writer.write(fulltextend[i]);
                    writer.append(System.lineSeparator());
                }

                writer.close();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }



        }
    }


    public static User setUser(String text){

        User user = new User();

        int passStart =text.indexOf("<pass>")+6;
        int passFinish = text.indexOf("</pass>");
        String passGet = text.substring(passStart, passFinish);
        int logStart =text.indexOf("<log>")+5;
        int logFinish = text.indexOf("</log>");
        String logGet = text.substring(logStart, logFinish);
        String fileget = logGet+".txt";

        user.setPasswordAuth(passGet);
        user.setLoginAuth(logGet);
        user.setFILE_NAME_AUTHORIZATION(fileget);

        return user;
    }


    public static Personaj setPersonaj(String text){
        Personaj personaj = new Personaj();

        int lvlStart =text.indexOf("<lvl>")+5;
        int lvlFinish = text.indexOf("</lvl>");
        String lvlGet = text.substring(lvlStart, lvlFinish);              //окей, вытащили инфу
        int lvlChange = Integer.parseInt(lvlGet);
        personaj.setLvlC(lvlChange);

        int expStart =text.indexOf("<exp>")+5;
        int expFinish = text.indexOf("</exp>");
        String expGet = text.substring(expStart, expFinish);
        int expChange = Integer.parseInt(expGet);
        personaj.setExpirienceC(expChange);

        text = text+"; "+Integer.toString(lvlStart)+"; "+Integer.toString(lvlFinish);
        int nicknameStart =text.indexOf("<nickname>")+10;
        int nicknameFinish = text.indexOf("</nickname>");
        String nicknameGet = text.substring(nicknameStart, nicknameFinish);
        personaj.setNameC(nicknameGet);
        return personaj;
    }


    public boolean isFileHowAreYou() {
        return fileHowAreYou;
    }

    public void setFileHowAreYou(boolean fileHowAreYou) {
        this.fileHowAreYou = fileHowAreYou;
    }
}


/*
                user.setLoginAuth(pam);

                int passStart =text.indexOf("<pass>")+6;
                int passFinish = text.indexOf("</pass>");
                String passGet = text.substring(passStart, passFinish);
                user.setPasswordAuth(passGet);

                int lvlStart =text.indexOf("<lvl>")+5;
                int lvlFinish = text.indexOf("</lvl>");
                String lvlGet = text.substring(lvlStart, lvlFinish);              //окей, вытащили инфу
                int lvlChange = Integer.parseInt(lvlGet);
                personaj.setLvlC(lvlChange);

                int expStart =text.indexOf("<exp>")+5;
                int expFinish = text.indexOf("</exp>");
                String expGet = text.substring(expStart, expFinish);
                int expChange = Integer.parseInt(expGet);
                personaj.setExpirienceC(expChange);

                text = text+"; "+Integer.toString(lvlStart)+"; "+Integer.toString(lvlFinish);
                int nicknameStart =text.indexOf("<nickname>")+10;
                int nicknameFinish = text.indexOf("</nickname>");
                String nicknameGet = text.substring(nicknameStart, nicknameFinish);

                personaj.setNameC(nicknameGet);
                System.out.println("Проверка за кого зашли"+personaj.getNameC());
*/