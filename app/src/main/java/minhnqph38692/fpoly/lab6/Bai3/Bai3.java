package minhnqph38692.fpoly.lab6.Bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import minhnqph38692.fpoly.lab6.R;

public class Bai3 extends AppCompatActivity {
    Button startbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        startbackground =findViewById(R.id.startbackground);
        startbackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai3.this,BackgroundServices.class);
                startService(intent);
            }
        });
    }
}