package com.example.a15square;

import android.widget.Button;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

public class SquareModel {

    public final int size = 4;

    Button[][] buttons;

    ConstraintLayout lay;
    public SquareModel()
    {
        buttons = new Button[size][size];
    }


    public int row(Button b) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (b == buttons[i][j]) {
                    return i;
                }
            }
        }
        return 0;
    }

    public int col(Button b) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (b == buttons[i][j]) {
                    return j;
                }
            }
        }
        return 0;
    }

    public void setConstraintLayout(ConstraintLayout layout) {
        lay = layout;
    }
}
