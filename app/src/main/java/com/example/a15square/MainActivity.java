package com.example.a15square;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SquareModel model = new SquareModel();
        SquareView view = new SquareView(model);

        // code referenced from FlappyBird2 in CS301

        view.addButton(0,0, findViewById(R.id.b_11));
        view.addButton(0,1, findViewById(R.id.b_12));
        view.addButton(0,2, findViewById(R.id.b_13));
        view.addButton(0,3, findViewById(R.id.b_14));
        view.addButton(1,0, findViewById(R.id.b_21));
        view.addButton(1,1, findViewById(R.id.b_22));
        view.addButton(1,2, findViewById(R.id.b_23));
        view.addButton(1,3, findViewById(R.id.b_24));
        view.addButton(2,0, findViewById(R.id.b_31));
        view.addButton(2,1, findViewById(R.id.b_32));
        view.addButton(2,2, findViewById(R.id.b_33));
        view.addButton(2,3, findViewById(R.id.b_34));
        view.addButton(3,0, findViewById(R.id.b_41));
        view.addButton(3,1, findViewById(R.id.b_42));
        view.addButton(3,2, findViewById(R.id.b_43));
        view.addButton(3,3, findViewById(R.id.b_44));



        ConstraintLayout lay = (ConstraintLayout) findViewById(R.id.lay);
        model.setConstraintLayout(lay);

        SquareController controller = new SquareController(model, view);
        view.setListener(controller);
        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(controller);

        controller.initGame();

    }
}