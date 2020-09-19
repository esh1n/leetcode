package com.esh1n.problems

object Atoi {
    @JvmStatic
    fun main(strs: Array<String>) {
        val str = "123"
        val i:Int  = str[1] - '0'
        println(i)
        listOf("   -42", "-242", "4193 with words", "words and 987", "-91283472332").forEach {
            println(myAtoi(it))
        }
    }

    fun myAtoi(str: String): Int {
        var s = str.trim()
        if (s.isEmpty()) {
            return 0
        }
        val signs = charArrayOf('+', '-')
        if (!s[0].isDigit() && !(s[0] in signs && s.length > 1 && s[1].isDigit())) {
            return 0
        }
        val sign = if (s[0].isDigit() || s[0] == '+') 1 else -1
        s = if (s[0] in signs) s.drop(1) else s

        return run loop@{
            var digit: Int = Character.getNumericValue(s[0])*sign
            s = s.drop(1)
            s.forEach {
                if (!it.isDigit()) return@loop digit
                try {
                    digit = Math.addExact(Math.multiplyExact(digit, 10), Character.getNumericValue(it)*sign)
                } catch (e: ArithmeticException) {
                    return@loop if (sign > 0) Int.MAX_VALUE else Int.MIN_VALUE
                }
            }
            return@loop digit
        }
    }
}
