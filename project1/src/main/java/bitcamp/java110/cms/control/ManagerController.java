package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Member;

public class ManagerController extends Member{

    static Scanner keyIn = new Scanner(System.in);
    static Manager[] managers = new Manager[100];
    static int managerIndex = 0;
    
    static class Manager extends Member{

        protected String tel;
        protected String position;

        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public String getPosition() {
            return position;
        }
        public void setPosition(String position) {
            this.position = position;
        }
    }
    
    public static void serviceManagerMenu() {
        
        while(true) 
        {
            System.out.print("매니저관리> ");
            String command = keyIn.nextLine();
            
            if(command.equals("add")) {
                inputManagers();
            }else if(command.equals("list")) {
                printManagers();
            }else if(command.equals("quit")) {
                break;
            }else {
                System.out.println("잘못입력하셨습니다.");
            }
        }
    }



    private static void inputManagers() {
        
        while(true)
        {
            Manager m = new Manager();
            
            System.out.print("이름? ");
            m.setName(keyIn.nextLine());
            
            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());
        
            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());

            System.out.print("전화? ");
            m.setTel(keyIn.nextLine());

            System.out.print("직위? ");
            m.setPosition(keyIn.nextLine());
            
            managers[managerIndex++] = m;
            
            System.out.print("계속 하시겠습니까? (Y/n)"); 
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n"))    
                break;
            
        }
    }

    private static void printManagers() {
        
        for(Manager m : managers) {
            if(m==null) break;
            System.out.printf("%s, %s, %s, %s, %s\n"
                    ,m.getName()
                    ,m.getEmail()
                    ,m.getPassword()
                    ,m.getTel()
                    ,m.getPosition());
        }
    }

}
