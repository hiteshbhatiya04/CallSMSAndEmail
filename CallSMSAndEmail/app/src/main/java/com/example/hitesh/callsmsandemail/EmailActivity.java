package com.example.hitesh.callsmsandemail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity {

    EditText to,sub,txt;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);


        to = (EditText) findViewById(R.id.email_to);
        sub = (EditText) findViewById(R.id.email_subject);
        txt = (EditText) findViewById(R.id.email_text);
        send = (Button) findViewById(R.id.btn_sendemail);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String e_to = to.getText().toString();
                String e_subj = sub.getText().toString();
                String e_text = txt.getText().toString();


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ e_to});
                email.putExtra(Intent.EXTRA_SUBJECT, e_subj);
                email.putExtra(Intent.EXTRA_TEXT, e_text);
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

        }
        });
    }
}
