package it.unibo.deathnote.impl;

import java.util.HashMap;

import it.unibo.deathnote.api.*;

public class DeathNoteImpl implements DeathNote {

    static int NUMBER_OF_RULES = 13;
    HashMap<String, Death> kills;
    String lastName;

    public DeathNoteImpl () {
        this.kills = new HashMap<>();
        lastName = null;
    }

    @Override
    public String getDeathCause(final String name) {
        return kills.get(name).cause;
    }

    @Override
    public String getDeathDetails(final String name) {
        return kills.get(name).details;
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
    public boolean isNameWritten(final String name) {
        return kills.containsKey(name);
    }

    @Override
    public boolean writeDeathCause(final String cause) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean writeDetails(final String details) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void writeName(final String name) {
        if(name == null) {
            throw new NullPointerException("the name written cannot be null");
        }
        this.kills.put(name, new Death());
        this.lastName = name;
    }

    private static final class Death {
        final static String DEFAULT_CAUSE_OF_DEATH = "heart attack";
        final static String DEFAULT_DETAIL_OF_DEATH = "";
        private String cause;
        private String details;
        private double time;

        public Death () {
            this.cause = DEFAULT_CAUSE_OF_DEATH;
            this.details = DEFAULT_DETAIL_OF_DEATH;
            this.time = System.currentTimeMillis();
        }

        public double getTime() {
            return this.time;
        }
    }
    
}