package com.mymusicplayer;

import android.app.ActivityManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Music> arrayList;
    private UrPatronPlayer adapter;
    private ListView songList;
    private Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClick = findViewById(R.id.button);

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification","mY name", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "My Notification");
                        builder.setContentTitle("UrPatron Notification");
                        builder.setContentText("Time is up!");
                        builder.setSmallIcon(R.drawable.notification_icon);
                        builder.setAutoCancel(true);

                        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                        managerCompat.notify(1,builder.build());
                    }
                }, 5000);
            }
        });


        File file = new File("LocalFilePath.txt");
        URI uri1 = file.toURI();

        songList = (ListView) findViewById(R.id.songList);
        arrayList = new ArrayList<>();
        arrayList.add(new Music("The Hills ", "The Weeknd",readFile(), R.raw.hills));
        arrayList.add(new Music("J'me tire ", "Maître Gims",readFile2(), R.raw.jme_tire));
        arrayList.add(new Music("La Même ","GIMS",readFile3(),R.raw.la_meme));
        arrayList.add(new Music("Love Is a Bitch ","Two Feet",readFile4(),R.raw.liab));
        arrayList.add(new Music("MONTERO ","Lil Nas X ",readFile5(),R.raw.montero));
        arrayList.add(new Music("Pump It ","The Black Eyed Peas ",readFile6(),R.raw.pump_it));
        arrayList.add(new Music("Unravel ","TK from Ling tosite sigure ",readFile7(),R.raw.unravel));
        arrayList.add(new Music("Techno Syndrome 2021 (MK) ","Benjamin Wallfisch ",readFile8(),R.raw.mkrem));


        adapter = new UrPatronPlayer(this, R.layout.custommusicitem, arrayList);
        songList.setAdapter(adapter);

    }

    private String readFile()
    {
        String myData = "";
        try {
            Resources res = getResources();
            InputStream is = res.openRawResource(R.raw.text1);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine + "\n";
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myData;
    }

    private String readFile2()
    {
        String myData = "";
        try {
            Resources res = getResources();
            InputStream is = res.openRawResource(R.raw.text2);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine + "\n";
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myData;
    }

    private String readFile3()
    {
        String myData = "";
        try {
            Resources res = getResources();
            InputStream is = res.openRawResource(R.raw.text3);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine + "\n";
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myData;
    }

    private String readFile4()
    {
        String myData = "";
        try {
            Resources res = getResources();
            InputStream is = res.openRawResource(R.raw.text4);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine + "\n";
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myData;
    }

    private String readFile5()
    {
        String myData = "";
        try {
            Resources res = getResources();
            InputStream is = res.openRawResource(R.raw.text5);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine + "\n";
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myData;
    }

    private String readFile6()
    {
        String myData = "";
        try {
            Resources res = getResources();
            InputStream is = res.openRawResource(R.raw.text6);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine + "\n";
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myData;
    }

    private String readFile7()
    {
        String myData = "";
        try {
            Resources res = getResources();
            InputStream is = res.openRawResource(R.raw.text7);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine + "\n";
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myData;
    }

    private String readFile8()
    {
        String myData = "";
        try {
            Resources res = getResources();
            InputStream is = res.openRawResource(R.raw.text8);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine + "\n";
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myData;
    }


    private boolean isAppRunning() {
        ActivityManager m = (ActivityManager) this.getSystemService( ACTIVITY_SERVICE );
        List<ActivityManager.RunningTaskInfo> runningTaskInfoList =  m.getRunningTasks(10);
        Iterator<ActivityManager.RunningTaskInfo> itr = runningTaskInfoList.iterator();
        int n=0;
        while(itr.hasNext()){
            n++;
            itr.next();
        }
        if(n==1){ // App is killed
            return false;
        }

        return true; // App is in background or foreground
    }



}

