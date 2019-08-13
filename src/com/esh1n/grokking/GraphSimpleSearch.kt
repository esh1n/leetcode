package com.esh1n.grokking

import java.util.*


object GraphSimpleSearch {
    @JvmStatic
    fun main(args: Array<String>) {
        val users = hashMapOf("you" to arrayOf("alice", "bob", "claire"), "bob" to arrayOf("anuj", "peggy"),
                "alice" to arrayOf("peggy"), "claire" to arrayOf("tom", "johny")
                , "anuj" to arrayOf(), "peggy" to arrayOf(), "tom" to arrayOf(), "johny" to arrayOf())
        val searchResult = search("you", users) ?: "not found"
        println("search of mango seller $searchResult")
    }

    private fun search(name: String, users: HashMap<String, Array<String>>): String? {
        val searchQueue = ArrayDeque<String>()
        users[name]?.forEach { searchQueue.add(it) }
        val searched = hashSetOf<String>()
        while (searchQueue.isNotEmpty()) {
            val person = searchQueue.pop()
            if (!searched.contains(person)) {
                if (personIsSeller(person)) {
                    return person
                } else {
                    users[person]?.forEach { searchQueue.add(it) }
                    searched.add(person)
                }
            }
        }
        return null

    }

    private fun personIsSeller(person: String): Boolean {
        return person.contains("m")
    }
}