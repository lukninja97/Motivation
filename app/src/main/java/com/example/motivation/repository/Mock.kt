package com.example.motivation.repository

import com.example.motivation.infra.MotivationConstants
import java.util.*

data class frase(val descricao: String, val categoria: Int)

class Mock {

    private val ALL = MotivationConstants.FRASEFILTER.ALL
    private val MORNING = MotivationConstants.FRASEFILTER.MORNING
    private val HAPPY = MotivationConstants.FRASEFILTER.HAPPY

    private val mListPhrases: List<frase> = listOf(
        frase("Não sabendo que era impossível, foi lá e fez.", HAPPY),
        frase("Você não é derrotado quando perde, você é derrotado quando desiste!", HAPPY),
        frase("Quando está mais escuro, vemos mais estrelas!", HAPPY),
        frase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", HAPPY),
        frase("Não pare quando estiver cansado, pare quando tiver terminado.", HAPPY),
        frase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", HAPPY),
        frase("A melhor maneira de prever o futuro é inventá-lo.", MORNING),
        frase("Você perde todas as chances que você não aproveita.", MORNING),
        frase("Fracasso é o condimento que dá sabor ao sucesso.", MORNING),
        frase(" Enquanto não estivermos comprometidos, haverá hesitação!", MORNING),
        frase("Se você não sabe onde quer ir, qualquer caminho serve.", MORNING),
        frase("Se você acredita, faz toda a diferença.", MORNING),
        frase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", MORNING)
    )

    fun getFrase(categoria: Int): String{

        val filtered = mListPhrases.filter { (it.categoria == categoria) || categoria == ALL }

        val rand = Random().nextInt(filtered.size)

        return filtered[rand].descricao
    }
}