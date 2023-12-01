package minhnqph38692.fpoly.lab6.Bai4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import minhnqph38692.fpoly.lab6.R;

public class Bai4 extends AppCompatActivity {
    Button bai4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);

                Constraints constraints = new Constraints.Builder()
                        .setRequiresCharging(true).build();
                WorkRequest myRequest = new OneTimeWorkRequest.Builder(MyWorker.class)
                        .setConstraints(constraints).build();

                WorkManager.getInstance(Bai4.this).enqueue(myRequest);



    }
}