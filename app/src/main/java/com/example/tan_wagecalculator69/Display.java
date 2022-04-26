package com.example.tan_wagecalculator69;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Display extends AppCompatActivity implements View.OnClickListener {


        TextView txtName;
        TextView txtType;
        TextView txtHours;
        TextView txtRegularWage;
        TextView txtTotalWage;
        TextView txtOTWage;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);


        txtName = findViewById(R.id.employeeName);
        txtType = findViewById(R.id.employeetype);
        txtHours = findViewById(R.id.hrResult);
        txtTotalWage = findViewById(R.id.twrResult);
        txtRegularWage =findViewById(R.id.trwResult);


         Button btnback = findViewById(R.id.btnBack);

        Intent i = getIntent();

        String EmployeeType = i.getStringExtra("type");
        String EmployeeName = i.getStringExtra("empName");
        Double EmployeeHours = Double.parseDouble(i.getStringExtra("hours"));

        txtName.setText("Employee Name: " + EmployeeName);
        txtType.setText("Employee Type: " + EmployeeType);
        txtHours.setText(String.valueOf(EmployeeHours));
        calcWage(EmployeeType, EmployeeHours, txtTotalWage, txtRegularWage, txtOTWage);



    }
    @SuppressLint("SetTextI18n")
    public void calcWage(String employeeType, Double employeeHours, TextView txtTotalWage, TextView txtRegularWage, TextView txtOTWage) {
        double totalWage = 0.0;
        double totalOTWage = 0.0;

        switch (employeeType) {
            case "Regular Employee":
                if (employeeHours > 8.0) { //If employee hours is more than 8 hours
                    employeeHours = employeeHours - 8;
                    totalWage = (employeeHours * 115) + 800;
                    totalOTWage = employeeHours * 115;

                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱800");
                    txtOTWage.setText("₱" + totalOTWage);
                } else { //If employee hours is less than or equal to 8 hours
                    totalWage = employeeHours * 100;
                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱" + totalWage);
                }
                break;
            case "Part-Time Worker":
                if (employeeHours > 8.0) { //If employee hours is more than 8 hours
                    employeeHours = employeeHours - 8;
                    totalWage = (employeeHours * 90) + 600;
                    totalOTWage = employeeHours * 90;

                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱600");
                    txtOTWage.setText("₱" + totalOTWage);
                } else { //If employee hours is less than or equal to 8 hours
                    totalWage = employeeHours * 75;
                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱" + totalWage);
                }
                break;
            case "Probationary Employee":
                if (employeeHours > 8.0) { //If employee hours is more than 8 hours
                    employeeHours = employeeHours - 8;
                    totalWage = (employeeHours * 100) + 720;
                    totalOTWage = employeeHours * 100;

                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱720");
                    txtOTWage.setText("₱" + totalOTWage);
                } else { //If employee hours is less than or equal to 8 hours
                    totalWage = employeeHours * 90;
                    txtTotalWage.setText("₱" + totalWage);
                    txtRegularWage.setText("₱" + totalWage);
                }
                break;
        }
    }







    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnBack) { //Return To Main Activity
            startActivity(new Intent(Display.this, MainActivity.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }
}







