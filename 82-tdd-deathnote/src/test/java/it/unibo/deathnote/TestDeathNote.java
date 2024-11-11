package it.unibo.deathnote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.*;

class TestDeathNote {
    private DeathNote testDeathNote;

    void setUp () {
        testDeathNote = new DeathNoteImpl();
        assertNotNull(testDeathNote);
    }

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

    void testRules () {
        for (var rule : DeathNote.RULES) {
            assertNotNull(rule);
            assertFalse(rule.isBlank());
        }
    }

    void testWrite () {
        String humanName = "name";
        assertFalse(testDeathNote.isNameWritten(humanName));
        testDeathNote.writeName(humanName);
        assertTrue(testDeathNote.isNameWritten(humanName));
        assertFalse(testDeathNote.isNameWritten(humanName + "s"));
        assertFalse(testDeathNote.isNameWritten(""));
    }
}