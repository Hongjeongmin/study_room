/*
 * written by hjoo
 */

package `1226`

import java.io.*
import java.util.*

/**
 * https://www.acmicpc.net/problem/12865
 */


fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    var numbers = mutableListOf<Int>()
    repeat(N) {
        numbers.add(br.readLine().toInt())
    }
    println(solution(numbers))
}

private fun solution(numbers: List<Int>): String {
    var minHeap = PriorityQueue<Int>(Comparator.naturalOrder())
    var maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())
    var answer = StringBuilder()
    numbers.forEachIndexed { index, number ->
        if (index % 2 == 1) {
            minHeap.offer(number)
        } else {
            maxHeap.offer(number)
        }
        if (minHeap.isNotEmpty() && minHeap.peek() < maxHeap.peek()) {
            val tmp = minHeap.poll()
            minHeap.offer(maxHeap.poll())
            maxHeap.offer(tmp)
        }
        answer.append("${maxHeap.peek()}\n")
    }
    return answer.toString()
}

