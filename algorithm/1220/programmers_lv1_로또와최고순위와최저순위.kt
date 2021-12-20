/*
 * written by hjoo
 */

package `1220`

import java.io.*

/**
 * https://programmers.co.kr/learn/courses/30/lessons/77484
 */

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val lottos = listOf(
        intArrayOf(
            44, 1, 0, 0, 31, 25
        ),
        intArrayOf(
            0, 0, 0, 0, 0, 0
        ),
        intArrayOf(
            45, 4, 35, 20, 3, 9
        )
    )
    val winNums = listOf(
        intArrayOf(
            31, 10, 45, 1, 6, 19
        ),
        intArrayOf(
            38, 19, 20, 40, 15, 25
        ),
        intArrayOf(
            20, 9, 3, 45, 4, 35
        )
    )
    val results = listOf(
        intArrayOf(3, 5),
        intArrayOf(1, 6),
        intArrayOf(1, 1)
    )
    lottos.forEachIndexed { index, lotto ->
        println(solution(lotto, winNums[index]).contentEquals(results[index]))
    }
}

fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
    val min = lottos.filter { lotto -> win_nums.any { it == lotto } }.size
    val possible = lottos.filter { it == 0 }.size
    val first = if (min + possible == 0) 6 else 7 - min - possible
    val second = if (min == 0) 6 else 7 - min
    var answer: IntArray = intArrayOf(first, second)
    return answer
}

