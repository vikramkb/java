package deadlock;

public class Deadlock{
    String str1 = "Java";
    String str2 = "UNIX";

    Thread trd1 = new Thread("My Thread 1"){
        public void run(){
            synchronized(str1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(str2){
                    System.out.println(str1 + str2);
                }
            }
        }
    };

    Thread trd2 = new Thread("My Thread 2"){
        public void run(){
            synchronized(str2){
                synchronized(str1){
                    System.out.println(str2 + str1);
                }
            }
        }
    };

    public static void main(String a[]){
        Deadlock mdl = new Deadlock();
        mdl.trd1.start();
        mdl.trd2.start();
    }
}
