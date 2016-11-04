package com.example.zpadmin.blackmoney;

import android.content.Intent;
import android.content.IntentSender;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ReceiveFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_form);
        final Intent sendIntent = new Intent(this, MainActivity.class);

        Button.OnClickListener addClickListener = new View.OnClickListener(){
            String subject, memo, Names, PaidMoney;
            public void onClick(View v) {
                EditText sub = (EditText) findViewById(R.id.subject);
                EditText mem = (EditText) findViewById(R.id.memo);
                EditText name = (EditText) findViewById(R.id.names);
                EditText pai = (EditText) findViewById(R.id.paidmoney);

                subject = sub.getContext().toString();
                memo = mem.getContext().toString();
                Names = name.getContext().toString();
                PaidMoney = pai.getContext().toString();
                if (subject.length() * memo.length() * Names.length() * PaidMoney.length() == 0) {
                    return;
                }

                sendIntent.putExtra("sub",subject);
                sendIntent.putExtra("memo",memo);
                sendIntent.putExtra("name",Names);
                sendIntent.putExtra("paid",PaidMoney);

                startActivity(sendIntent);
            }
        };
    }
}
