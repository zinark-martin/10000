package com.example.viewmodeltest

class Dependency {
    //创建本对象时就同时创建libraries
    val libraries = ArrayList<String>()

    fun implementation(lib: String) {
        libraries.add(lib)
    }

}
fun dependencies(block: Dependency.() -> Unit): List<String> {
    val dependency = Dependency()
    dependency.block()
    return dependency.libraries
}

fun main() {
    val libraries = dependencies{
        implementation("123")
        implementation("321")
    }

    for (lib in libraries) {
        println(lib)
    }
}