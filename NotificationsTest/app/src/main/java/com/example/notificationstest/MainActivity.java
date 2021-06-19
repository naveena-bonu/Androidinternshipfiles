package com.example.notificationstest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NotificationManager manager;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {//above 8. versions only it will be available
            //here we are giving a condition
            // Create a NotificationChannel
            // Create a NotificationChannel
            // Create a NotificationChannel
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID,
                    "Mascot Notification", NotificationManager
                    .IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification from Mascot");
            manager.createNotificationChannel(notificationChannel);
        }

    }

    public void submit(View view) {
        NotificationCompat.Builder builder= new NotificationCompat.Builder(this,PRIMARY_CHANNEL_ID);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Navs first notification");
        builder.setContentText("New messages from instagram");//created the notification design
        // now when we click the button we need to display this message
        //system services are there to connect our app with this notifications service.
        //to display this notification we need to access the notification service


        //*to do event handling
        Intent i= new Intent(this,MainActivity.class);
        PendingIntent pi= PendingIntent.getActivity(this,25,i,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);//here when we click button notification appears when we click on notification this app again appears like event handling
        builder.setAutoCancel(true);//notification dissapears after clicking on notification
        builder.addAction(R.mipmap.ic_launcher,"Reply",pi);//reply button for notification here also our main app appears.
        Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.screenshot);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(b));


  //big picture style-- in whatsapp in notification only we can see image content
        //big text stylee---complete text can be used.


    }
}