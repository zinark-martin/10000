val range:IntRange = 0..3
val range_exclusive:IntRange = 0 until 3

private val charRange:CharRange = 'a'..'c'
private val downRange: IntProgression = 0 downTo -10
private val range2:IntProgression = 1..2
private val emptyRange:IntRange = 0..-5

fun main() {
    println(range + range_exclusive + downRange + emptyRange + range2 + charRange)
    println('b' in charRange)
    for (x in charRange) {
        println(x)
    }
}