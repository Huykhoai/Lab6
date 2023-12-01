package minhnqph38692.fpoly.lab6;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Date;

public class ConfigNotification extends Application {
    public static final String CHANNEL_ID = "FPTPOLYTECHNIC";

    @Override
    public void onCreate() {
        super.onCreate();
        config();
    }
    void config(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //Tên của Notification Channel cần đăng ký
            CharSequence name = "Minh";
            //Mô tả của Notification Channel
            String mota = " mo ta";
            //Độ ưu tiên của Notification
            int do_uu_tien = NotificationManager.IMPORTANCE_DEFAULT;
            //Sử dụng RingtoneManager để lấy uri của âm thanh Notification theo máy
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
            //Tạo thêm một audioAttributes
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,name,do_uu_tien);
            channel.setDescription(mota);
            channel.setSound(uri,audioAttributes);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }

    }
//    void notification(){
//        Bitmap logo = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,ConfigNotification.CHANNEL_ID)
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setContentTitle("Chào mừng đến với fpt Polytechnic")
//                .setContentText("Android 2")
//                .setStyle(new NotificationCompat.BigPictureStyle()
//                        .bigPicture(logo)
//                        .bigLargeIcon(null)
//                )
//                .setLargeIcon(logo)
//                .setColor(Color.RED)
//                .setAutoCancel(true);
//        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
//        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
//        == PackageManager.PERMISSION_GRANTED){
//            notificationManagerCompat.notify((int) new Date().getTime(), builder.build());
//
//        }else {
//            ActivityCompat.requestPermissions((Activity) ConfigNotification.this,
//                    new String[]{Manifest.permission.POST_NOTIFICATIONS}),7979;
//        }
//
//    }
}
