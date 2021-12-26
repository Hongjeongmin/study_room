/*
 * written by hjoo
 */

package `1226`

import java.io.*
import kotlin.math.*

/**
 * https://www.acmicpc.net/problem/12865
 */


fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    // N: 물품 갯수, K: 버틸수 있는 무게
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    var goodsList = Array<IntArray>(N + 1) { IntArray(2) }
    repeat(N) {
        goodsList[it + 1] = br.readLine().split(" ").map { n -> n.toInt() }.toIntArray()
    }
    goodsList.sortBy { it[0] }
    println(solution(N, K, goodsList))
}

private fun solution(N: Int, K: Int, goods: Array<IntArray>): Int {
    var dp = Array<IntArray>(N + 1) { IntArray(K + 1) }
    for (i in 1..N) {
        for (weight in 1..K) {
            if (weight - goods[i][0] >= 0) {
                dp[i][weight] = max(dp[i - 1][weight], dp[i - 1][weight - goods[i][0]] + goods[i][1])
            } else {
                dp[i][weight] = dp[i - 1][weight]
            }
        }
    }
    return dp[N][K]
}

