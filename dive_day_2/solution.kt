package aoc_21.dive_day_2

import java.io.File

fun main() {
    val pathname = "input.aoc"
    
    val directions = File(pathname).readLines().map { it.split(" ") }
    
    // Part 1
    var x = 0
    var y = 0
    
    for(dir in directions) {
        if(dir[0] == "forward") x += dir[1].toInt()
        if (dir[0] == "up") y -= dir[1].toInt()
        if (dir[0] == "down") y += dir[1].toInt()
    }

    println(x*y)
    
    // Part 2
    var depth = 0
    var aim = 0
    var hd = 0
    
    for(dir in directions) {
        val v = dir[1].toInt()
        if(dir[0] == "forward") {
            hd += v
            depth += aim * v
        }
        else if (dir[0] == "up") aim -= v
        else if (dir[0] == "down") aim += v
    }
    println(hd*depth)
}
