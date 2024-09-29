package com.example.proyectochasqui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class MainActivity extends AppCompatActivity {

    EditText Txtemail, Txtpassword;
    Button btnregistrar, btnIniciar;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicializamos el objeto firebaseAuth
        firebaseAuth= FirebaseAuth.getInstance();
        Txtemail=(EditText)findViewById(R.id.TxtEmail);
        Txtpassword=(EditText)findViewById(R.id.TxtContraseña);
        btnregistrar=(Button)findViewById(R.id.BtnRegistrar);
        btnIniciar=(Button)findViewById(R.id.BtnIniciar);
        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistrarUsuario();
            }
        });
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InciarSesion();
            }
        });
    }

    private void RegistrarUsuario() {
        String email=Txtemail.getText().toString().trim();
        String pass=Txtpassword.getText().toString().trim();
        //Validamos que los EditText no es vacios
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Se debe ingresar un Email",
                    Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Falta ingresar contraseña",
                    Toast.LENGTH_LONG).show();
            return;
        }

//Creando a mi usuario
        firebaseAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new
                                               OnCompleteListener<AuthResult>() {
                                                   @Override
                                                   public void onComplete(@NonNull Task<AuthResult>
                                                                                  task) {
                                                       if(task.isSuccessful()){
                                                           Toast.makeText(MainActivity.this, "El Usuario se ha registrado Correctamente",
                                                                   Toast.LENGTH_LONG).show();
                                                       }else{
                                                           if(task.getException()instanceof
                                                                   FirebaseAuthUserCollisionException){
                                                               Toast.makeText(MainActivity.this, "El Usuario registrado ya Existe",
                                                                       Toast.LENGTH_LONG).show();
                                                           }
                                                           else {
                                                               Toast.makeText(MainActivity.this, "No se puede registrar al Usuario",
                                                                       Toast.LENGTH_LONG).show();
                                                           }
                                                       }
                                                   }
                                               });
    }

    private void InciarSesion() {
        String email=Txtemail.getText().toString().trim();
        String pass=Txtpassword.getText().toString().trim();
        //Validamos que los EditText no es vacios
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Se debe ingresar un Email",
                    Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Falta ingresar contraseña",
                    Toast.LENGTH_LONG).show();
            return;
        }
        //logearme (Inicio de Sesión)
        firebaseAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new
                                               OnCompleteListener<AuthResult>() {
                                                   @Override
                                                   public void onComplete(@NonNull Task<AuthResult>
                                                                                  task) {
                                                       if(task.isSuccessful()){
                                                           Toast.makeText(MainActivity.this,
                                                                   "Bienvenido: ",
                                                                   Toast.LENGTH_LONG).show();
                                                           Intent intent = new
                                                                   Intent(getApplicationContext(), AnunciosActivity.class);

                                                           intent.putExtra(AnunciosActivity.user,email);
                                                           startActivity(intent);
                                                       }else{
                                                           if(task.getException()instanceof
                                                                   FirebaseAuthUserCollisionException){
                                                               Toast.makeText(MainActivity.this, "El Usuario registrado ya Existe",
                                                                       Toast.LENGTH_LONG).show();
                                                           }
                                                           else {
                                                               Toast.makeText(MainActivity.this,
                                                                       "Error de Email o Contraseña " +
                                                                               "Incorrecta",
                                                                       Toast.LENGTH_LONG).show();
                                                           }
                                                       }
                                                   }
                                               });

    }
}
