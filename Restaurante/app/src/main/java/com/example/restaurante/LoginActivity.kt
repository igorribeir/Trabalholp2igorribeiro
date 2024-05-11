package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
//Criação da variável binding que servirá para manipular a tela.
    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // Sobrescreve o método onCreate da Activity.
        super.onCreate(savedInstanceState)
        // Chama a implementação da superclasse do método onCreate.

        binding = ActivityLoginBinding.inflate(layoutInflater)
        // Infla o layout da atividade usando o Binding gerado para a ActivityLogin
        setContentView(binding.root)
        // Define o layout inflado como o layout da atividade

        binding.buttonEntrar.setOnClickListener {
            // Define um listener de clique para o botão de entrada
            val username = binding.editUsername.text.toString().trim()
            // Obtém o texto do campo de nome de usuário e remove espaços em branco
            val password = binding.editPassword.text.toString().trim()
            // Obtém o texto do campo de senha e remove espaços em branco

            if (username.equals("abc") && password.equals("123")) {
                // Verifica se o nome de usuário é "abc" e a senha é "123"
                val i = Intent(this, MainActivity::class.java)
                // Cria um Intent para iniciar a MainActivity
                i.putExtra("username", username)
                // Adiciona o nome de usuário como um extra para o Intent
                startActivity(i)
                // Inicia a MainActivity com o Intent
                finish()
                // Finaliza a atividade atual (LoginActivity)
            } else {
                // Se as credenciais não corresponderem
                Toast.makeText(applicationContext, "Errou", Toast.LENGTH_LONG).show()
                // Exibe um Toast informando que as credenciais estão erradas
            }
        }

    }
}
