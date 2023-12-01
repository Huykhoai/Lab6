package minhnqph38692.fpoly.lab6.Bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import minhnqph38692.fpoly.lab6.R;

public class Bai2 extends AppCompatActivity {
    Button start,stop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai2.this, ForegroundService.class);
                startService(intent);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai2.this, ForegroundService.class);
                stopService(intent);
            }
        });
    }
}