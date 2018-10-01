package com.example.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Game extends AppCompatActivity {

    Button submit;
    TextView jumbled;
    EditText input;

    String word;
    int r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        submit = (Button)findViewById(R.id.button);
        jumbled = (TextView) findViewById(R.id.jumbled);
        input = (EditText) findViewById(R.id.input);

        r = getRandom();
        jumbled.setText(Data.jumbles[r]);




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                word = input.getText().toString();
                Log.e("WORD = ",word);

                if(word.equalsIgnoreCase(Data.words[r]))
                {
                    Intent intent = new Intent(v.getContext() , Congo.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(v.getContext() , GameOver.class);
                    startActivity(intent);
                }
            }
        });



    }


    int getRandom()
    {
        Random random =new Random();
        return random.nextInt(Data.SIZE);
    }
}
