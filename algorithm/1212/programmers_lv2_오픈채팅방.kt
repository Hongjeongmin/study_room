/*
 * written by hjoo
 */


import java.io.*

/**
 * 문제 링크
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 */

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = arrayOf(
        "Enter uid1234 Muzi",
        "Enter uid4567 Prodo",
        "Leave uid1234",
        "Enter uid1234 Prodo",
        "Change uid4567 Ryan"
    )
    println(solution(input).map { it.toString() })
}

fun solution(record: Array<String>): Array<String> {
    val answer = mutableListOf<String>()
    val logs = mutableListOf<Pair<String, Boolean>>()
    val nickname = mutableMapOf<String, String>()
    record.forEach { rec ->
        val str = rec.split(" ")
        when (str[0]) {
            "Enter" -> {
                logs.add(str[1] to true)
                nickname[str[1]] = str[2]
            }
            "Leave" -> {
                logs.add(str[1] to false)
            }
            else -> {
                nickname.replace(str[1], str[2])
            }
        }
    }
    logs.forEach { (id, type) ->
        when (type) {
            true -> answer.add("${nickname[id]}님이 들어왔습니다.")
            false -> answer.add("${nickname[id]}님이 나갔습니다.")
        }
    }
    return answer.toTypedArray()
}
