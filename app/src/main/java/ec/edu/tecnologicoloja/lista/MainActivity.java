package ec.edu.tecnologicoloja.lista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import ec.edu.tecnologicoloja.lista.dataBase.Persona;
import ec.edu.tecnologicoloja.lista.dataBase.PersonaDao;
import ec.edu.tecnologicoloja.lista.dataBase.PersonaLab;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    Button btnSave, btnClear;

    PersonaLab personaLab;

    private List<Persona> list;//una variable para mostrar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.nombre);
        btnSave = findViewById(R.id.btnSave);
        btnClear = findViewById(R.id.btnClear);

        personaLab = new PersonaLab(this);//instanciamos a la clase lab

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Persona persona = new Persona(); //creamos un objeto persona para crear personas
                persona.setNombre(edtName.getText().toString().trim());//guardamos en la variable nombre de la clase persona lo que obtenemos del editex
                personaLab.addPersona(persona);//agregamos esa persona
                listarDatos();//listamos los datos una ves guardados
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personaLab.deleteAllPersona();//borramos todas las personas dela base
            }
        });

    }

    //metodo de listar
    public void listarDatos() { 
        list = personaLab.getPersonas();//de nuestro objeto lista le setiamos todas las personas

        for (Persona persona : list) {
            Log.i("Persona: ", "ID: " + persona.getId() + " Nombre: " + persona.getNombre());
        }

        //list.addAll(personaLab.getPersonas());
        //System.out.println(list.toString());
    }
}