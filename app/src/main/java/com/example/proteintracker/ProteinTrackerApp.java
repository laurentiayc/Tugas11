package com.example.proteintracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProteinTrackerApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protein_tracker_app);
        Button btnSetting = (Button) findViewById(R.id.btnSetting);
        btnSetting.setOnClickListener(myBtnSettingClick);

        SharedPreferences prefs = ProteinTrackerApp.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
        String statusLogin = prefs.getString("isLogin",null); Button btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(myBtnLoginClick);
        if (statusLogin != null){
            btnLogin.setText("Logout");
        }else{
            btnLogin.setText("Login");
        }

        Button resetButton = (Button)findViewById(R.id.btnReset);
        resetButton.setOnClickListener(resetButtonListener);

        Button customButton = (Button)findViewById(R.id.btnDialogCustom);
        resetButton.setOnClickListener(customButtonListener);
    }

    private View.OnClickListener myBtnSettingClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ProteinTrackerApp.this, SettingsActivity.class);
            startActivity(intent);
        };
    };

    private View.OnClickListener myBtnLoginClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences prefs = ProteinTrackerApp.this.getSharedPreferences("prefs_file",MODE_PRIVATE);

            String statusLogin = prefs.getString("isLogin",null);
            SharedPreferences.Editor edit = prefs.edit();

        Button btnLogin = (Button)findViewById(R.id.btnLogin);
        if (statusLogin != null){
            edit.putString("isLogin",null);
            btnLogin.setText("Login");
        }else{
            edit.putString("isLogin","Admin");
            btnLogin.setText("Logout");
        }
        edit.commit();
        }
    };

    private View.OnClickListener customButtonListener = new View.OnClickListener() {
        public void onClick(View v) {
            final Dialog dialog = new Dialog(ProteinTrackerApp.this);
            dialog.setContentView(R.layout.custom_dialog);
            dialog.setTitle("Custom Dialog");

            Button btnDialog = (Button) dialog.findViewById(R.id.btnCustom);
            btnDialog.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
    };

    private View.OnClickListener resetButtonListener = new View.OnClickListener() {

        ProgressDialog progressDialog;
        private Handler handler = new Handler(){
            public void handleMessage(android.os.Message msg) {
                progressDialog.dismiss();
            }
        };

        @Override
        public void onClick(View view) {
            EditText myEditText = (EditText) findViewById(R.id.editText1);
            Log.d("Proteintracker", myEditText.getText().toString());

            AlertDialog.Builder builder = new AlertDialog.Builder(ProteinTrackerApp.this);
            builder.setMessage("Apakah anda yakin untuk mereset nilai protein?")
                    .setNegativeButton("No", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(ProteinTrackerApp.this, "Tidak jadi reset", Toast.LENGTH_SHORT).show();
                }
            })         .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(ProteinTrackerApp.this, "Melakukan RESET !!", Toast.LENGTH_SHORT).show();
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

            builder.setMessage("Apakah anda yakin untuk mereset nilai protein?")
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(ProteinTrackerApp.this, "Tidak jadi reset", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                           // Toast.makeText(ProteinTrackerApp.this, "Melakukan RESET !!", Toast.LENGTH_SHORT).show()
                            progressDialog = new ProgressDialog(ProteinTrackerApp.this);
                            progressDialog.setMessage("Melakukan sesuatu ...");
                            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

                            Thread thread = new Thread(new Runnable() {
                                public void run() {
                                    try {
                                        Thread.sleep(3000);
                                        handler.sendEmptyMessage(0);
                                    }
                                    catch (InterruptedException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                }
                            });
                            thread.start();
                            progressDialog.show();
                        }
                    });
            }
    };
}