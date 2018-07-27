package com.example.abooody.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText emailEditText;
    EditText passEditText;
    EditText againEditText;
    EditText mobEditText;
    TextView continueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = (EditText) findViewById(R.id.email);
        passEditText = (EditText) findViewById(R.id.pass);
        againEditText = (EditText) findViewById(R.id.again);
        mobEditText = (EditText) findViewById(R.id.mob);

        continueTextView = (TextView) findViewById(R.id.cont);
        continueTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailEditText.getText().toString();
                if (!validateEmail(email)) return;

                String pass = passEditText.getText().toString();
                String again = againEditText.getText().toString();
                if (!passValidate(pass, again)) return;

                String mob = mobEditText.getText().toString();
                if (!checkNotNull(mob, "The mobile number field is empty!")) return;

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("email", email);
                intent.putExtra("pass", pass);
                intent.putExtra("mob", mob);
                startActivity(intent);
                finish();
            }
        });

    }

    private boolean checkNotNull(String string, String message) {
        if (!(string.length() > 0)) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean passValidate(String pass, String again) {
        if (!checkNotNull(pass, "The Password field is empty!"))
            return false;

        else if (!checkNotNull(again, "The second password field is empty!"))
            return false;

        else if (!pass.equals(again)) {
            Toast.makeText(MainActivity.this, "password does not match!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean validateEmail(String email) {
        if (!checkNotNull(email, "The Email field is empty!"))
            return false;
        else if (!(email.contains("@") && email.contains(".") && email.length() > 5)) {
            Toast.makeText(this, "Email not Validate!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }


}
