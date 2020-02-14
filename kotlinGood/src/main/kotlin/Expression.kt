fun main(args: Array<String>) {
    when (args[3]) {
        "4" -> println(4)//不需要写break
        "5" -> println(5)
        else -> {
        }
    }
    when (args[3]) {
        "4" -> {
            println(4)
            println(5)
        }
        "5" -> println(5)
        else -> {
        }
    }
}