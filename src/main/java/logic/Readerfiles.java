package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Readerfiles {}
   /* private String FILE_NAME_READ;
    private boolean fileHowAreYou=false;
    //private String text="";


    void take(){
        //String text="";
        File myFile = new File(FILE_NAME_READ);
        String text=null;
        if(myFile.exists()) {
            System.out.println("Логин правильный, введите пароль");
            try {
                FileReader filepers = new FileReader(myFile);
                BufferedReader filepersreader = new BufferedReader(filepers);
                String line = null;

                while ((line=filepersreader.readLine())!=null){

                    text=text+line;
                }
                filepersreader.close();
            } catch (Exception ex){
                ex.printStackTrace();
            }


            zapolnenieAuthorization(text);
            zapolneniePersonaj(text);


            String filename;
            //setFileHowAreYou()=true;
            fileHowAreYou=true;
        } else {
            System.out.println("Такого логина нет");
        }
       // System.out.println(text);
       // return text;
    }



    public void exitFromCharacter(){
        fileHowAreYou=false;
    }


    private void zapolneniePersonaj(String text) {
        Authorization authorization = new Authorization();
        int passStart =text.indexOf("<pass>")+6;
        int passFinish = text.indexOf("</pass>");
        String passGet = text.substring(passStart, passFinish);
        authorization.setPasswordAuth(passGet);
    }

    private void zapolnenieAuthorization(String text){

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
        System.out.println("Проверка за кого зашли"+personaj.getNameC());

    }

   // public Character[] vivodClassov() {
     //   Character[] character = new Character[1];
     //   character[0]=new Character();
     //   System.out.println("Проверка за кого зашли"+character[0].getNameC());
   // }









    public String getFILE_NAME_READ() {
        return FILE_NAME_READ;
    }

    public void setFILE_NAME_READ(String FILE_NAME_READ) {
        this.FILE_NAME_READ = FILE_NAME_READ;
    }

    public boolean isFileHowAreYou() {
        return fileHowAreYou;
    }

    public void setFileHowAreYou(boolean fileHowAreYou) {
        this.fileHowAreYou = fileHowAreYou;
    }


}



     //File myFile = new File(FILE_NAME_READ);
     // if(myFile.exists()) {
     //     System.out.println("Файл существует");
     // } else {
     //     System.out.println("Файл еще не создан");
     // }



    public void Readerfile{
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_READ))) {

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                fulltext=fulltext+line;
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/