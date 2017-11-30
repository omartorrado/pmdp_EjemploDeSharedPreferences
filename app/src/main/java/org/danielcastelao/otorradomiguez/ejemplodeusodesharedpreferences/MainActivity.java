package org.danielcastelao.otorradomiguez.ejemplodeusodesharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs;

    Button botonGuardarPrefs;
    EditText key1;
    EditText value1;
    EditText key2;
    EditText value2;
    EditText key3;
    EditText value3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //cargamos el archivo de preferencias por defecto
        prefs= getPreferences(Context.MODE_PRIVATE);
        //podriamos ponerle nuestro propio nombre con getSharedPreferences("nombre",Context.mode)
        botonGuardarPrefs=(Button)findViewById(R.id.botonPrefs);
        botonGuardarPrefs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarPrefs();
            }
        });

        key1=(EditText)findViewById(R.id.key1);
        value1=(EditText)findViewById(R.id.value1);
        key2=(EditText)findViewById(R.id.key2);
        value2=(EditText)findViewById(R.id.value2);
        key3=(EditText)findViewById(R.id.key3);
        value3=(EditText)findViewById(R.id.value3);

        /*
        Le damos a los EditText el valor almacenado, o en caso de nu haber ninguno el valor por
        defecto (en este caso por defecto le paso "null"
        */
        value1.setText(prefs.getString("key1","null"));
        value2.setText(prefs.getString("key2","null"));
        value3.setText(prefs.getString("key3","null"));
    }

    public void guardarPrefs(){
        //Cargamos el editor de SharedPreferences en una variable
        SharedPreferences.Editor prefEdit= prefs.edit();
        //Guardamos cada una de las preferencias pasandole un nombre y el valor
        prefEdit.putString("key1",value1.getText().toString());
        prefEdit.putString("key2",value2.getText().toString());
        prefEdit.putString("key3",value3.getText().toString());
        //realizamos un commit para que guarde los cambios, espere a terminar y continue con el codigo
        prefEdit.commit();
        /*
        con prefEdit.apply(); tb guardaria los cambios, pero en lugar de esperar a guardarlo todo
        continua ejecutando el codigo mientras las guarda
        */
    }

}
