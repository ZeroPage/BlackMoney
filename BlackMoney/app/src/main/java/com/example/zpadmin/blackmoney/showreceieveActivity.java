package com.example.zpadmin.blackmoney;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class showreceieveActivity extends AppCompatActivity {
    private ListView mListView = null;
    private ListViewAdapter mAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showreceieve);

        mListView = (ListView) findViewById(R.id.mList);

        mAdapter = new ListViewAdapter(this);
        mListView.setAdapter(mAdapter);
        //mAdapter.addItem();
    }
    private class ViewHolder {
        public TextView name;

        public TextView money;
        public Button removeButton;
    }
    class tmp{
        public String name;
        public String money;
    }

    private class ListViewAdapter extends BaseAdapter {
        private Context mContext = null;
        private ArrayList<tmp> mListData = new ArrayList<tmp>();

        public ListViewAdapter(Context mContext) {
            super();
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return mListData.size();
        }

        @Override
        public Object getItem(int position) {
            return mListData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();

                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.recieve_listview_item, null);

                holder.name = (TextView) convertView.findViewById(R.id.name);
                holder.money = (TextView) convertView.findViewById(R.id.money);
                holder.removeButton = (Button) convertView.findViewById(R.id.removeButton);

                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }

            tmp mData = mListData.get(position);

            holder.name.setText(mData.name);
            holder.money.setText(mData.money);

            return convertView;
        }
        public void addItem( String name, String money){
            tmp addInfo = null;
            addInfo = new tmp();
            addInfo.name = name;
            addInfo.money = money;

            mListData.add(addInfo);
        }

        public void remove(int position){
            mListData.remove(position);
            dataChange();
        }

        public void dataChange(){
            mAdapter.notifyDataSetChanged();
        }
    }
}
