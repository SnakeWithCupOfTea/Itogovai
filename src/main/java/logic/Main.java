package logic;



import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String commandRegORAuth=null;
        String newLogin = null;
        String newPassword = null;
        String newNick=null;
        String newExp = null;
        String newLvl=null;
        String newPeace=null;
        String newProf=null;
        String sverkaLogin = null;
        String sverkaPassword = null;
        Boolean exit=false;
        Boolean backGMenu=false;
        String fileName=null;
        //Boolean backMenu = false;
        String action = null;
        Scanner in = new Scanner(System.in);
        while (exit==false) {
            System.out.println("Наберите registration или login для продолжения.");
            System.out.println("Для выхода наберите exit.");
            commandRegORAuth = in.nextLine();
            if (commandRegORAuth.equals("registration")) {
                System.out.println("Добро пожаловать,новичок, введите имя, оно же станет логином");
                newLogin = in.nextLine();
                System.out.println("Отлично, теперь введите пароль");
                newPassword = in.nextLine();
                FileHandler fileHandler = new FileHandler();

                 newNick=newLogin;
                 newExp = "1";
                 newLvl="1";
                 newPeace="stormgrad";
                 newProf="";
                fileHandler.createFile(newLogin, newPassword, newLvl, newExp, newNick, newPeace, newProf);
            }
            if (commandRegORAuth.equals("login")) {

                while (backGMenu == false) {
                    System.out.println("Введите логин.");
                    System.out.println("Для возвращения в гланое меню наберите - back");
                    sverkaLogin = in.nextLine();
                    System.out.println("Введите пароль.");
                    sverkaPassword = in.nextLine();
                    fileName = sverkaLogin + ".txt";
                    FileHandler fileHandler = new FileHandler();

                    fileHandler.chtenieFile(sverkaLogin, sverkaPassword, fileName);


                    if (fileHandler.isFileHowAreYou() == true) {


                        while (backGMenu == false || exit == false) {
                            System.out.println("Выберите действие:");
                            System.out.println("Перейти на локацию - наберите travel");
                            System.out.println("Вернуться к вводу логина - back");
                            System.out.println("Выход - exit");
                            action = in.nextLine();

                            if (action.equals("back")) {
                                backGMenu = true;
                            }
                            if (action.equals("exit")) {
                                backGMenu = true;
                                exit = true;
                            }

                            if (action.equals("travel")) {
                                System.out.println("Выберите место путишествия:");
                                System.out.println("storm, iron or lok");
                                action = in.nextLine();
                                if (action.equals("storm")) {
                                    System.out.println("Вы добрались до Штормграда и пошли рыбачить");
                                }
                                if (action.equals("iron")) {
                                    System.out.println("Вы добрались до Стальнгорна и пошли рыбачить");
                                }
                                if (action.equals("lok")) {
                                    System.out.println("Вы добрались до Лок'Модана и пошли рыбачить");
                                }
                                String lvlChange = null;
                                String expChange = null;
                                lvlChange = "1";
                                expChange = "1000";
                                fileHandler.revriteFile(fileName, lvlChange, expChange);
                                System.out.println("Вы закончили рыбачить и отправились домой");
                            }
                        }
                    }
                    if (sverkaLogin.equals("back") || sverkaPassword.equals("back")) {
                        backGMenu = true;
                    }
                }

            } else {

            }
            backGMenu=false;
            if (commandRegORAuth.equals("exit")){
                exit=true;
            }
        }
    }
}
//&& - И - If(X>=300 && x<400)
//|| - или
// != - не равно