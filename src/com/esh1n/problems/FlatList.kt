package com.esh1n.problems

object FlatList {
    @JvmStatic
    fun main(strs: Array<String>) {
        val categories = arrayListOf(Category("cat1",
                listOf(Question("question1", "answer1"),
                        Question("question2", "answer2")),expanded = true),
                Category("cat2",
                        listOf(Question("question3", "answer3"),
                                Question("question4", "answer4")),expanded = false),
                Category("cat3",
                        listOf(Question("question5", "answer5"),
                                Question("question6", "answer6")),expanded = true))
        val size = categories.size + categories.map { if (it.expanded) it.questions.size else 0 }.sum()
        println("size : $size")
        for (i in 0 until size) {
            val item = getItem(i, categories)
            println(item.toHumanReadable() + ": ${i}")
        }
    }


    private fun getItem(position: Int, categories: List<Category>): Item {
        var counter = 0
        categories.forEachIndexed { index, category ->
            if (counter == position)
                return category
            if (category.expanded) {
                if (position <= counter + category.questions.size) {
                    return category.questions[position - counter -1]
                } else {
                    counter += category.questions.size
                }
            }
            counter++
        }
        return categories[0]
    }
}

sealed class Item{
    fun toHumanReadable() = when(this){
        is Question -> title
        is Category -> name
    }
}
data class Question(val title: String, val answer: String, var expanded: Boolean = false) : Item()
data class Category(val name: String, val questions: List<Question>, var expanded: Boolean = false) : Item()