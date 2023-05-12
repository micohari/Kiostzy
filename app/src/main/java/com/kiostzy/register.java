package com.kiostzy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class register extends AppCompatActivity {

    private EditText nama, alamat, username, password, repassword;
    private ProgressDialog progressDialog;
    Button signup;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nama = (EditText) findViewById(R.id.nama);
        alamat = (EditText)findViewById(R.id.alamat);
        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.txtsignup);
        TextView signin = (TextView) findViewById(R.id.txtlogin);
        progressDialog = new ProgressDialog(register.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Silahkan Tunggu");
        progressDialog.setCancelable(false);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


        signup.setOnClickListener(view -> {
            if (nama.getText().length()>0 && alamat.getText().length()>0 && username.getText().length()>0 && password.getText().length()>0 && repassword.getText().length()>0){
                if (password.getText().toString().equals(repassword.getText().toString())){
                    register(nama.getText().toString(),alamat.getText().toString(), username.getText().toString(), password.getText().toString());
                }else {
                    Toast.makeText(getApplicationContext(),"silahkan masukan password yang sama", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(getApplicationContext(),"silahkan isi semua data", Toast.LENGTH_SHORT).show();
            }
        });


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });
    }
    private void register (String nama,String alamat, String username, String password){
        progressDialog.show();;
        mAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful() && task.getResult()!=null){
                    FirebaseUser firebaseUser = task.getResult().getUser();
                    if (firebaseUser!=null) {
                        UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                                .setDisplayName(nama)
                                .build();
                        firebaseUser.updateProfile(request).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                reload();
                            }
                        });
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Register Gagal", Toast.LENGTH_SHORT).show();
                    }


                }else{
                    Toast.makeText(getApplicationContext(),task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }
        });
    }

    private void reload(){
        startActivity(new Intent(getApplicationContext(), home.class));
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }
}