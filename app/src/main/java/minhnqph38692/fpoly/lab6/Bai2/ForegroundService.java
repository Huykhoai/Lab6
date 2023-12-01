package minhnqph38692.fpoly.lab6.Bai2;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import minhnqph38692.fpoly.lab6.ConfigNotification;
import minhnqph38692.fpoly.lab6.R;

public class ForegroundService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service đang chạy", Toast.LENGTH_SHORT).show();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, ConfigNotification.CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_delete)
                .setContentTitle("Service đang chạy")
                .setContentText("Bạn không thể tắt notifycation bằng cách lướt nó")
                .setColor(Color.RED);

        Notification notification =(Notification) builder.build();
        startForeground(1,notification);




        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Destroy Service", Toast.LENGTH_SHORT).show();
    }
}
