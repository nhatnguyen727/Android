package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkbox1, checkbox2;
    RadioGroup radioGroup;

    Button pay, next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example1);
        init();
    }

    void init(){
        // Init for radio group
        radioGroup = findViewById(R.id.radiogroup1);
        radioGroup.setOnCheckedChangeListener(radioGroupEvent);

        checkbox1 = findViewById(R.id.checkbox1);
        checkbox2 = findViewById(R.id.checkbox2);
        checkbox1.setOnCheckedChangeListener(checkboxEvent);
        checkbox2.setOnCheckedChangeListener(checkboxEvent);

        pay = findViewById(R.id.button1);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Coffee
                String coffee = "";

                // Get value of radio
                int id = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(id);

                coffee += "coffee: " + radioButton.getText() + " Vị: ";

                // Get value of checkbox
                if (checkbox1.isChecked()) {
                    coffee += checkbox1.getText() + ",";
                }

                if (checkbox2.isChecked()) {
                    coffee += checkbox2.getText();
                }

                // Notification
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage(coffee);
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });

        // Event when click on next button
        next = findViewById(R.id.button2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create new intent
                Intent intent = new Intent(MainActivity.this, EngVoca.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Event when checkbox change
     */
    CompoundButton.OnCheckedChangeListener checkboxEvent = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//            if(buttonView.getId() == R.id.checkbox2 ){
//                if(isChecked){
//                    checkbox1.setChecked(false);
//                    checkbox2.setChecked(false);
//
//                    checkbox1.setEnabled(false);
//                    checkbox2.setEnabled(false);
//                }else{
//                    checkbox1.setEnabled(true);
//                    checkbox2.setEnabled(true);
//
//                }
//            }
//            if(isChecked){
//                Toast.makeText(MainActivity.this , "Bạn vừa chọn " + buttonView.getText().toString(), Toast.LENGTH_SHORT);
//            }
        }
    };

    /**
     * Event when user change radio
     */
    RadioGroup.OnCheckedChangeListener radioGroupEvent = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

        }
    };
}

