package it.unibo.deathnote.impl;

import it.unibo.deathnote.api.*;

public class DeathNoteImpl implements DeathNote {

    static int NUMBER_OF_RULES = 13;

    @Override
    public String getDeathCause(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getDeathDetails(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getRule(final int ruleNumber) {
        if(ruleNumber > NUMBER_OF_RULES && ruleNumber <= 0) {
            throw new IllegalArgumentException("there is no rule with that number");
        }
        else {
            return RULES.get(ruleNumber - 1);
        }
    }

    @Override
    public boolean isNameWritten(String name) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean writeDeathCause(String cause) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean writeDetails(String details) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void writeName(String name) {
        // TODO Auto-generated method stub
        
    }
    
}