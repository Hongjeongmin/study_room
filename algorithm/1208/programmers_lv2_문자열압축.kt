/*
 * written by hjoo
 */


import java.io.*
import kotlin.math.*

/**
 * 문제 링크
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 */

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()
    println(solution(input))
}

fun solution(s: String): Int {
    var answer = Int.MAX_VALUE
    for (i in 1 until s.length) {
        var count = 1.0
        var min = 0
        var str = ""
        for (j in s.indices step i) {
            str = s.substring(j, j + i)
            val nextStr = if (j + 2 * i <= s.length) s.substring(j + i, j + 2 * i) else s.substring(j + i)

            if (str.length == nextStr.length) {
                if (str == nextStr) {
                    count++
                } else {
                    if (count != 1.0) {
                        min += log10(count).toInt() + 1
                    }
                    min += str.length
                    count = 1.0
                }
            } else {
                if (count != 1.0) {
                    min += log10(count).toInt() + 1
                    count = 1.0
                }
                min += str.length + nextStr.length
                break
            }
        }
        if (count != 1.0) {
            min += log10(count).toInt() + 1
            min += str.length
        }
        answer = min(answer, min)
    }
    return if (answer == Int.MAX_VALUE) 1 else answer
}
