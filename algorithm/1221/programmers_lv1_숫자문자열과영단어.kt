/*
 * written by hjoo
 */

package `1221`

import java.io.*

/**
 * https://programmers.co.kr/learn/courses/30/lessons/81301
 */


fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println(solution(br.readLine()))
}

/**
 * 0 -> z   3
 * 1 -> o   2
 * 2 -> tw  1
 * 3 -> th  3
 * 4 -> fo  2
 * 5 -> fi  2
 * 6 -> si  2
 * 7 -> se  3
 * 8 -> e   4
 * 9 -> n   3
 */
private fun solution(s: String): Int {
    var answer = StringBuilder()
    var index = 0
    while (index < s.length) {
        if (s[index].isDigit()) {
            answer.append(s[index])
            index++
        } else {
            when (s[index]) {
                'z' -> {
                    answer.append(0)
                    index += 4
                }
                'o' -> {
                    answer.append(1)
                    index += 3
                }
                't' -> {
                    if (s[index + 1] == 'w') {
                        answer.append(2)
                        index += 3
                    } else {
                        answer.append(3)
                        index += 5
                    }
                }
                'f' -> {
                    if (s[index + 1] == 'o') {
                        answer.append(4)
                    } else {
                        answer.append(5)
                    }
                    index += 4
                }
                's' -> {
                    if (s[index + 1] == 'i') {
                        answer.append(6)
                        index += 3
                    } else {
                        answer.append(7)
                        index += 5
                    }
                }
                'e' -> {
                    answer.append(8)
                    index += 5
                }
                else -> {
                    answer.append(9)
                    index += 4
                }
            }
        }
    }
    return answer.toString().toInt()
}

