package aoc_21.sonar_sweep

import java.io.File

fun getInputAsInts(pathname: String) = File(pathname).readLines().map { it.toInt() }

fun main() {
    val InputFilePath = "input_1.aoc"
    // Part 1
    val input = readInputAsInts(InputFilePath)
    println(input.windowed(2).count { (a, b) -> a < b })

    // Part 2
    val input_2 = readInputAsInts(InputFilePath)
    // x+y+z compared with y+z+a
    // y+z is common, we can directly
    // compare x and a (i.e. take windowing... of 4
    // and comparing first and the last
    println(input_2.windowed(4).count { it[0] < it[3] } ) 
}
