package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Card card1 = new Card(1, "Scout", 1,1,1);
        Card card2 = new Card(2, "Scout", 1,1,1);
        Card card3 = new Card(3, "Scout", 1,1,1);
        Card card4 = new Card(4, "Scout", 1,1,1);
        Card card5 = new Card(5, "Scout", 1,1,1);
        Deck newDeck = new Deck("My Deck");
        Player player1 = new Player("P1", 3, "P1N");
        newDeck.populateDeck(card1);
        newDeck.populateDeck(card2);
        newDeck.populateDeck(card3);
        newDeck.populateDeck(card4);
        newDeck.populateDeck(card5);

        newDeck.shuffle();

        player1.populateHand(newDeck);
        player1.checkCards();


    }




}
