package com.example.peterson.llamar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.peterson.llamar.Constantes.Constantes;
import com.example.peterson.llamar.Entidades.Llamar;

import java.util.ArrayList;

public class RegistroActivity extends AppCompatActivity {

    ListView listViewRegistros;

    ArrayList<String> listaInformacion;
    ArrayList<Llamar> listaLlamada;

    ConexionSQLiteHelper con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listViewRegistros = findViewById(R.id.listViewRegistro);


        con = new ConexionSQLiteHelper(this, "llamarBD", null, 1);

        consultarListaLlamadas();

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaInformacion);
        listViewRegistros.setAdapter(adaptador);
    }

    private void consultarListaLlamadas() {
        SQLiteDatabase db = con.getReadableDatabase();

        Llamar llamar = null;
        listaLlamada = new ArrayList<Llamar>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Constantes.TABLA_LLAMADAS +" ORDER BY " + Constantes.CAMPO_ID + " DESC", null);

        while (cursor.moveToNext()) {
            llamar = new Llamar();
            llamar.setId(cursor.getInt(0));
            llamar.setNumero(cursor.getString(1));

            listaLlamada.add(llamar);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion = new ArrayList<String>();

        for (int i = 0; i < listaLlamada.size(); i++) {
            listaInformacion.add(listaLlamada.get(i).getNumero());
        }
    }

}
