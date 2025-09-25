package br.edu.fatecpg.appdesafio.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.appdesafio.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtUser = findViewById<EditText>(R.id.edt_usuario)
        val edtPass = findViewById<EditText>(R.id.edt_senha)
        val btnLogin = findViewById<Button>(R.id.btn_login)

        btnLogin.setOnClickListener {
            // login fixo: admin / 123
            if (edtUser.text.toString() == "admin" && edtPass.text.toString() == "123") {
                startActivity(Intent(this, CadastroActivity::class.java))
                finish()
            } else {
                edtUser.error = "Usuário ou senha inválidos"
            }
        }
    }
}
