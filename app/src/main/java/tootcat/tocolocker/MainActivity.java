package tootcat.tocolocker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.database.sqlite.*;
import android.database.*;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    int[] count=new int[9];
    int tapCount=0;
    String attempt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SQLiteDatabase db=openOrCreateDatabase("lockerDB",Context.MODE_PRIVATE,null);

        final Button tap =(Button)findViewById(R.id.tap);
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
            public void onClick(View view) {
                ++tapCount;
                Intent aboutIntent=new Intent(MainActivity.this,video_java.class);
                Cursor resultset=db.rawQuery("SELECT * FROM locked",null);
                resultset.moveToFirst();
                String dbPassword=resultset.getString(0);
                String password= Arrays.toString(count);

                if(password.equals(dbPassword)) {
                    Toast.makeText(MainActivity.this, "Success....", Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < 9; i++)
                        count[i] = 0;
                    tapCount=0;
                    startActivity(new Intent(MainActivity.this,Unlocked.class));
                }
                else {
                    if (tapCount == 1)
                        attempt = "android.resource://" + getPackageName() + "/" + R.raw.attempt1;
                    else if (tapCount == 2)
                        attempt = "android.resource://" + getPackageName() + "/" + R.raw.attempt2;
                    else
                        attempt = "android.resource://" + getPackageName() + "/" + R.raw.attempt3;

                    for (int i = 0; i < 9; i++)
                        count[i] = 0;

                    aboutIntent.putExtra("video", attempt);
                    startActivity(aboutIntent);
                }
            }
        });


    }


}
