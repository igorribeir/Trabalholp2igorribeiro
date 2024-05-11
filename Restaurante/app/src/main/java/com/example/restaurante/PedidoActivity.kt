package com.example.restaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurante.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() { 
    // Define a classe PedidoActivity, que herda de AppCompatActivity
    private lateinit var binding: ActivityPedidoBinding 
    // Declara uma variável lateinit do tipo ActivityPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) { 
        // Sobrescreve o método onCreate da Activity
        binding = ActivityPedidoBinding.inflate(layoutInflater) 
        // Infla o layout da atividade usando o Binding gerado para a ActivityPedido

        super.onCreate(savedInstanceState) 
        // Chama a implementação da superclasse do método onCreate
        setContentView(binding.root) 
        // Define o layout inflado como o layout da atividade

        val i = intent 
        // Obtém o Intent recebido
        val quantidadePizza = i.getStringExtra("quantidadePizza").toString().toInt()
        // Obtém a quantidade de pizzas do Intent e converte para inteiro
        val quantidadeSalada = i.getStringExtra("quantidadeSalada").toString().toInt() 
        // Obtém a quantidade de saladas do Intent e converte para inteiro
        val quantidadeHamburguer = i.getStringExtra("quantidadeHamburguer").toString().toInt() 
        // Obtém a quantidade de hambúrgueres do Intent e converte para inteiro

        // Cria uma string contendo o resumo do pedido, incluindo quantidade e preço de cada item
        val texto = "Resumo do Pedido\n" +
                    "Pizza: $quantidadePizza Preço: ${quantidadePizza*8}\n" +
                    "Salada: $quantidadeSalada Preço: ${quantidadeSalada*10}\n" +
                    "Hamburguer: $quantidadeHamburguer Preço: ${quantidadeHamburguer*12}\n"

        binding.textResumo.text = texto 
        // Define o texto do TextView de resumo com a string criada
    }
}
