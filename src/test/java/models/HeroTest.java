package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    Hero newHero=Hero.setUpNewHero1();
    @Test
    public void checkIfNewInstanceIsCreated(){
        assertEquals(true, newHero instanceof Hero );

    }
    @Test
    public void checkIfHeroNameIsGotten(){
        assertEquals("Spike", newHero.getName() );
    }

    @Test
    public void checkIfHeroAgeIsGotten(){
        assertEquals(23, newHero.getAge());
    }
    @Test
    public void checkIfHeroPowerIsGotten(){
        assertEquals("Storm", newHero.getPower());
    }
    @Test
    public void checkIfHeroWeaknessISGotten(){
        assertEquals("Clumsy", newHero.getWeakness());
    }
    @Test
    public void checkIfWeGetAllInstance(){
        Hero newHero= Hero.setUpNewHero1();
        Hero nextHero=Hero.setUpNewHero1();

        assertTrue(Hero.getAllInstances().contains(newHero));
        assertTrue(Hero.getAllInstances().contains(nextHero));
    }
    @Test
    public void checkIfWeGetHeroID(){
        Hero.clearAllHeroes();
        Hero newHero= Hero.setUpNewHero1();
        Hero nextHero=Hero.setUpNewHero1();
        assertEquals(1,nextHero.getId());
    }




}