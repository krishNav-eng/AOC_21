package binary_diagnostic

import java.io.File

fun part_1() {
    val input = File("/home/abhikrish/IdeaProjects/AOC_21/src/main/kotlin/binary_diagnostic/input.aoc").readLines()
    var gamma_rate = ""
    var epsilon_rate = ""
    for (i in 0 until input[0].length) {
        var count_1 = 0
        var count_0 = 0
        for (j in 0 until input.size) {
            if(input[j][i] == '1') count_1 ++
            if(input[j][i] == '0') count_0 ++
        }
        if (count_0>count_1) {
            gamma_rate+="0"
            epsilon_rate+="1"
        } else {
            gamma_rate+="1"
            epsilon_rate+="0"
        }
    }
    println(gamma_rate.binToInt()*epsilon_rate.binToInt())
}

fun part_2() {
  // Yet, to implement :)
}

fun main() {
    part_1()
    part_2()
}

// String binary repr to integer
fun String.binToInt() : Int{
    var n = 0
    forEachIndexed { index, c ->
        n += c.toString().toInt() * 2.pow(length-index-1)
    }
    return n
}

// Simple version of math exponents
fun Int.pow(i: Int) : Int{
    if(i==0) return 1
    if(i>0) {
        var n = this
        repeat(i - 1) { n *= this }
        return n
    }
    return -1
}
