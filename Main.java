package com.company;


import java.util.*;
import java.util.Scanner;
import java.io.IOException;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;



public class Main {

    static boolean endGame;

    public static void main(String[] args) throws IOException {

        int number;
        Card currentCard;

        Scanner scanner = new Scanner(System.in);

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


        Field field = new Field();

        /*Panel mainPanel = new Panel();
        mainPanel.setLayoutManager(new LinearLayout(Direction.VERTICAL));

        Panel topPanel = new Panel();
        mainPanel.addComponent(topPanel.withBorder(Borders.singleLine("AI")));

        Panel bottomPanel = new Panel();
        mainPanel.addComponent(bottomPanel.withBorder(Borders.singleLine("PC")));

        window.setComponent(mainPanel.withBorder(Borders.singleLine("Game")));
        gui.addWindow(window);
*/
        // Setup terminal and screen layers
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();

        // Create window to hold the panel
        BasicWindow window = new BasicWindow();

        Panel mainPanel = new Panel();
        mainPanel.setLayoutManager(new LinearLayout(Direction.VERTICAL));

        Panel topPanel = new Panel();
        mainPanel.addComponent(topPanel.withBorder(Borders.singleLine("Left Panel")));

        Panel bottomPanel = new Panel();
        mainPanel.addComponent(bottomPanel.withBorder(Borders.singleLine("Right Panel")));

        window.setComponent(mainPanel.withBorder(Borders.singleLine("Main Panel")));

        // Create gui and start gui
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
        gui.addWindowAndWait(window);

        //startGame();

        /*while (endGame != true) {
            player1.checkCards();
            printMenu();
            try {
                number = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter number");
                continue;
            }

            switch (number) {
                case 1:
                    number = scanner.nextInt();
                    if(player1.checkIfCardExist(number)) {
                        currentCard = player1.getCard(number);
                        field.putCard(currentCard, 1);
                    }
                    break;
            }



        }*/


        /*if (field.putCard(card1, 1)) {
            System.out.println(field.getPlayerCards());
        } else {
            System.out.println("field is full");
        }

        try {
            System.out.println(field.putCardAndReturnList(card2, 1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } */


    }

    private static void startGame() {
        System.out.println("Let's play a game!");
        endGame = false;
    }

    private static void printMenu(){
        System.out.println(
                "Press 1 - Play card\n" +
                "Press 2 - Skip turn\n"+
                "Press 3 - Surrender");
    }




}
