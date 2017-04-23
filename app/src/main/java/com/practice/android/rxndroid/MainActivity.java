package com.practice.android.rxndroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.practice.android.rxndroid.adapter.SampleAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int SIGNIN_REQUEST = 1001;
    public static final String MY_GLOBAL_PREFS = "my_global_prefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupActionBar();
        setupSampleList();
    }

    private void setupSampleList() {
        RecyclerView sampleList = (RecyclerView) findViewById(R.id.sample_list);
        sampleList.setHasFixedSize(true);
        sampleList.setLayoutManager(new LinearLayoutManager(this));
        sampleList.setAdapter(new SampleAdapter(this, getSampleList()));
    }

    private static List<SampleActivityWithName> getSampleList() {
        List<SampleActivityWithName> sampleActivityWithNames = new ArrayList<>();

        sampleActivityWithNames.add(new SampleActivityWithName(Sample1Activity.class, R.string.sample1_title));
        sampleActivityWithNames.add(new SampleActivityWithName(Sample2Activity.class, R.string.sample2_title));
        sampleActivityWithNames.add(new SampleActivityWithName(Sample3Activity.class, R.string.sample3_title));

        return sampleActivityWithNames;

    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setTitle(R.string.app_titile);
        }
    }

    // Create option menu - sign in
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Start Login activity on sign in option selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_signin:
                Intent loginIntent = new Intent(this, LoginActivity.class);
                startActivityForResult(loginIntent, SIGNIN_REQUEST);
                return true;
            case R.id.actions_settings:
                Intent settingsIntent = new Intent( this, PrefsActivity.class );
                startActivity( settingsIntent );
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );

        if (resultCode == RESULT_OK && requestCode == SIGNIN_REQUEST) {
            String email = data.getStringExtra( LoginActivity.EMAIL_KEY );
            Toast.makeText( this, "You signed in as " + email, Toast.LENGTH_SHORT ).show();

            SharedPreferences.Editor editor = getSharedPreferences( MY_GLOBAL_PREFS, MODE_PRIVATE ).edit();
            editor.putString( LoginActivity.EMAIL_KEY, email );
            editor.apply();

        }
    }
}
