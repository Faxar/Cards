package com.company;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) {

        int number;
        int turn = 1;

        BufferedReader br;
        String line;
        String[] cardData;
        String fileName = "cards.csv";
        Card card;

        Deck newDeck = new Deck("Player1");
        Field newField = new Field();

        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                cardData = line.split(",");
                card = new Card(
                        Integer.parseInt(cardData[0].trim()),
                        cardData[1],
                        Integer.parseInt(cardData[2].trim()),
                        Integer.parseInt(cardData[3].trim()),
                        Integer.parseInt(cardData[4].trim())
                );
                newDeck.populateDeck(card);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        newDeck.shuffle();   //Shuffle your hand
        Hand newHand = new Hand("myHand");
        newHand.populateHand(newDeck);

        Scanner newScanner = new Scanner(System.in);

        Card tempCard;

        startGame();

        System.out.println("You have following cards in your hand : ");
        newHand.checkCards();
        boolean endGame = false;
        while (!endGame) {

            System.out.println("Turn " + turn);
            printMenu();

            try {
                number = newScanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter correct number");
                continue;
            }

            switch (number) {

                case 1:
                    System.out.println("Enter card number");
                    newHand.checkCards();
                    number = newScanner.nextInt();
                    if (number < 0) {
                        System.out.println("Please enter positive number");
                    } else if (newHand.checkIfCardExist(number)) {
                        tempCard = newHand.getCard(number);
                        newField.putCardOnF(tempCard, 1);
                        System.out.println("Now on the field there is:");
                        newField.returnFieldCards();
                    }
                    break;

                case 2:
                    if (newHand.checkAmountOfCards() >= 3 && newDeck.amountCardsInDeck() > 0) {
                        Card burned = newDeck.fetch();
                        System.out.println("You have full hand.\n" + burned + '\n' + " have burned down");
                        System.out.println("You have " + newDeck.amountCardsInDeck() + " cards, left in your deck");
                    } else if (newHand.checkAmountOfCards() < 3 && newDeck.amountCardsInDeck() > 0) {
                        Card pullFromDeck = newDeck.fetch();
                        newHand.endTurnCardDrow(pullFromDeck);
                        System.out.println("You have pulled " + pullFromDeck + " card");
                    } else {
                        System.out.println("You have " + newDeck.amountCardsInDeck() + " cards, left in your deck");
                        System.out.println("Your current health is " + newHand.checkPlayerHealth());
                        newHand.removePlayerHealth(5);
                        System.out.println("You are suffering fatigue death and you have lost 5 Health");
                        System.out.println("Your new health number is " + newHand.checkPlayerHealth());
                        if (newHand.checkPlayerHealth() <= 0) {
                            System.out.println("You Dead! MuaHaHaHa!");
                            endGame = true;
                            break;
                        }
                    }
                    turn++;
                    newField.clearFatigue(1);
                    break;

                case 3:
                    System.out.println("Weakling!");
                    endGame = true;
                    break;
            }


        }


    }

    private static void startGame() {
        System.out.println("Let's the Games begin!");
    }

    private static void printMenu() {
        System.out.println("Please press action\n" +
                "Press 1 - Play Card from the hand\n" +
                "Press 2 - End Turn\n" +
                "Press 3 - Surrender\n");
    }

}


