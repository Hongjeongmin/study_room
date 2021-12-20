/*
 * written by hjoo
 */

package `1220`

import java.io.*

/**
 * https://programmers.co.kr/learn/courses/30/lessons/72410
 */

/**
 * 해당 솔루션은 코틀린 최신버젼에서 풀이해서 프로그래머스에서는 에러납니다.
 * ㅠㅠ
 *
 */

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println(solution(br.readLine()))
}

private fun solution(new_id: String): String {
    new_id
        .lowercase()
        .replace(Regex("[^a-z0-9._-]"), "")
        .replace(Regex("[.]{2,}"), ".")
        .removePrefix(".")
        .removeSuffix(".")
        .apply {
            return if (this == "")
                "aaa"
            else if (this.length >= 16) {
                this.substring(0, 14).removeSuffix(".")
            } else if (this.length <= 2) {
                var tmp = this
                while (tmp.length != 3) {
                    tmp += this.last()
                }
                tmp
            } else {
                this
            }
        }
}

