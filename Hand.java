package com.company;

import java.util.ArrayList;

/**
 * Created by vassili.holenev on 7.04.2016.
 */
public abstract class Hand {

    private String hand;
    private int numberOfCards;
    private ArrayList<Card> myHand;

    public Hand(String hand, int numberOfCards) {
        this.hand = hand;
        this.numberOfCards = numberOfCards;
        this.myHand = new ArrayList<>();
    }

    public void populateHand(Deck deck){
        for(int i=0; i<numberOfCards; i++){
            myHand.add(deck.fetch());
        }
    }

    public void checkCards(){
        for(int i=0; i<myHand.size(); i++)
        System.out.println(myHand.get(i));
    }
}
