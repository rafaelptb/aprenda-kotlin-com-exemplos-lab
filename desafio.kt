enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val codigo: Int, val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        
        inscritos.add(usuario)
    }
}

fun main() {
    
    val usuario01 = Usuario(1, "Usuário 01")
    val usuario02 = Usuario(2, "Usuário 02")
    val usuario03 = Usuario(3, "Usuário 03")
    
    val conteudos = listOf(
        ConteudoEducacional("Conteudo 01", 50),
        ConteudoEducacional("Conteudo 02", 50)        
    )
    
    val formacao = Formacao("Formação Básica", Nivel.BASICO, conteudos)
    
    formacao.matricular(usuario01)
    formacao.matricular(usuario02)
    
    println("Formação: ${formacao.nome}")
    println("Nível: ${formacao.nivel}")
    println()
    
    println("====== Conteúdo Programático ======")
    formacao.conteudos.forEach{
        println(it.nome)
    }
    
    println()
    
    println("====== Usuários Matriculados ======")
    formacao.inscritos.forEach{        
        println(it.nome)
    }
    
}
