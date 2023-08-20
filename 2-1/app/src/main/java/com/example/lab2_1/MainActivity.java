package com.example.lab2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private View layoutLogin;
    private View layoutInfo;
    private View layoutGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutLogin = (LinearLayout)findViewById(R.id.layout_login);
        layoutInfo = (LinearLayout)findViewById(R.id.layout_info);
        layoutGrade = (LinearLayout)findViewById(R.id.layout_grade);

        Button loginBtn = (Button)findViewById(R.id.login_btn);
        Button infoBtn = (Button)findViewById(R.id.info_btn);
        Button gradeBtn = (Button)findViewById(R.id.grade_btn);

        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                layoutLogin.setVisibility(View.VISIBLE);
                layoutInfo.setVisibility(View.INVISIBLE);
                layoutGrade.setVisibility(View.INVISIBLE);
            }
        });
        infoBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                layoutLogin.setVisibility(View.INVISIBLE);
                layoutInfo.setVisibility(View.VISIBLE);
                layoutGrade.setVisibility(View.INVISIBLE);
            }
        });
        gradeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                layoutLogin.setVisibility(View.INVISIBLE);
                layoutInfo.setVisibility(View.INVISIBLE);
                layoutGrade.setVisibility(View.VISIBLE);
            }
        });
    }
}