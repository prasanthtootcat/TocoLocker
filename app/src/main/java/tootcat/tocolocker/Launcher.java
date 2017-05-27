package tootcat.tocolocker;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import static java.sql.Types.NULL;

public class Launcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        SQLiteDatabase db=openOrCreateDatabase("lockerDB",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS locked(pass varchar);");

        final Cursor resultset=db.rawQuery("SELECT * FROM locked",null);

        Handler my_handler=new Handler();
        my_handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(resultset.getCount()>0)
                    startActivity(new Intent(Launcher.this, MainActivity.class));
                else
                    startActivity(new Intent(Launcher.this,Setup.class));

                Launcher.this.finish();
            }
        },2100);
    }
}
