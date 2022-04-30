package curso.kotlin.appsomar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var primeiroNum = 0
    var segundoNum = 0
    var soma = 0
    var somatorio = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editPrimeiroNum = findViewById<EditText>(R.id.editPrimeiroNum)
        val editSegundoNum = findViewById<EditText>(R.id.editSegundoNum)

        val txtSomaCalculada = findViewById<TextView>(R.id.txtSomaCalculada)
        val txtSomatorioCalculado = findViewById<TextView>(R.id.txtSomatorioCalculado)

        val btnSomar = findViewById<Button>(R.id.btnSomar)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)
        val btnSair = findViewById<Button>(R.id.btnSair)

        btnSomar.setOnClickListener {

            if (editPrimeiroNum.text.toString().isEmpty()) {

                editPrimeiroNum.setError("* Campo Obrigatório *")
                editPrimeiroNum.requestFocus()

            } else if (editSegundoNum.text.toString().isEmpty()) {

                editSegundoNum.setError("* Campo Obrigatório *")
                editSegundoNum.requestFocus()

            } else {
                primeiroNum = editPrimeiroNum.text.toString().toInt()
                segundoNum = editSegundoNum.text.toString().toInt()
                soma = primeiroNum.plus(segundoNum)
                somatorio = somatorio.plus(soma)

                txtSomaCalculada.setText(soma.toString())
                txtSomatorioCalculado.setText(somatorio.toString())
            }

            Toast.makeText(this, "Botão SOMAR clicado.", Toast.LENGTH_SHORT).show()
        }

        btnLimpar.setOnClickListener {

            soma = 0
            txtSomaCalculada.setText("")
            editPrimeiroNum.setText("")
            editSegundoNum.setText("")

            Toast.makeText(this, "Botão LIMPAR clicado.", Toast.LENGTH_SHORT).show()
        }
    }

    fun eventoSair(view: View) {
        finish()
    }
}