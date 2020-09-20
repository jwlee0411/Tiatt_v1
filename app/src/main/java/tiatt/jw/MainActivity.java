package tiatt.jw;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

import tiatt.jw.ui.slideshow.SlideshowFragment;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_slideshow, R.id.nav_tools, R.id.nav_setting, R.id.nav_quiz02, R.id.nav_wordmix).setDrawerLayout(drawer).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        Intent intent = new Intent(getApplicationContext(), MyService.class);
        startService(intent);





    }





    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        // 번역알림

/*
        String CHANNEL_ID = "channel1";
        String CHANEL_NAME = "Channel1";

        NotificationCompat.Builder builder = null;
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.createNotificationChannel(
                new NotificationChannel(CHANNEL_ID, CHANEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
        );

        builder = new NotificationCompat.Builder(this,CHANNEL_ID);

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 101, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentTitle("알림");
        builder.setContentText("알림 메시지");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);
        Notification notification = builder.build();
        manager.notify(1,notification);

*/


        /*
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, new Intent(getApplicationContext(), MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this).setSmallIcon(R.drawable.icon_01).setContentTitle("알림 제목")
                .setContentText("알림 내용").setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.attlogo3))
                .setDefaults(Notification.DEFAULT_VIBRATE).setPriority(NotificationCompat.PRIORITY_DEFAULT).setAutoCancel(true).setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());
        System.out.println("메인알림");




         */





        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}
