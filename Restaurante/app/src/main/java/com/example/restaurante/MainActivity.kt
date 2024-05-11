package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() { 
    // Define a classe MainActivity, que herda de AppCompatActivity

    private lateinit var binding: ActivityMainBinding 
    // Declara uma variável lateinit do tipo ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) { 
        // Sobrescreve o método onCreate da Activity
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Infla o layout da atividade usando o Binding gerado para a ActivityMain

        super.onCreate(savedInstanceState) 
        // Chama a implementação da superclasse do método onCreate
        setContentView(binding.root) 
        // Define o layout inflado como o layout da atividade

        val username = intent.extras?.getString("username")
        // Obtém o nome de usuário do Intent recebido

        if (!username.isNullOrEmpty()) { 
            // Verifica se o nome de usuário não é nulo nem vazio
            binding.textOla.setText("Olá $username")
            // Define o texto de saudação com o nome de usuário
        }

        binding.buttonFechar.setOnClickListener {
            // Define um listener de clique para o botão de fechar
            finishAffinity() 
            // Finaliza todas as atividades da pilha de tarefas
        }

        binding.buttonPedir.setOnClickListener { 
            // Define um listener de clique para o botão de pedir
            val i = Intent(this, SplashActivity::class.java) 
            // Cria um Intent para iniciar a SplashActivity
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString())
            // Adiciona a quantidade de pizza como um extra para o Intent
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString())
            // Adiciona a quantidade de salada como um extra para o Intent
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())
            // Adiciona a quantidade de hambúrguer como um extra para o Intent
            startActivity(i)
            // Inicia a SplashActivity com o Intent
            finish() 
            // Finaliza a atividade atual (MainActivity)
        }

        binding.checkPizza.setOnClickListener { 
            // Define um listener de clique para o checkbox de pizza
            if (binding.checkPizza.isChecked()) { 
                // Verifica se o checkbox de pizza está marcado
                binding.editQuantidadePizza.setText("1") 
                // Define a quantidade de pizza como 1
                binding.textPrecoPizza.visibility = View.VISIBLE 
                // Torna o preço da pizza visível
            } else { // Se o checkbox de pizza não estiver marcado
                binding.editQuantidadePizza.setText("0") 
                // Define a quantidade de pizza como 0
                binding.textPrecoPizza.visibility = View.GONE 
                // Torna o preço da pizza invisível
            }
        }

        // Os próximos dois blocos de código são semelhantes aos comentados acima, mas para os checkboxes de salada e hambúrguer, respectivamente.
        binding.checkSalada.setOnClickListener { 
            if (binding.checkSalada.isChecked()) { 
                binding.editQuantidadeSalada.setText("1") 
                binding.textPrecoSalada.visibility = View.VISIBLE 
            } else { 
                binding.editQuantidadeSalada.setText("0") 
                binding.textPrecoSalada.visibility = View.GONE 
            }
        }

        binding.checkHamburger.setOnClickListener { 
            if (binding.checkHamburger.isChecked()) { 
                binding.editQuantidadeHamburguer.setText("1") 
                binding.textPrecoHamburguer.visibility = View.VISIBLE 
            } else { 
                binding.editQuantidadeHamburguer.setText("0") 
                binding.textPrecoHamburguer.visibility = View.GONE 
            }
        }

    }
}
