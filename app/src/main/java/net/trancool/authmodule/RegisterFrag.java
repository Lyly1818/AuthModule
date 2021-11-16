package net.trancool.authmodule;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import net.trancool.authmodule.databinding.FragmentRegisterBinding;

import java.util.Objects;

public class RegisterFrag extends Fragment {


    FragmentRegisterBinding binding;

    public RegisterFrag() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        final TextInputLayout pwLayout = binding.passwordTextInputLayout;

        final TextInputEditText pwEditText = binding.passwordEditText;

        final TextInputLayout emaiLayout = binding.userNameTil;
        final TextInputEditText usernameEditText = binding.userNameEd;

        final MaterialButton registerBtn = binding.btnRegister;
        final MaterialButton goToLogin = binding.btnCreateAccFromLogin;

        goToLogin.setOnClickListener(v -> goToLogin());
        registerBtn.setOnClickListener(v -> {
            isFormValid(usernameEditText, emaiLayout, pwEditText, pwLayout);
            AuthenticationRepository repository = new AuthenticationRepository();
            repository.signUpUser(usernameEditText.getText().toString(), pwEditText.getText().toString());
            Toast.makeText(getContext(), "It works!!!", Toast.LENGTH_SHORT).show();

        });

        return binding.getRoot();
    }


    private void goToLogin(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.auth_container, new LoginFrag());
        ft.commitNow();
    }

    //input validation
    private boolean isFormValid( TextInputEditText userEmail, TextInputLayout emailLayout, TextInputEditText userPassword, TextInputLayout pwLaout)
    {




        //final String username = Objects.requireNonNull(userName.getText()).toString().trim();
        final String email = Objects.requireNonNull(userEmail.getText()).toString().trim();
        final String password = Objects.requireNonNull(userPassword.getText()).toString().trim();




        if (email.isEmpty()){
            emailLayout.setError("Email is required");
            userEmail.requestFocus();
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailLayout.setError("Email is not correctly formated");
            userEmail.requestFocus();
            return false;
        }

        if (password.isEmpty()){
            pwLaout.setError("password is required");
            userPassword.requestFocus();
            return false;
        }


        if (password.length() < 8){
            pwLaout.setError("Password should be at least 8 characters");
            userPassword.requestFocus();
            return false;
        }

        //   userName.clearFocus();
        userEmail.clearFocus();
        userPassword.clearFocus();


        pwLaout.setError(null);
        emailLayout.setError(null);
        return  true;
    }

    public void displayError(String errorMessage,TextInputLayout...layouts ){
        layouts[0].setError("Hello");
    }



}