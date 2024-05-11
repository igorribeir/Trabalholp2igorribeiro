package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() { 
    // Define a classe SplashActivity, que herda de AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) { 
        // Sobrescreve o método onCreate da Activity
        super.onCreate(savedInstanceState) 
        // Chama a implementação da superclasse do método onCreate
        setContentView(R.layout.activity_splash) 
        // Define o layout da atividade como o layout especificado em activity_splash

        Handler(Looper.getMainLooper()).postDelayed({ 
            // Cria um Handler associado ao Looper principal para executar uma ação após um atraso
            val i = intent 
            // Obtém o Intent recebido
            val j = Intent(this, PedidoActivity::class.java) 
            // Cria um novo Intent para iniciar a PedidoActivity
            j.putExtras(i) 
            // Adiciona os extras do Intent atual ao novo Intent
            startActivity(j) 
            // Inicia a PedidoActivity com o novo Intent
        }, 2000) 
        // Define um atraso de 2000 milissegundos (2 segundos) antes de executar a ação dentro do bloco de código
    }
}
