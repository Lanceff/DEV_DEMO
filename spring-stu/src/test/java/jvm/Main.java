package jvm;

/**
 * @author: Lance
 * @Date: 2020-09-10 17:09
 * @Description:
 */
public class Main {

     class Parent {
        public Parent(){}

    }

     class Son extends Parent{
        public Son(){
            super();
        }
    }
    public static void main(String[] args) {
        /*byte[] allocation1, allocation2;
        allocation1 = new byte[30900*1024];*/
        Main main = new Main();
        Parent parent = main.new Parent();
        Son son = main.new Son();

        System.out.println(son instanceof Parent);
        System.out.println();
    }
}
