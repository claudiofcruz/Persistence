package br.com.fernandescruz.persistence;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

import br.com.fernandescruz.persistence.DAO.DBHelper;
import br.com.fernandescruz.persistence.DAO.DatabaseManager;
import br.com.fernandescruz.persistence.DAO.LivroDAO;

/**
 * Created by claudiocruz on 12/12/16.
 */

//Utilizado no Stetho para fazer debug do banco, preferences, etc
public class MinhaAplicacao extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);

        this.context = getApplicationContext();

        //Inicializa a base de dados
        DatabaseManager.initializeInstance(new DBHelper());
    }

    //Criado para uso do DBHElper (Sqlite)
    public static Context getContext(){
        return context;
    }
}
