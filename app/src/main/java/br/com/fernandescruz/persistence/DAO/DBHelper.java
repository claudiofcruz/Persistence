package br.com.fernandescruz.persistence.DAO;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.fernandescruz.persistence.MinhaAplicacao;
import br.com.fernandescruz.persistence.model.Livro;

/**
 * Created by claudiocruz on 12/12/16.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static String NOME_BANCO = "livros.db";
    public static int  VERSAO_BANCO =  1;

    public DBHelper() {
        super(MinhaAplicacao.getContext(),
                NOME_BANCO,
                null,
                VERSAO_BANCO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LivroDAO.createTable());
        seed();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void seed(){
        LivroDAO dao = new LivroDAO();

        Livro android = new Livro();
        android.setAutor("Ricardo Lechetta");
        android.setEditora("Novatec");
        android.setTitulo("Google Android");

        dao.insereDado(android);

        Livro torreNegra = new Livro();
        torreNegra.setTitulo("A Torre Negra");
        torreNegra.setEditora("Achosuma");
        torreNegra.setAutor("Stephen King");

        dao.insereDado(torreNegra);

    }

}
