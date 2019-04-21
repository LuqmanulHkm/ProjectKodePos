package com.example.projectkodepos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences pref;
    int info=0;
    private SharedPreferences.Editor editor;
    private Button btn_Signup,btn_Login;
    private CheckBox autofill,autolog;
    RelativeLayout rellay1, rellay2;
    EditText et_user,et_pass;

    public final String[] d_user =
            {"admin", "luqman", "gio"};
    public final String[] d_pass =
            {"12345", "12345", "12345"};


    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rellay1 = findViewById(R.id.rellay1);
        rellay2 = findViewById(R.id.rellay2);


        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash

        btn_Login = findViewById(R.id.btn_login);
        btn_Signup = findViewById(R.id.btn_signup);
        autofill = findViewById(R.id.checklogin);
        autolog = findViewById(R.id.autologin);
        et_user = findViewById(R.id.et_user);
        et_pass = findViewById(R.id.et_pass);
        pref = getApplicationContext().getSharedPreferences("Save save an", Context.MODE_PRIVATE);
        editor = pref.edit();

            CheckLoginPref();
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_user = et_user.getText().toString();
                String s_pass = et_pass.getText().toString();
                info=0;
                for (int i=0;i<=2;i++){
                    if(s_user.equals(d_user[i])){
                        info=2;
                    }
                    for (int j=0;j<=2;j++){
                    if(s_user.equals(d_user[i]) && s_pass.equals(d_pass[j])){
                        if (autolog.isChecked()){
                            editor.putString("autolog","True");
                            editor.commit();

                            String user = et_user.getText().toString();
                            editor.putString("user", user);
                            editor.commit();

                            String pass = et_pass.getText().toString();
                            editor.putString("pass", pass);
                            editor.commit();
                        }
                        if (autofill.isChecked()){
                            editor.putString("autofill", "True");
                            editor.commit();

                            String user = et_user.getText().toString();
                            editor.putString("user", user);
                            editor.commit();

                            String pass = et_pass.getText().toString();
                            editor.putString("pass", pass);
                            editor.commit();

                        }else{
                            editor.putString("autofill", "False");
                            editor.commit();

                            editor.putString("user", "");
                            editor.commit();

                            editor.putString("pass", "");
                            editor.commit();
                        }
                        info=1;
                        startActivity(new Intent(getApplicationContext(), Main_PosID.class));
                        finish();
                    }else{
                        if(info!=2 && info!=1){
                            info=0;
                        }
                    }
                    }
                }
                if(info==0){
                    Toast.makeText(MainActivity.this, "Username Tidak Terdaftar", Toast.LENGTH_SHORT).show();
                }else if(info==2){
                    Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                }

            }
        });


        btn_Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUp.class));
            }
        });



    }

    private void CheckLoginPref(){
        String p_autofill = pref.getString("autofill","False");
        String p_user = pref.getString("user","");
        String p_pass = pref.getString("pass","");
        String p_autolog = pref.getString("autolog","False");

        et_user.setText(p_user);
        et_pass.setText(p_pass);

        if(p_autofill.equals("True")){
            autofill.setChecked(true);
        }else{
            autofill.setChecked(false);
        }
        if (p_autolog.equals("True")){
            startActivity(new Intent(getApplicationContext(), Main_PosID.class));
            finish();
        }

    }
}
