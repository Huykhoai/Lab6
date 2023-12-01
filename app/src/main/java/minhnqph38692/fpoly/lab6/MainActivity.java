package minhnqph38692.fpoly.lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.TaskStackBuilder;

import android.Manifest;
import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

import minhnqph38692.fpoly.lab6.Bai2.Bai2;
import minhnqph38692.fpoly.lab6.Bai3.Bai3;
import minhnqph38692.fpoly.lab6.Bai4.Bai4;

public class MainActivity extends AppCompatActivity {


    Button send,bai2,bai3,bai4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send= findViewById(R.id.send);
        bai2 = findViewById(R.id.bai2);
        bai3 = findViewById(R.id.bai3);
        bai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bai3.class);
                startActivity(intent);
            }
        });
        bai4 = findViewById(R.id.bai4);
        bai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bai4.class);
                startActivity(intent);
            }
        });
        bai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Bai2.class);
                startActivity(intent);
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDemo = new Intent(getApplicationContext(),Tinnhantoi.class);
                intentDemo.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intentDemo.putExtra("dulieu","Dữ liệu gửi từ notify vào Activity");

                TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity.this);
                stackBuilder.addNextIntentWithParentStack(intentDemo);

                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT |
                                PendingIntent.FLAG_IMMUTABLE);

                Bitmap logo = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);

                Notification customNotification = new NotificationCompat.Builder(MainActivity.this,
                        ConfigNotification.CHANNEL_ID).setSmallIcon(android.R.drawable.ic_delete)
                        .setContentTitle("Chào mừng đến với fpt Polytechnic")
                        .setContentText("Android 2")
                        .setContentIntent(resultPendingIntent)
                        .setStyle(new NotificationCompat.BigPictureStyle()
                                .bigPicture(logo)
                                .bigLargeIcon(null)
                        )
                        .setLargeIcon(logo)
                        .setColor(Color.RED)
                        .setAutoCancel(true)
                        .build();

                NotificationManagerCompat notificationManagerCompat =
                        NotificationManagerCompat.from(MainActivity.this);

                if(ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.POST_NOTIFICATIONS) !=
                        PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions((Activity) MainActivity.this,
                            new String[] {Manifest.permission.POST_NOTIFICATIONS},9999) ;
                    return;
                }
                int id_notiy = (int) new Date().getTime();
                notificationManagerCompat.notify(id_notiy,customNotification);
            }
        });
    }
}