package mx.edu.ittepic.tap_u5_ejemplo1

import android.graphics.Matrix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //VARIABLES DE FORMA LARGA
    var numero = 9
    var sueldo = 1288.99 // double
    var altura = 1.8f //float
    var direccionCasa = "Allende 200" // String
    var resultado = true //boolean

    var nombreCompleto : String = ""
    var edad : Int = 0

    var nombreCampoTexto : EditText ?= null //?= construyendo una variable editText sin asociar con xml aun
    var boton : Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //Manda llamar al onCreate padre APPCOMPACTIVITY()
        setContentView(R.layout.activity_main) //InitComponent()

        //asociacion de la variable nombreCampoTexto de Kotlincon un objeto XML a traves de su ID
        //nombreCampoTexto = findViewById(R.id.editTextTextPersonName)
        //boton = findViewById(R.id.botonSaludador)

        camponombrepersona.setText("Carlos Rodriguez")
        // asignar Evento Click al boton

        botonsaludador.setOnClickListener {
            var nombre = camponombrepersona.text.toString() //.getText()
            if( nombre.isEmpty() == true){
                AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Debes Poner un nombre en el campo de texto !")
                    .setPositiveButton("OK",{d,i-> d.dismiss()})
                    .show()
            }else {
                //el objeto AlertDialog es el equivalente a JOptionPane
                //La instruccion val declara un objeto semi estatuci requiere menos memoria que VAL
                //Var cuando cambie mucho
                val alerta = AlertDialog.Builder(this)
                alerta.setTitle("Atencion")
                alerta.setMessage("Hola como estas ${nombre} como estas??") // ${ variable } precompilador
                alerta.setPositiveButton("ACEPTAR", { d, i ->
                    //d = dialog = Informar a ANDROID si el AlertDialog se cerro de manera positiva o negativa
                    // I = Excepcion = se ejecuta en caso de error, cuando no hay error esta en null

                    d.dismiss() //positivo
                })
                alerta.setNegativeButton("Cancelar", { d, i ->
                    d.cancel()
                })
                //alerta.setNeutralButton()
                alerta.show()

                radioButton2.setOnClickListener {
                    Toast.makeText(this, "Ud es CASADO", Toast.LENGTH_LONG).show()
                }

                radioButton3.setOnClickListener {
                    Toast.makeText(this, "UD es SOLTERO", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}