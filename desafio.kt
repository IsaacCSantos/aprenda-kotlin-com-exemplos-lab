enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val matricula:String, var nome:String, var email:String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    fun listarInscritos(){
        inscritos.forEach{println("${it.matricula} - ${it.nome} - ${it.email}")}
    }
    
    fun listarConteudos(){
        for (i in conteudos){
            println("${i.nome} - Duração ${i.duracao} minutos - Nivel: ${i.nivel}")
        } 
    }
    fun buscarInscrito(matricula:String){
    	inscritos.filter{it.matricula == matricula}.forEach{println("${it.matricula} - ${it.nome} - ${it.email}")}
    }
}

fun main() {
    val usuarioIsaac = Usuario("1","Isaac","isaac@teste.com.br")
    val usuarioJoao = Usuario("2","João", "joao@teste.com.br")
  	val listaConteudo = mutableListOf<ConteudoEducacional>(
    	ConteudoEducacional("Conhecendo o Kotlin e sua Documentação Oficial", 60, Nivel.BASICO),
        ConteudoEducacional("Introdução Prática à Linguagem de Programação Kotlin", 120, Nivel.BASICO),
        ConteudoEducacional("Estrutura de Controle de Fluxo e Coleções em Kotlin", 120, Nivel.BASICO),
        ConteudoEducacional("Orientação a Objetos e Tipos de Classes na Prática com Kotlin", 120, Nivel.INTERMEDIARIO),
        ConteudoEducacional("O poder das Funções Kotlin", 60, Nivel.AVANCADO)
    );
    
    val formacao = Formacao("Kotlin Experience", listaConteudo, Nivel.BASICO)
    formacao.matricular(usuarioIsaac)
    formacao.matricular(usuarioJoao)
    println("-----Dados da Formacao------")
    println("Formacao: ${formacao.nome}")
    println("Nivel: ${formacao.nivel}")
    println("----------Inscritos---------")
	formacao.listarInscritos()
    println("----------Conteudo----------")
    formacao.listarConteudos()
    println("----------------------------")
    formacao.buscarInscrito("1")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}