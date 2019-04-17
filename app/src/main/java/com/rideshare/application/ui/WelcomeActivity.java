package com.rideshare.application.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.rideshare.application.R;
import com.rideshare.application.UserClient;
import com.rideshare.application.databinding.ActivityWelcomeBinding;
import com.rideshare.application.models.User;

public class WelcomeActivity extends AppCompatActivity {

    User user;
    public static final String TAG = "WelcomeActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ActivityWelcomeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);

    }

    public void handleDriver(View view)
    {
        user = ((UserClient)(getApplicationContext())).getUser();
        //user = new User();
        //user = new User("test@test.com","CHomuuA59kdKSXOclZdUlAEp4wP2","test","na","driver");


        user.setRole("driver");

        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

        finish();
    }

    public void handleTraveller(View view)
    {

        user = ((UserClient)(getApplicationContext())).getUser();
        //user = new User("test@test.com","CHomuuA59kdKSXOclZdUlAEp4wP2","test","na","traveller");


        try {
            user.setRole("traveller");
        }catch (NullPointerException e){
            Log.d(TAG,"Getting user once again...");
            user = ((UserClient)(getApplicationContext())).getUser();
        }
        user.setRole("traveller");


        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

        finish();
    }

}
