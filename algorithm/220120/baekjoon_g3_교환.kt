/*
 * written by hjoo
 */

package `220120`

import java.io.*
import java.util.*

/**
 * https://www.acmicpc.net/problem/1039
 */

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, K) = br.readLine().split(" ")
    println(solution(N, K.toInt()))
}

private fun solution(N: String, K: Int): Int {
    var answer = -1
    val size = N.length
    val queue: Queue<Pair> = LinkedList()
    val visit = Array(1000001) { Array(11) { false } }
    var number = N.toInt()
    visit[number][0] = true
    queue.add(Pair(number, 0))

    while (queue.isNotEmpty()) {
        val now = queue.poll()
        if (now.cnt == K) {
            answer = maxOf(answer, now.num)
            continue
        }

        var chars = now.num.toString().toCharArray()
        for (i in 0 until size - 1) {
            for (j in i + 1 until size) {
                chars = chars.swap(i, j)
                number = chars.concatToString().toInt()
                if (chars[0] == '0' || visit[number][now.cnt + 1]) {
                    chars = chars.swap(i, j)
                    continue;
                }

                visit[number][now.cnt + 1] = true
                queue.add(Pair(number, now.cnt + 1))
                chars = chars.swap(i, j)
            }
        }
    }

    return answer
}

private fun CharArray.swap(i: Int, j: Int): CharArray {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
    return this
}


data class Pair(
    val num: Int,
    val cnt: Int,
)


