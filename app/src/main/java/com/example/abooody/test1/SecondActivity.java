package com.example.abooody.test1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView emailView, passView, mobView, github_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        emailView = (TextView) findViewById(R.id.email_view);
        passView = (TextView) findViewById(R.id.pass_view);
        mobView = (TextView) findViewById(R.id.mob_view);
        github_view = (TextView)findViewById(R.id.github_view);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String email = extras.getString("email");
            String pass = extras.getString("pass");
            String mob = extras.getString("mob");

            emailView.setText(email);
            passView.setText(pass);
            mobView.setText(mob);

        }

        github_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://Github.com/Abdulwahab95"));
                startActivity(browserIntent);
            }
        });
    }
}
