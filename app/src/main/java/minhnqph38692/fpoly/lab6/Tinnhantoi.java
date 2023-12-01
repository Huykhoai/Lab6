package minhnqph38692.fpoly.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Tinnhantoi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinnhantoi);
        String dulieu = getIntent().getStringExtra("dulieu");
        Toast.makeText(this, "Du lieu"+dulieu, Toast.LENGTH_SHORT).show();
    }
}