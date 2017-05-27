package tootcat.tocolocker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Arrays;

public class Step1 extends AppCompatActivity {


    int[] count=new int[9];
    private String password1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step1);

        Button tap =(Button)findViewById(R.id.tap);
        ImageButton button1=(ImageButton)findViewById(R.id.button1);
        ImageButton button2=(ImageButton)findViewById(R.id.button2);
        ImageButton button3=(ImageButton)findViewById(R.id.button3);
        ImageButton button4=(ImageButton)findViewById(R.id.button4);
        ImageButton button5=(ImageButton)findViewById(R.id.button5);
        ImageButton button6=(ImageButton)findViewById(R.id.button6);
        ImageButton button7=(ImageButton)findViewById(R.id.button7);
        ImageButton button8=(ImageButton)findViewById(R.id.button8);
        ImageButton button9=(ImageButton)findViewById(R.id.button9);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++count[0];
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++count[1];
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++count[2];
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++count[3];
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++count[4];
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++count[5];
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++count[6];
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++count[7];
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++count[8];
            }
        });


        tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password1= Arrays.toString(count);
                Intent step2=new Intent(Step1.this,Step2.class);
                step2.putExtra("pass1",password1);
                startActivity(step2);
                Step1.this.finish();

            }
        });


    }
}
