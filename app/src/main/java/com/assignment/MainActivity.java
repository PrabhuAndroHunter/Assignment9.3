package com.assignment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.toString();
    private ListView mListView;
    //creating arrays for name and numbers
    public static String[] name = {"Prabhu", "Sadashiva", "Pramod", "Madana",
            "Usha", "Bhavana", "Siddalinga", "Latha"};
    public static String[] number = {"8923233445", "8392496748", "9692935783", "9153658749",
            "8214355667", "9734524667", "7421647386", "8192837465"};

    private static final int CONTEXT_MENU_CALL = 1;
    private static final int CONTEXT_MENU_SMS = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initialise layout
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        mListView = findViewById(R.id.listView); // init list view

        MyListAdapter adapter = new MyListAdapter(this, name, number);
        mListView.setAdapter(adapter);  // set adapter

        registerForContextMenu(mListView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select the Action");
        //here we are adding two different action in the menu
        menu.add(0, CONTEXT_MENU_CALL, 0, "Call");
        menu.add(0, CONTEXT_MENU_SMS, 1, "Send SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        try {
            // condition for call
            if (item.getItemId() == CONTEXT_MENU_CALL) {
                //here we are creating intent
                Intent i = new Intent();
                i.setAction(Intent.ACTION_DIAL);  // set intent action for call
                i.setData(Uri.parse("tel:" + number[info.position]));
                startActivity(i);
            }
            // condition for sms
            else if (item.getItemId() == CONTEXT_MENU_SMS) {
                //here we are creating intent
                Intent i = new Intent();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + number[info.position])));
                startActivity(i);
            } else {
                return false;
            }
            return true;
        } catch (Exception e) {//if false catch exception
            return true;
        }

    }
}
