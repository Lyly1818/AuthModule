package net.trancool.authmodule;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthenticationRepository {




    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private User mUser;

     void signUpUser(String email, String password){

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        FirebaseUser user = mAuth.getCurrentUser();
                    }
                });


     }


    /*MutableLiveData<User> firebaseSignInWithGoogle(AuthCredential googleAuthCredential) {
        MutableLiveData<User> authenticatedUserMutableLiveData = new MutableLiveData<>();
        firebaseAuth.signInWithCredential(googleAuthCredential).addOnCompleteListener(authTask -> {
            if (authTask.isSuccessful()) {
                boolean isNewUser = authTask.getResult().getAdditionalUserInfo().isNewUser();
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {
                    String uid = firebaseUser.getUid();
                    String name = firebaseUser.getDisplayName();
                    String email = firebaseUser.getEmail();
                    User user = new User(uid, name, email);
                    user.isNew = isNewUser;
                    authenticatedUserMutableLiveData.setValue(user);
                }
            } else {
                logErrorMessage(authTask.getException().getMessage());
            }
        });
        return authenticatedUserMutableLiveData;
    }*/


   /* MutableLiveData<User> connectedUser(AuthCredential auth){

        MutableLiveData<User> connectedUserLiveData = new MutableLiveData<>();

        User user = new User();
        mAuth.createUserWithEmailAndPassword(user.email, user.password)
                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            boolean isNewUser = task.getResult().getAdditionalUserInfo().isNewUser();

                            FirebaseUser firebaseUser = mAuth.getCurrentUser();

                            //creating a new user user
                            if (firebaseUser != null){
                                user.uId= firebaseUser.getUid();//get the User ID from firebase
                                user.email = firebaseUser.getEmail();
                               connectedUserLiveData.setValue(user);

                            }
                        }
                        else {

                            task.getException().getMessage();
                        }

                    }
                });


        return connectedUserLiveData;
    }*/
}
