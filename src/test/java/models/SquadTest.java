package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquadTest {
   Squad newSquad=Squad.setUpNewSquad1();
   Squad secondSquad=Squad.setUpNewSquad();
    @Test
    public void checkIfNewInstanceIsCreated(){
        assertEquals(true, newSquad instanceof Squad);
    }
    @Test
    public void checkIfSecondInstanceIsCreated(){
        assertEquals(true, secondSquad instanceof Squad);
    }

    @Test
    public void checkIfSquadNameIsGotten(){
        assertEquals("Rock", newSquad.getSquadName());
    }
    @Test
    public void checkIfSquadPurposeIsGotten(){
        assertEquals("Sexism",newSquad.getSquadPurpose());
    }
    @Test
    public void checkIfSquadSizeIsGotten(){
        assertEquals(5, newSquad.getSquadSize());
    }
    @Test
    public void getAllSquadInstances(){
        Squad newSquad=Squad.setUpNewSquad1();
        Squad nextSquad=Squad.setUpNewSquad1();
        assertTrue(Squad.getInstances().contains(newSquad));
        assertTrue((Squad.getInstances().contains(nextSquad)));
    }

    @Test
    public Void getAllSquadMembersArray(){
        Hero newHero=Hero.setUpNewHero1();
        Hero secondHero=Hero.setUpNewHero1();
        newSquad.setSquadMembers(newHero);
        assertEquals("Spike", newSquad.getSquadMembers().get(0).getName());
        return null;
    }




}