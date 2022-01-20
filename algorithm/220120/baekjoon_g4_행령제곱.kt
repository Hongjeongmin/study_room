/*
 * written by hjoo
 */

package `220120`

/**
 * @author Hwandong Joo
 */

import java.io.*
import java.util.*


/**
 * https://www.acmicpc.net/problem/10830
 */

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    var B = st.nextToken().toLong()

    var answer = Array(N) { Array(N) { 0L } }
    var dp = Array(N) { Array(N) { 0L } }

    // intialize first N x N
    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until N) {
            dp[i][j] = st.nextToken().toLong()
        }
        answer[i][i] = 1

    }

    while (B > 0) {
        if (B % 2 == 1L) {
            answer = calc(N, answer, dp)
        }
        dp = calc(N, dp, dp)
        B /= 2
    }
    for (i in 0 until N) {
        for (j in 0 until N) {
            print("${answer[i][j]} ")
        }
        println()
    }
}

private fun calc(N: Int, a: Array<Array<Long>>, b: Array<Array<Long>>): Array<Array<Long>> {
    val tmp = Array(N) { Array(N) { 0L } }
    for (i in 0 until N) {
        for (j in 0 until N) {
            for (k in 0 until N) {
                tmp[i][j] += a[i][k] * b[k][j]
            }
            tmp[i][j] = tmp[i][j] % 1000
        }
    }
    return tmp
}

