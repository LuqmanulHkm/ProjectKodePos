package com.example.projectkodepos;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class f_profil extends Fragment {

    private Button btn_logout;
    private TextView tf_username;
    SharedPreferences pref;

    public f_profil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_f_profil, container, false);
        return view;
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_logout = view.findViewById(R.id.logout);
        tf_username = view.findViewById(R.id.uname);

        pref = getActivity().getApplicationContext().getSharedPreferences("Save save an", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();


        String p_user = pref.getString("user","");
        tf_username.setText(p_user);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p_autofill = pref.getString("autofill","False");

                if(p_autofill.equals("True")){
                    editor.putString("autolog", "False");
                    editor.commit();
                    startActivity(new Intent(getActivity(), MainActivity.class));
                    getActivity().finish();

                }else{
                    editor.putString("autolog", "False");
                    editor.commit();

                    editor.putString("user", "");
                    editor.commit();

                    editor.putString("pass", "");
                    editor.commit();
                    startActivity(new Intent(getActivity(), MainActivity.class));
                    getActivity().finish();
                }
            }
        });
    }

}
