package CreationalDesignPattern;

//Thread Safety: 3) Bill Pugh
class JudgeAnalytics{
    private JudgeAnalytics(){
    }
    private static class Holder{
        private static final JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
    }
    public static JudgeAnalytics getInstance(){
        return Holder.judgeAnalytics;
    }
}
public class SingletonPattern {
    public static void main(String[] args){
        JudgeAnalytics judgeAnalytics = JudgeAnalytics.getInstance();
        JudgeAnalytics judgeAnalytics1 = JudgeAnalytics.getInstance();

        System.out.println(judgeAnalytics);
        System.out.println(judgeAnalytics1);
    }
}

//Thread Safety: 2) Double Check Locking
/*class CreationalDesignPattern.JudgeAnalytics{
    private static volatile CreationalDesignPattern.JudgeAnalytics judgeAnalytics;

    private CreationalDesignPattern.JudgeAnalytics(){
    }
    public static CreationalDesignPattern.JudgeAnalytics getInstance(){
        if(judgeAnalytics == null){
            synchronized (CreationalDesignPattern.JudgeAnalytics.class){
                if(judgeAnalytics == null){
                    judgeAnalytics = new CreationalDesignPattern.JudgeAnalytics();
                }
            }
        }
        return judgeAnalytics;
    }
}
public class CreationalDesignPattern.SingletonPattern {
    public static void main(String[] args){
        CreationalDesignPattern.JudgeAnalytics judgeAnalytics = CreationalDesignPattern.JudgeAnalytics.getInstance();
        CreationalDesignPattern.JudgeAnalytics judgeAnalytics1 = CreationalDesignPattern.JudgeAnalytics.getInstance();

        System.out.println(judgeAnalytics);
        System.out.println(judgeAnalytics1);
    }
}*/

//Thread Safety: 1)Synchronized
/*
class CreationalDesignPattern.JudgeAnalytics{
    private static CreationalDesignPattern.JudgeAnalytics judgeAnalytics;

    private CreationalDesignPattern.JudgeAnalytics(){

    }
    public static synchronized CreationalDesignPattern.JudgeAnalytics getInstance(){
        if(judgeAnalytics == null){
            judgeAnalytics = new CreationalDesignPattern.JudgeAnalytics();
        }
        return judgeAnalytics;
    }
}
public class CreationalDesignPattern.SingletonPattern {
    public static void main(String[] args){
        CreationalDesignPattern.JudgeAnalytics judgeAnalytics = CreationalDesignPattern.JudgeAnalytics.getInstance();
        CreationalDesignPattern.JudgeAnalytics judgeAnalytics1 = CreationalDesignPattern.JudgeAnalytics.getInstance();

        System.out.println(judgeAnalytics);
        System.out.println(judgeAnalytics1);
    }
}
*/

//Lazy Loading
/*
class CreationalDesignPattern.JudgeAnalytics{
    private static CreationalDesignPattern.JudgeAnalytics judgeAnalytics;

    private CreationalDesignPattern.JudgeAnalytics(){

    }
    public static CreationalDesignPattern.JudgeAnalytics getInstance(){
        if(judgeAnalytics == null){
            judgeAnalytics = new CreationalDesignPattern.JudgeAnalytics();
        }
        return judgeAnalytics;
    }
}
public class CreationalDesignPattern.SingletonPattern {
    public static void main(String[] args){
        CreationalDesignPattern.JudgeAnalytics judgeAnalytics = CreationalDesignPattern.JudgeAnalytics.getInstance();
        CreationalDesignPattern.JudgeAnalytics judgeAnalytics1 = CreationalDesignPattern.JudgeAnalytics.getInstance();

        System.out.println(judgeAnalytics);
        System.out.println(judgeAnalytics1);
    }
}
*/

//Eager Loading
/*
class CreationalDesignPattern.JudgeAnalytics{
    private static final CreationalDesignPattern.JudgeAnalytics judgeAnalytics = new CreationalDesignPattern.JudgeAnalytics();

    private CreationalDesignPattern.JudgeAnalytics(){

    }
    public static CreationalDesignPattern.JudgeAnalytics getInstance(){
        return judgeAnalytics;
    }
}
public class CreationalDesignPattern.SingletonPattern {
    public static void main(String[] args){
        CreationalDesignPattern.JudgeAnalytics judgeAnalytics = CreationalDesignPattern.JudgeAnalytics.getInstance();
        CreationalDesignPattern.JudgeAnalytics judgeAnalytics1 = CreationalDesignPattern.JudgeAnalytics.getInstance();

        System.out.println(judgeAnalytics);
        System.out.println(judgeAnalytics1);
    }
}
*/

//a) Problem
/*
class CreationalDesignPattern.JudgeAnalytics{
    private int run = 0;
    private int submit = 0;

    public void countRun(){
        run++;
    }
    public void countSubmit(){
        submit++;
    }

    public int getRun() {
        return run;
    }

    public int getSubmit() {
        return submit;
    }
}
public class CreationalDesignPattern.SingletonPattern {
    public static void main(String[] args){
        CreationalDesignPattern.JudgeAnalytics judgeAnalytics = new CreationalDesignPattern.JudgeAnalytics();
        judgeAnalytics.countRun();
        judgeAnalytics.countSubmit();

        CreationalDesignPattern.JudgeAnalytics judgeAnalytics1 = new CreationalDesignPattern.JudgeAnalytics();
        judgeAnalytics1.countRun();
        judgeAnalytics1.countSubmit();

        System.out.println(judgeAnalytics1.getRun());
        System.out.println(judgeAnalytics);
        System.out.println(judgeAnalytics1);
    }
}
*/
