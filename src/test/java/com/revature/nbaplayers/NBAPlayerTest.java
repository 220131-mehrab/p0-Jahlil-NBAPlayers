package com.revature.nbaplayers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NBAPlayerTest extends Assertions {
    @Test
    public void logicTest(){
        NBATest nba = new NBATest();
        assertEquals(nba.getPlayer("James Harden"),nba.getPlayer("James Harden"));
        //assertNotEquals(nba.getPlayer("Russell Westbrook"), nba.getPlayer("James Harden"));
    }
}
