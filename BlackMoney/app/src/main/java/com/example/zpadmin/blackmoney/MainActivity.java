package com.example.zpadmin.blackmoney;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityIntent = new Intent(MainActivity.this, RecieveActivity.class);
                startActivity(activityIntent);
            }
        });
        ListView listView=(ListView)findViewById(R.id.mList);
        ArrayList<String> data=new ArrayList<>();
        data.add("aaaaa");
        ListviewAdapter adapter=new ListviewAdapter(this,R.layout.main_listview_item,data);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private class ViewHolder {

        public Button button;
    }

    public class ListviewAdapter extends ArrayAdapter<String> {
        private LayoutInflater inflater;

        public ListviewAdapter(Context context, int layout, ArrayList<String> data){
            super(context, layout,data);
            this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            View view = inflater.inflate(R.layout.main_listview_item, null , false);

            String listviewitem= getItem(position);
            Button button =(Button) view.findViewById(R.id.button);
            button.setText(listviewitem);
            return view;
        }
    }

}
