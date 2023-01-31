package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadProfile();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveProfile();
    }

    public void loadProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);

        TextView nameView = findViewById(R.id.name_textview);
        TextView statusView = findViewById(R.id.status_textview);
        nameView.setText(preferences.getString("name", ""));
        statusView.setText(preferences.getString("status", ""));
    }

    public void saveProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        TextView nameView = findViewById(R.id.name_textview);
        editor.putString("name", nameView.getText().toString());

        TextView statusView = findViewById(R.id.status_textview);
        editor.putString("status", statusView.getText().toString());

        editor.apply();
    }


    public void onExitClicked(View view) {
        finish();
    }
}