package models;

import java.util.ArrayList;

public class Hero {
    private int id;
    private String name;
    private int age;
    private String power;
    private String weakness;

    private static ArrayList<Hero> instances=new ArrayList<>();
    public Hero(int id, String name, int age, String power, String weakness){
       this.id= instances.size();
       this.name=name;
       this.age=age;
       this.power=power;
       this.weakness=weakness;
       instances.add(this);
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getPower(){
        return this.power;
    }
    public String getWeakness(){
        return this.weakness;
    }
    public static ArrayList<Hero> getAllInstances()
        {return instances;}
    public static void clearAllHeroes()
       {instances.clear();}
    public static Hero findById(int id)
    {return instances.get(id-1);}

    public static Hero setUpNewHero1(){
        return new Hero(1,"Spike",23,"Storm", "Clumsy");

    }
    public static Hero setUpNewHero2(){
        return new Hero(2,"Reign",23,"Lightning", "Poor vision");

    }
}
