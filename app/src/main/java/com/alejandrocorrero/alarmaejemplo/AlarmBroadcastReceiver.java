package com.alejandrocorrero.alarmaejemplo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v4.app.NotificationCompat;


public class AlarmBroadcastReceiver extends BroadcastReceiver {

    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    private static final int NC_WARNING = 1;
    private static final int RC_WARNING = 1;

    @Override
    public void onReceive(Context context, Intent intent) {
        showNotification(context, intent);
    }

    private void showNotification(Context context, Intent intent) {
        NotificationCompat.Builder b = new NotificationCompat.Builder(context,
               "MAIN_CHANNEL_ID");
        b.setContentTitle("test");
        b.setSmallIcon(R.drawable.ic_launcher_background);
        b.setContentText(intent.getStringExtra(EXTRA_MESSAGE));
        b.setDefaults(Notification.DEFAULT_ALL);
        b.setTicker("test");
        b.setAutoCancel(true);
        Intent i = new Intent(context, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(context, RC_WARNING, i, 0);
        b.setContentIntent(pi);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(
                Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(NC_WARNING, b.build());
        }
    }

}