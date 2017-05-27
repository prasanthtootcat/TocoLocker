package tootcat.tocolocker;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Arrays;

public class Step2 extends AppCompatActivity {

    int[] count = new int[9];
    private String password1, password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step2);

        final SQLiteDatabase db = openOrCreateDatabase("lockerDB", Context.MODE_PRIVATE, null);

        Button tap = (Button) findViewById(R.id.tap);
        ImageButton button1 = (ImageButton) findViewById(R.id.button1);
        ImageButton button2 = (ImageButton) findViewById(R.id.button2);
        ImageButton button3 = (ImageButton) findViewById(R.id.button3);
        ImageButton button4 = (ImageButton) findViewById(R.id.button4);
        ImageButton button5 = (ImageButton) findViewById(R.id.button5);
        ImageButton button6 = (ImageButton) findViewById(R.id.button6);
        ImageButton button7 = (ImageButton) findViewById(R.id.button7);
        ImageButton button8 = (ImageButton) findViewById(R.id.button8);
        ImageButton button9 = (ImageButton) findViewById(R.id.button9);

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
                password2 = Arrays.toString(count);
                password1 = getIntent().getStringExtra("pass1");

                if (password1.equals(password2)&&password1!=null) {
                    Toast.makeText(Step2.this, "Vola!", Toast.LENGTH_SHORT).show();
                    db.execSQL("INSERT INTO locked VALUES('"+password2+"');");
                    startActivity(new Intent(Step2.this, MainActivity.class));
                } else {
                    Toast.makeText(Step2.this, "Passwords dont't match!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Step2.this, Setup.class));
                }
                Step2.this.finish();

            }
        });
    }
}