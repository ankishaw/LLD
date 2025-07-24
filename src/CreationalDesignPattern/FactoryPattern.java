package CreationalDesignPattern;

interface Logistics{
    void send();
}
class Road implements Logistics{
    @Override
    public void send(){
        System.out.println("CreationalDesignPattern.Road CreationalDesignPattern.Logistics");
    }
}
class Air implements Logistics{
    @Override
    public void send(){
        System.out.println("CreationalDesignPattern.Air CreationalDesignPattern.Logistics");
    }
}

class LogisticsFactory{
    public static Logistics getLogistics(String mode){
        if(mode == "CreationalDesignPattern.Air"){
            return new Air();
        }
        else if (mode == "CreationalDesignPattern.Road"){
            return new Road();
        }
        return null;
    }
}
class LogisticsService{
    public void send(String mode){
        Logistics logistics = LogisticsFactory.getLogistics(mode);
        logistics.send();
    }
}
public class FactoryPattern {
    public static void main(String[] args){
        LogisticsService log = new LogisticsService();
        log.send("CreationalDesignPattern.Air");
        //log.send("CreationalDesignPattern.Road");
    }
}

//Problem
/*interface CreationalDesignPattern.Logistics{
    void send();
}
class CreationalDesignPattern.Road implements CreationalDesignPattern.Logistics{
    @Override
    public void send(){
        System.out.println("CreationalDesignPattern.Road CreationalDesignPattern.Logistics");
    }
}
class CreationalDesignPattern.Air implements CreationalDesignPattern.Logistics{
    @Override
    public void send(){
        System.out.println("CreationalDesignPattern.Air CreationalDesignPattern.Logistics");
    }
}

class CreationalDesignPattern.LogisticsService{
    public void send(String mode){
        if(mode == "CreationalDesignPattern.Air"){
            CreationalDesignPattern.Logistics logistics = new CreationalDesignPattern.Air();
            logistics.send();
        }
        else if (mode == "CreationalDesignPattern.Road"){
            CreationalDesignPattern.Logistics logistics = new CreationalDesignPattern.Road();
            logistics.send();
        }
    }
}
public class CreationalDesignPattern.FactoryPattern {
    public static void main(String[] args){
        CreationalDesignPattern.LogisticsService log = new CreationalDesignPattern.LogisticsService();
        log.send("CreationalDesignPattern.Air");
        log.send("CreationalDesignPattern.Road");
    }
}*/
