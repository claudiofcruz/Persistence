package br.com.fernandescruz.persistence;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkConnected();
    }


    public void efetuarLogin(View v){

        String usuario = ((EditText)findViewById(R.id.etUsuario)).getText().toString();
        String senha = ((EditText)findViewById(R.id.etPassword)).getText().toString();

        CheckBox cbManterConectado = (CheckBox)findViewById(R.id.cbKeepConnected);

        if(usuario.equals("admin") && senha.equals("123")){
                salvarPreferencias(usuario,
                        cbManterConectado.isChecked());
            abrirTela();
        }
    }
    
    private void checkConnected(){
        SharedPreferences sp = getSharedPreferences("PREFERENCIAS", 
                MODE_PRIVATE);
        if(sp.getBoolean("manterConectado", false)){
            abrirTela();
        }
        
    }

    private void abrirTela() {
        //Abrir um nova activity
        startActivity(new Intent(this, LivrosActivity.class));
        finish();
    }

    private void salvarPreferencias(String usuario, boolean conectado) {
        SharedPreferences sp =
                getSharedPreferences("PREFERENCIAS",
                        MODE_PRIVATE);

        SharedPreferences.Editor editor = sp.edit();
        editor.putString("usuario", usuario);
        editor.putBoolean("manterConectado", conectado);
        editor.commit();
    }


}
