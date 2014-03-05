package com.example.android_todo.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


//Adding extra stuff and buttons
import android.view.Menu;
import android.view.MenuItem;
import android.view.ContextMenu;
import android.widget.AdapterView;


public class ToDoList extends ActionBarActivity {

    static final private int ADD_NEW_TODO = Menu.FIRST;
    static final private int REMOVE_TODO = Menu.FIRST + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        ListView myListView = (ListView) findViewById(R.id.myListView);
        final EditText myEditText = (EditText) findViewById(R.id.myEditText);

        final ArrayList<String> todoItems = new ArrayList<String>();
        final ArrayAdapter<String> aa;
        //We add our item with our created layout "todolist_item"
        int resID = R.layout.todolist_item;
        aa = new ArrayAdapter<String>(this, resID, todoItems);
        myListView.setAdapter(aa);

        myEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN){
                    if(keyCode == KeyEvent.KEYCODE_ENTER){
                        todoItems.add(0, myEditText.getText().toString());
                        aa.notifyDataSetChanged();
                        myEditText.setText("");
                        return true;
                    }
                }
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuItem itemAdd = menu.add(0, ADD_NEW_TODO, Menu.NONE, R.string.add_new);
        MenuItem itemRem = menu.add(0, REMOVE_TODO, Menu.NONE, R.string.remove);

        //Assign icons
        itemAdd.setIcon(R.drawable.add);
        itemRem.setIcon(R.drawable.delete);

        //Allocate shortcuts to each of them
        itemAdd.setShortcut('0', 'a');
        itemRem.setShortcut('1', 'r');

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
