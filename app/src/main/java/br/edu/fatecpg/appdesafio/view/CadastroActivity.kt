package br.edu.fatecpg.appdesafio.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.appdesafio.R
import br.edu.fatecpg.appdesafio.model.Item

class CadastroActivity : AppCompatActivity() {

    companion object {
        val listaItens = mutableListOf<Item>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtValor = findViewById<EditText>(R.id.edt_valor)
        val edtImagem = findViewById<EditText>(R.id.edt_imagem)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        val btnVerLista = findViewById<Button>(R.id.btn_ver_lista)

        btnSalvar.setOnClickListener {
            val item = Item(
                edtNome.text.toString(),
                edtValor.text.toString(),
                edtImagem.text.toString()
            )
            listaItens.add(item)
            edtNome.text.clear()
            edtValor.text.clear()
            edtImagem.text.clear()
        }

        btnVerLista.setOnClickListener {
            startActivity(Intent(this, ListaActivity::class.java))
        }
    }
}
