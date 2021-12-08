package binary_diagnostic

import java.io.File

const val InputFilePath = "/input.aoc"

// GammaRate, EpsilonRate
fun part1(input: List<String>) {
    val gammaRate: String = buildString {
        for (i in 0 until input[0].length) {
            val (zeroes, ones) = input.bitCountInColumn(i)
            if(zeroes>ones) append('0') else append('1')
        }
    }
    val epsilonRate : String = gammaRate.invert()
    print("GammaRate = $gammaRate, EpsilonRate = $epsilonRate")
    println(gammaRate.toInt(2)*epsilonRate.toInt(2))
}

private fun String.invert(): String = this.asIterable()
    .joinToString("") { if (it == '0') "1" else "0" }

// O2 generating rating and CO2 scrubber rating

enum class RatingType {
    OXYGEN,
    CO2
}

fun part2(input: List<String>): Int {
    fun rating(type: RatingType): String {
        val list: List<String> = input
        for (c in input[0].indices) {
            val (zeroes, ones) = list.bitCountInColumn(c)
            list.filter {
                when (type) {
                    RatingType.OXYGEN -> it[c] == if (ones>zeroes) '1' else '0'
                    RatingType.CO2 -> it[c] != if (ones>zeroes) '1' else '0'
                }
            }
        }
        return list.single()
    }
    return rating(RatingType.OXYGEN).toInt(2) * rating(RatingType.CO2).toInt(2)
}

fun List<String>.bitCountInColumn(column : Int) : Pair<Int, Int> {
    var zeroes = 0
    var ones = 0
    forEach {
        when (it[column]) {
            '0' -> zeroes++
            '1' -> ones++
        }
    }
    return zeroes to ones
}

fun main() {
    val input = File(InputFilePath).readLines()
    part1(input)
    part2(input)
}
