package com.example.proteintracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.mainActivityTextView);
        textView.setText(R.string.test_untuk_update_view);

        Button helpBtn = (Button) findViewById(R.id.helpButton);
        helpBtn.setOnClickListener(helpButtonListener);

        Button layoutBtn = (Button) findViewById(R.id.buttonLayout);
        layoutBtn.setOnClickListener(buttonLayoutListener);

        Button fragment = (Button) findViewById(R.id.fragment);
        fragment.setOnClickListener(fragmentButtonListener);

        Button relativeBtn = (Button) findViewById(R.id.relativeButton);
        relativeBtn.setOnClickListener(relativeButtonListener);

        Button tableBtn = (Button) findViewById(R.id.tableButton);
        tableBtn.setOnClickListener(tableButtonListener);

        Button proteinBtn = (Button) findViewById(R.id.proteinButton);
        proteinBtn.setOnClickListener(proteinButtonListener);

        Button mhsFragmentBtn = (Button) findViewById(R.id.btnFragmenMhs);
        mhsFragmentBtn.setOnClickListener(mhsFragmentButtonListener);

        Button btnList = (Button) findViewById(R.id.buttonList);
        btnList.setOnClickListener(btnListButtonListener);

        Button kelolaMhsBtn = (Button) findViewById(R.id.btnKelolaMhs);
        kelolaMhsBtn.setOnClickListener(kelolaMhsButtonListeners);

        if (savedInstanceState != null) {
            Log.d("ProteinTracker", savedInstanceState.getString("abc"));
        }

//        lv.setAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,items));
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            Toast.makeText(MainActivity.this,"Anda memilih " + items[position], Toast.LENGTH_SHORT).show();}
    }

    private View.OnClickListener myBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText myEditText = (EditText) findViewById(R.id.editText1);
            Log.d("Proteintracker", myEditText.getText().toString());
        }
    };

    private View.OnClickListener helpButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, HelpActivity.class);
            Bundle b = new Bundle();
            EditText myEditText = (EditText) findViewById(R.id.editText1);
            b.putString("helpString", myEditText.getText().toString());
            intent.putExtras(b);
            startActivity(intent);
        }
    };

    private View.OnClickListener fragmentButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, Main3FragmentActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener relativeButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, Text.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener tableButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, Table.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener mhsFragmentButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, MahasiswaActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener buttonLayoutListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, Test.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener proteinButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, ProteinTrackerApp.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener btnListButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, ProteinTrackerApp.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener kelolaMhsButtonListeners = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, KelolaMhsActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("abc", "test");
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(getApplicationContext(), "Item 1 Terpilih", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(), "Item 1 Terpilih", Toast.LENGTH_LONG).show();
                return true;
//            case R.id.item3:
//                Toast.makeText(getApplicationContext(), "Item 1 Terpilih", Toast.LENGTH_LONG).show();
//                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}