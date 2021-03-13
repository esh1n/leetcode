package com.esh1n.problems

import java.util.*

object `20_Valid_Parentheses` {
    @JvmStatic
    fun main(args: Array<String>) {

        val list = listOf("()", "()[]{}", "(]", "([)]", "{[]}")
        list.forEach { s ->
            println("$s : ${isValid(s)}")
        }
    }

    fun isValid(s: String): Boolean {
        val openBrackets = listOf('(', '{', '[')
        val closeBrackets = listOf(')', '}', ']')
        if (s[0] in closeBrackets || s.length == 1) return false
        fun isOpenBracket(ch: Char) = ch in openBrackets
        fun isCloseBracket(ch: Char) = ch in closeBrackets
        fun isMatchBracket(openBracket: Char, closeBracket: Char) =
                openBrackets.indexOf(openBracket) == closeBrackets.indexOf(closeBracket)

        val stack = Stack<Char>()
        s.forEach { ch ->
            if (isOpenBracket(ch)){
                stack.push(ch)
            }else if(isCloseBracket(ch)){
                if(stack.isEmpty()){
                    return false
                }else{
                    if(isMatchBracket(stack.peek(),ch)){
                        stack.pop()
                    }else{
                        return false
                    }
                }
            }
        }
        return stack.isEmpty()
    }
}