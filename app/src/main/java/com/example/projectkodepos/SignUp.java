package com.example.projectkodepos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    private EditText etnama,etuser,etpass,etpasshint;
    private Button btn_Signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btn_Signup = findViewById(R.id.btn_signup);
        etnama = findViewById(R.id.etNama);
        etuser = findViewById(R.id.etUser);
        etpass = findViewById(R.id.etPassword);
        etpasshint = findViewById(R.id.etPasswordHint);

        // TODO: Siapkan Shared Preference nya
        SharedPreferences pref = getApplicationContext().getSharedPreferences("Save save an", MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();
        btn_Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etnama.getText().toString().equals("")) {

                    // TODO: Ini digunakan untuk menyimpan suatu value ke "Kata Yang Disimpan"
                    editor.putString("user Yang Disimpan", etuser.getText().toString());
                    editor.putString("pass Yang Disimpan", etpass.getText().toString());
                    editor.putString("nama Yang Disimpan", etnama.getText().toString());
                    editor.putString("passhint Yang Disimpan", etpasshint.getText().toString());

                    // TODO: Tambahkan ini jika sudah tidak ada lagi yang dilakukan
                    editor.commit();

                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                    // * Untuk mengakhiri activity ini. agar saat tombol back dipencet, tidak kesini lagi
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Isi dulu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
