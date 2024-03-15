package com.example.ejercicio23_fotografia;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ejercicio23_fotografia.configuracion.AdaptadorLista;
import com.example.ejercicio23_fotografia.configuracion.Foto;
import com.example.ejercicio23_fotografia.configuracion.SQLiteConexion;

import java.util.ArrayList;
import java.util.List;

public class ActividadLista extends AppCompatActivity {

    ListView listView;
    List<Foto> mData = new ArrayList<>();
    AdaptadorLista mAdapter;
    SQLiteConexion conexion;

    Button btnregresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        conexion = new SQLiteConexion(this, null);

        listView = (ListView) findViewById(R.id.listView);
        obtenerTabla();
        mAdapter = new AdaptadorLista(ActividadLista.this,mData);
        listView.setAdapter(mAdapter);
        btnregresar = (Button) findViewById(R.id.btnListaFotografias);


        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }



    private void obtenerTabla() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        mData.clear(); // Limpiar la lista antes de agregar nuevos elementos
        Cursor cursor = db.rawQuery(SQLiteConexion.SelectTablePhotos, null);

        //Recorremos el cursor
        while (cursor.moveToNext()) {
            Foto photograh = new Foto();
            photograh.setId(cursor.getString(0));
            photograh.setDescription(cursor.getString(2));
            mData.add(photograh);

            // Agregar logs para verificar los valores obtenidos
            Log.d("ListActivity", "ID: " + cursor.getString(0));
            Log.d("ListActivity", "Description: " + cursor.getString(2));
        }

        cursor.close(); // Cerrar el cursor después de usarlo

        // Notificar al adaptador que los datos han cambiado
        if (mAdapter != null) {
            mAdapter.notifyDataSetChanged();
        }
    }
}