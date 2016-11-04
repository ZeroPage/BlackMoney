package com.example.zpadmin.blackmoney;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecieveActivity extends AppCompatActivity {
    private ListView listView;
    private List<Item> list = new ArrayList<Item>();
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve);
        listView = (ListView) findViewById(R.id.mList);

        mAdapter = new MyAdapter(this, list);

        listView.setAdapter(mAdapter);

        Button.OnClickListener mClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.removeButton:
                        mAdapter.remove();
                        listView.setAdapter(mAdapter);
                        break;
                    case R.id.addButton:
                        mAdapter.addItem();
                        listView.setAdapter(mAdapter);
                        break;
                }
            }
        };

    }
    private class Item {
        public String name = "name";
        public String money = "money";
        public Item() {

        }
    }
    private class MyAdapter extends ArrayAdapter<Item> {

        private final static int resId = R.layout.input_recieve_listview_item;
        private Context context;
        List<Item> list;

        public MyAdapter(Context context, List<Item> list) {
            super(context, resId, list);
            this.context = context;
            this.list = list;
        }
        public void remove(){
            list.remove(list.size()-1);
        }

        public void addItem(){
            list.add(new Item());
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v = convertView;

            Item item = getItem(position);

            if (v == null) {

                v = getLayoutInflater().inflate(resId, null);
                EditText na = (EditText)v.findViewById(R.id.name);
                EditText mo = (EditText)v.findViewById(R.id.money);
            }


            return v;
        }
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

}
