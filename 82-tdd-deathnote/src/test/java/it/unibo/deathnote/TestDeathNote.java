package it.unibo.deathnote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.*;

class TestDeathNote {
    private DeathNote TestDeathNote;

    void setUp () {
        TestDeathNote = new DeathNoteImpl();
        assertNotNull(TestDeathNote);
    }

    void testGetRule () {
        try {
            TestDeathNote.getRule(0);
            fail("getting the rule 0 was possible, should have thrown an exception");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isBlank());
        } catch (Exception e) {
            fail("the exception thrown wasn't correct");
        }

        try {
            TestDeathNote.getRule(-1);
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
}