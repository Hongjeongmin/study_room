/*
 * written by hjoo
 */

package `1221`

import java.io.*
import kotlin.math.*

/**
 * https://programmers.co.kr/learn/courses/30/lessons/67256
 */


fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val numbersList = listOf(
        intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5),
        intArrayOf(7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2),
        intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    )
    val hands = listOf(
        "right", "left", "right"
    )
    for (i in 0..2) {
        println(solution(numbersList[i], hands[i]))
    }
}

/**
 *  x, y 좌표로 생각하면 편함
 *  *= (0,0) #=(2,0)
 *  1= (0,3) #=(2,3)
 *  각 숫자는 10 + x - 3y 다
 */
private fun solution(numbers: IntArray, hand: String): String {
    var lastLeft: Pair<Int, Int> = 0 to 0 // *
    var lastRight: Pair<Int, Int> = 2 to 0// #
    var answer = StringBuilder()

    numbers.forEach { num ->
        var tmp = num
        if (num == 0) {
            tmp = 11
        }
        when (tmp % 3) {
            0 -> {
                answer.append("R")
                lastRight = 2 to ((12 - tmp) / 3)
            }
            1 -> {
                answer.append("L")
                lastLeft = 0 to ((10 - tmp) / 3)
            }
            2 -> {
                val numPos: Pair<Int, Int> = 1 to ((11 - tmp) / 3)
                val disFromLeft =
                    (numPos.first - lastLeft.first).absoluteValue + (numPos.second - lastLeft.second).absoluteValue
                val disFromRight =
                    (numPos.first - lastRight.first).absoluteValue + (numPos.second - lastRight.second).absoluteValue
                if (disFromLeft > disFromRight) {
                    answer.append("R")
                    lastRight = numPos
                } else if (disFromLeft < disFromRight) {
                    answer.append("L")
                    lastLeft = numPos
                } else {
                    answer.append(hand.first().toUpperCase())
                    if (hand == "left") {
                        lastLeft = numPos
                    } else {
                        lastRight = numPos
                    }
                }
            }
        }
    }
    return answer.toString()
}

