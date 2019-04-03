package org.LickingHeights;

public class Card {
    private String name;
    private String suit;
    private int value;

    public Card() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name + " of "+ suit + " with a value of "+ value;
    }
}
