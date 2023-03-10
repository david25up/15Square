package com.example.a15square;


import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

public class SquareController implements View.OnClickListener {
    private SquareView view;
    private SquareModel model;


    public SquareController(SquareModel m, SquareView v)
    {
        model = m;
        view = v;
    }

    // if button isnt reset button, swap buttons
    // else reset board
    public void onClick(View v)
    {
        Button button = (Button) v;
        if (button.getId() == R.id.reset) {
            initGame();
        } else {
            swapSquare(button);
        }
    }

    // swap the button clicked with the invisible button

    public void swapSquare(Button b) {
        int swapR = model.row(b);
        int swapC = model.col(b);
        int blankR = 0;
        int blankC = 0;
        for (int i = 0; i < model.size; i++) {
            for (int j = 0; j < model.size; j++) {
                if (model.buttons[i][j].getVisibility() == View.INVISIBLE) {
                        blankR = i;
                        blankC = j;
                    }
                }
            }
        int num = view.numbers[4*swapR+swapC];
        view.numbers[4*swapR+swapC] = view.numbers[4*blankR+blankC];
        view.numbers[4*blankR+blankC] = num;
        model.buttons[blankR][blankC].setText("" + num);
        model.buttons[swapR][swapC].setText("" + view.numbers[4*swapR+swapC]);
        view.toggleButtons(b);

        view.checkWin();
    }


    //initialize the game- create an array of num 1-16 and shuffle them into the numbers array
    // randomly
    public void initGame()
    {
        int[] temp = new int[model.size * model.size];

        Random rng = new Random();

        for (int i = 0; i < model.size * model.size; i++) {
                temp[i] = i + 1;
        }

        for (int i = 0; i < model.size; i++) {
            for (int j = 0; j < model.size; j++) {
                boolean flag = false;
                while (!flag) { //until an available button is chosen, choose a random int
                    int shuffle = rng.nextInt(16);
                    if (temp[shuffle] != 0) {
                        view.numbers[4*i+j] = temp[shuffle];
                        temp[shuffle] = 0;
                        flag = true;
                        int result = shuffle++;
                        model.buttons[i][j].setText("" + shuffle);
                        model.buttons[i][j].setClickable(false);

                        if (4*i+j+1 == 16) {
                            model.buttons[i][j].setVisibility(View.INVISIBLE);
                            view.toggleButtons(model.buttons[i][j]);
                        }
                    }
                }
           }
        }
    }
}
