package com.example.a15square;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SquareView {


    private SquareModel model;

    // array of numbers to see the order of the buttons
    public int[] numbers = new int[16];

    public SquareView(SquareModel m)
    {
        model = m;
    }

    public void addButton(int row, int col, Button b)
    {
        model.buttons[row][col] = b;
    }

    // helper method for swap buttons, makes adjacent buttons to the blank square clickable and
    // everything else un-clickable
    public void toggleButtons(Button button) {
        for (int i = 0; i < model.size; i++) {
            for (int j = 0; j < model.size; j++) {
                model.buttons[i][j].setClickable(false);
                model.buttons[i][j].setVisibility(View.VISIBLE);
            }
        }
        int row = model.row(button);
        int col = model.col(button);
        model.buttons[row][col].setVisibility(View.INVISIBLE);

        if (row+1 < model.size) {
            model.buttons[row+1][col].setClickable(true);
        }

        if (row-1 >= 0) {
            model.buttons[row-1][col].setClickable(true);
        }

        if (col+1 < model.size) {
            model.buttons[row][col+1].setClickable(true);
        }

        if (col-1 >= 0) {
            model.buttons[row][col-1].setClickable(true);
        }
        return;

    }

    // check if win through seeing if numbers array is in ascending order

    public void checkWin() {
        boolean flag = true;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[i-1]) {
                flag = false;
            }
        }
        if (flag) {
            model.lay.setBackgroundColor(Color.BLUE);
            // if theres a win, then change background color to blue
        }
    }
    public void setListener(SquareController ocl)
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                model.buttons[i][j].setOnClickListener((View.OnClickListener) ocl);
            }
        }

    }
}
