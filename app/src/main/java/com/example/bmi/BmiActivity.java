package com.example.bmi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class BmiActivity extends AppCompatActivity {

    Button btnResult;
    EditText edtName, edtWeight, edtHeight;
    RadioButton rdMale, rdFemale;
    String name;
    int weight;
    int height;
    float result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



        btnResult = findViewById(R.id.btn_result);

        edtName = findViewById(R.id.edt_name);
        edtHeight = findViewById(R.id.edt_height);
        edtWeight = findViewById(R.id.edt_weight);

        rdMale = findViewById(R.id.rd_male);
        rdFemale = findViewById(R.id.rd_female);

        rdMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleRadioButton(rdMale, rdFemale);
            }
        });
        rdFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleRadioButton(rdFemale,rdMale );
            }
        });


        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                name = edtName.getText().toString();

                String sWeight = edtWeight.getText().toString();

                String sHeight = edtHeight.getText().toString();

                if (TextUtils.isEmpty(sWeight) || TextUtils.isEmpty(sHeight) || TextUtils.isEmpty(name)) {

                    FancyToast.makeText(BmiActivity.this,
                            "لطفا اطلاعات خواسته شده را وارد کنید",
                            FancyToast.LENGTH_LONG,
                            FancyToast.ERROR,
                            true).show();


                } else {

                    weight = Integer.parseInt(edtWeight.getText().toString());
                    height = Integer.parseInt(edtHeight.getText().toString());

                    float heightM = (float) height / 100;

                    heightM = (float) Math.pow(heightM, 2);

                    result = weight / heightM;

                    int weightM = (int) (24 * heightM);
                    int properWeight = weight - weightM;
                    int pWeight = weightM - weight;


                    if (rdFemale.isChecked()) {

                        result = result - 1;
                        System.out.println(result);
                    }



                    if (result < 16.5) {

                        new SweetAlertDialog(BmiActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                .setTitleText(name + " عزیز ")
                                .setContentText(" شما کمبود وزن شدید داری حدود " + pWeight + " کیلو کمبود وزن دارید")
                                .setCustomImage(R.drawable.bm)
                                .show();

//                        txtResult.setText(name + " دوست عزیز شما کمبود وزن شدید داری حدود " + pWeight + " کیلو کمبود وزن دارید");

                    }
                    else if (result < 18.4 && result >= 16) {

                        new SweetAlertDialog(BmiActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                .setTitleText(name + " عزیز ")
                                .setContentText(" شما حدود " + pWeight + " کیلو کمبود وزن دارید")
                                .setCustomImage(R.drawable.bm)
                                .show();


                    } else if (result < 25 && result >= 18.4) {

                        new SweetAlertDialog(BmiActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                .setTitleText(name + " عزیز ")
                                .setContentText("  وزن و قدت باهم متناسبه ولی میتونه بهتر از این هم بشه ")
                                .setCustomImage(R.drawable.bm)
                                .show();


                }
                    else if (result < 30 && result >= 25) {

                        new SweetAlertDialog(BmiActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                .setTitleText(name + " عزیز ")
                                .setContentText( "  شما حدود " + properWeight + "کیلو اضافه وزن دارید")
                                .setCustomImage(R.drawable.bm)
                                .show();


                    } else if (result < 35 && result >= 30) {

                        new SweetAlertDialog(BmiActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                .setTitleText(name + " عزیز ")
                                .setContentText( "  شما دچار چاقی نوع 1 هستید و حدود " + properWeight + " کیلو اضافه وزن دارید")
                                .setCustomImage(R.drawable.bm)
                                .show();


                    } else if (result < 40 && result >= 35) {

                        new SweetAlertDialog(BmiActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                .setTitleText(name + " عزیز ")
                                .setContentText("  شما دچار چاقی نوع 2 هستید و حدود " + properWeight + " کیلو اضافه وزن دارید")
                                .setCustomImage(R.drawable.bm)
                                .show();


                    } else if (result > 40) {

                        new SweetAlertDialog(BmiActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                .setTitleText(name + " عزیز ")
                                .setContentText("  شما دچار چاقی نوع 3 هستید و حدود " + properWeight + " کیلو اضافه وزن دارید ")
                                .setCustomImage(R.drawable.bm)
                                .show();

                    }


                }
            }
        }
        );


    }
    private void toggleRadioButton(RadioButton radioButton1, RadioButton radioButton2) {
        if (!radioButton1.isChecked()) {
            radioButton1.setChecked(false);
            radioButton2.setChecked(true);
        } else {
            radioButton1.setChecked(true);
            radioButton2.setChecked(false);
        }
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
