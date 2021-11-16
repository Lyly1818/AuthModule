package net.trancool.authmodule;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import net.trancool.authmodule.databinding.FragmentLoginBinding;


public class LoginFrag extends Fragment {

   FragmentLoginBinding binding;


    public LoginFrag() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        final TextInputLayout pwLayout = binding.passwordTextInputLayout;

        final TextInputEditText pwEditText = binding.passwordEditText;

        final TextInputLayout emaiLayout = binding.userNameTil;
        final TextInputEditText usernameEditText = binding.userNameEd;

        final MaterialButton registerBtn = binding.btnRegister;
        final MaterialButton goToRegister = binding.btnCreateAccFromLogin;



        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRegister();
            }
        });
        return binding.getRoot();
    }

    private void goToRegister(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.auth_container, new RegisterFrag());
        ft.commitNow();
    }
}