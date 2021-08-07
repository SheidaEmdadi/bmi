package com.example.bmi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    Button btnBmi, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnAbout = findViewById(R.id.btn_about);
        btnBmi = findViewById(R.id.btn_mbi);


        btnBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent bmi = new Intent(MainActivity.this, BmiActivity.class);
                startActivity(bmi);
            }
        });


        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                        .setTitleText("تهیه شده توسط: زینب امدادی")
                        .setContentText("لطفا اگر انتقاد یا پیشنهادی دارید باهام در میون بذارید *_*" +
                                "email: zeinabemdadi88@gmail.com")
                        .setCustomImage(R.drawable.love)
                        .show();
            }
        });


    }

    @Override
    public void onBackPressed() {

        exit_dialog();
    }


    public void exit_dialog() {

        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("واقعا میخوای بری؟")
                .setCancelText("نه نمیرم")
                .setConfirmText("بلی")
                .showCancelButton(true)
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        finish();
                    }
                })
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.cancel();
                    }
                }).show();


    }


}