package giant_squid_day_4

import java.io.File

fun main() {
  var numbers : List<Int> = listOf()
  // PARSING THE INPUT
  val board = mutableListOf<Int>()
  val x = mutableListOf<Boolean>()
  for (line in File(InputFilePath).readLines()) {
    if (numbers.isEmpty()) numbers = line.split(",").map { it.toInt() }
    else {
      if (line.isNotEmpty()) {
        (line.split(" ").forEach {
          if (it.isNotEmpty()) {
            board.add(it.toInt())
            x.add(false)
          }
        })
      }
    }
  }

  // Number of boards
  val nb = board.size/25
  println(nb)

  // Finding the answer for part 1 and part 2
  val winners = mutableListOf<Int>()
  numbers.forEach { num ->
    board.forEachIndexed { index, n ->
      if ((index / 25) !in winners && n == num) {
        x[index] = true
        for (b in 0 until nb) {
          // Check row
          var win = false
          for (c in 0..4) {
            var counter = 0
            for (r in 0..4) {
              if (x[25 * b + 5 * c + r]) {
                counter++
              } else break
            }
            if (counter == 5) {
              win = true
              break
            }
          }
          if (!win) {
            // Check col
            for (r in 0..4) {
              var counter = 0
              for (c in 0..4) {
                if (x[25 * b + 5 * c + r]) {
                  counter++
                } else break
              }
              if (counter == 5) {
                win = true
                break
              }
            }
          }
          if (win && b !in winners) {
            winners.add(b)
            if (winners.size == 1 || winners.size == nb) {
              var s = 0
              for (i in 25 * b until 25 * (b + 1)) {
                if (!x[i]) s += board[i]
              }
              println(num)
              println(num * s)
            }
          }
        }
      }
    }
  }
}
