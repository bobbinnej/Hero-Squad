package models;

import java.util.ArrayList;

public class Squad {
 private int squadId;
 private String squadName;
 private int squadSize;
 private String squadPurpose;

    private ArrayList<Hero> squadMembers = new ArrayList<>();
    private static ArrayList<Squad> instances = new ArrayList<>();


    public Squad(String name, int size, String squadPurpose) {
       squadName=name;
       squadSize=size;
       this.squadPurpose=squadPurpose;
       this.squadMembers = new ArrayList<>();
       instances.add(this);
       this.squadId = instances.size();

    }
    public int getSquadId () {
        return squadId;
    }
    public static Squad findBySquadId ( int id){
        return instances.get(id - 1);
    }
    public String getSquadName () {
        return squadName;
    }
    public int getSquadSize () {
        return squadSize;
    }
    public String getSquadPurpose () {
        return this.squadPurpose;
    }
    public static ArrayList<Squad> getInstances () {
        return instances;
    }
    public ArrayList<Hero> getSquadMembers () {
        return squadMembers;
    }
    public void setSquadMembers (Hero newMember){
        squadMembers.add(newMember);
    }
    public static void clearAllSquads() {
        instances.clear();
    }
    public void clearAllSquadMembers () {
        getSquadMembers().clear();
    }

    public static Squad setUpNewSquad () {
        return new Squad("Alligators", 5, "Sneezing");
    }
    public static Squad setUpNewSquad1 () {
        return new Squad("Rock", 5, "Sexism");
    }
}
