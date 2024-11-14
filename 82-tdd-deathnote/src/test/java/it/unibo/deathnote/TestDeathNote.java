package it.unibo.deathnote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.*;

import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.*;

class TestDeathNote {
    private DeathNote testDeathNote;
    
    @BeforeEach
    void setUp () {
        testDeathNote = new DeathNoteImpl();
        assertNotNull(testDeathNote);
    }

    @Test
    void testGetRule () {
        try {
            testDeathNote.getRule(0);
            fail("getting the rule 0 was possible, should have thrown an exception");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isBlank());
        } catch (Exception e) {
            fail("the exception thrown wasn't correct");
        }

        try {
            testDeathNote.getRule(-1);
            fail("getting the rule -1 was possible, should have thrown an exception");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isBlank());
        } catch (Exception e) {
            fail("the exception thrown wasn't correct");
        }
    }

    @Test
    void testRules () {
        for (var rule : DeathNote.RULES) {
            assertNotNull(rule);
            assertFalse(rule.isBlank());
        }
    }

    @Test
    void testWrite () {
        String humanName = "name";
        assertFalse(testDeathNote.isNameWritten(humanName));
        testDeathNote.writeName(humanName);
        assertTrue(testDeathNote.isNameWritten(humanName));
        assertFalse(testDeathNote.isNameWritten(humanName + "s"));
        assertFalse(testDeathNote.isNameWritten(""));
    }

    @Test
    void testDeathCause () {
        String humanName1 = "name1";
        String humanName2 = "name2";
        String causeOfDeath2 = "karting accident";

        try {
            testDeathNote.writeDeathCause(causeOfDeath2);
        } catch (IllegalStateException e) {
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isBlank());
        } catch (Exception e) {
            fail("the exception thrown wasn't correct");
        }

        testDeathNote.writeName(humanName1);
        assertEquals(testDeathNote.getDeathCause(humanName1), "heart attack");

        testDeathNote.writeName(humanName2);
        assertTrue(testDeathNote.writeDeathCause(causeOfDeath2));
        assertEquals(testDeathNote.getDeathCause(humanName2), causeOfDeath2);

        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.exit(0);
        }

        assertFalse(testDeathNote.writeDeathCause(causeOfDeath2));
        assertEquals(testDeathNote.getDeathCause(humanName2), causeOfDeath2);
    }

    @Test
    void testDeathDetails () {
        String deathDetails = "ran for too long";
        String humanName = "name";

        try {
            testDeathNote.writeDetails(deathDetails);
        } catch (IllegalStateException e) {
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isBlank());
        } catch (Exception e) {
            fail("the exception thrown wasn't correct");
        }

        testDeathNote.writeName(humanName);
        assertTrue(testDeathNote.getDeathDetails(humanName).isBlank());
        assertTrue(testDeathNote.writeDetails(deathDetails));
        assertEquals(testDeathNote.getDeathDetails(humanName), deathDetails);

        try {
            Thread.sleep(6100);
        } catch (Exception e) {
            System.exit(0);
        }

        assertFalse(testDeathNote.writeDetails(deathDetails));
        assertEquals(testDeathNote.getDeathDetails(humanName), deathDetails);
    }


}