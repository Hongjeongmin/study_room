/*
 * written by hjoo
 */

package `1228`

import java.io.*

/**
 * https://www.acmicpc.net/problem/18230
 */


fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, A, B) = br.readLine().split(" ").map { it.toInt() }
    val halfList = br.readLine().split(" ").map { it.toInt() }.sortedDescending()
    val fullList = br.readLine().split(" ").map { it.toInt() }.sortedDescending()
    println(solution(N, halfList, fullList))
}

private fun solution(N: Int, A: List<Int>, B: List<Int>): Int {
    var answer = 0
    var a = A
    var b = B
    var n = N
    if (n % 2 == 1) {
        answer += a.first()
        a = a.drop(1)
        n--
    }
    repeat(n / 2) {
        var sumA = 0
        var sumB = 0
        if (a.size >= 2) {
            sumA = a.component1() + a.component2()
        }
        if (b.isNotEmpty()) {
            sumB = b.component1()
        }
        if (sumA > sumB) {
            answer += sumA
            a = a.drop(2)
        } else {
            answer += sumB
            b = b.drop(1)
        }
    }
    return answer
}

