package com.example.tarea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Tarea> lasTareas;
    private  int indice;

    private TextInputLayout tilTitulo, tilDescripcion;

    private Button btnIngresar, btnModificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        indice = 0;
        lasTareas = new ArrayList<>();

        referencias();
        eventos();
    }

    private void mostrarTarea(){
        Tarea tarea = lasTareas.get(indice);

        if(tarea != null) {
            ????.setText(tarea.getTitulo());
            ????.setText(String.valueOf(tarea.getDescripcion()));


        }else{
            Toast.makeText(MainActivity.this, "Tarea no existe", Toast.LENGTH_LONG).show();
        }
    }

    public void grabarTarea(){
        String titulo, descripcion;

        titulo = tilTitulo.getEditText().getText().toString();

        descripcion = tilTitulo.getEditText().getText().toString();


        if(validarDatos(titulo, descripcion)){

            Tarea tar = new Tarea(titulo, descripcion);

            lasTareas.add(tar);
            indice = lasTareas.size();

            tilTitulo.getEditText().setText("");
            tilDescripcion.getEditText().setText("");

            Toast.makeText(this, "Tarea grabada exitosamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Tiene errores en el formulario", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean validarDatos(String titulo, String descripcion){
        boolean vOK = true;
        tilTitulo.setError(null);
        tilDescripcion.setError(null);

        if(titulo.isEmpty()){
            vOK = false;
            tilTitulo.setError("Debe ingresar título");
        }

        if(descripcion.isEmpty()) {
            vOK = false;
            tilDescripcion.setError("Debe ingresar descripcion");
        }
        return vOK;
    }
    private void referencias(){
        tilTitulo = findViewById(R.id.tilTitulo);
        tilDescripcion = findViewById(R.id.tilDescripcion);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnModificar = findViewById(R.id.btnModificar);
    }

    private void eventos() {

    }
}