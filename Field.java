package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vassili.holenev on 8.04.2016.
 */
public class Field{
    private ArrayList<Card> fieldCards1;
    private ArrayList<Card> fieldCards2;
    private int maxLength = 3;

    public Field() {
        this.fieldCards1 = new ArrayList();
        this.fieldCards2 = new ArrayList();
    }

    public boolean putCard(Card card, int sideNumber) {
        if (sideNumber  == 1) {
            return put(card, fieldCards1);
        } else {
            return put(card, fieldCards2);
        }
    }

    private boolean put(Card card, ArrayList<Card> fieldCards) {
        int fieldSize = fieldCards.size();
        if (fieldSize >= maxLength) {
            return false;
        }
        fieldCards.add(card);
        return true;
    }

    public ArrayList<Card> getPlayerCards() {
        return fieldCards2;
    }

    public ArrayList<Card>putCardAndReturnList(Card card, int sideNumber) throws Exception {
        if (putCard(card, sideNumber)) {
            return getPlayerCards();
        } else {
            throw new Exception("Field is full");
        }
    }

}
