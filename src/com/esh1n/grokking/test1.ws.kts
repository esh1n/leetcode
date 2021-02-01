val ivan = "cool"
print(ivan)


data class Human(var legs: Int, val arms: Int)

val sergey = Human(2, 2)
print("sergey: ${sergey.arms} ${sergey.legs}")
sergey.legs = 3

print("sergey: ${sergey.arms} ${sergey.legs}")

val newSergey = sergey.copy(legs = 4)

print("sergey: ${newSergey.arms} ${newSergey.legs}")

fun findMaxDigit(): Int {
    var newMax = 0
    listOf(1, 2, 3, 4, 5).forEach lit@{
        newMax = it
        if (it == 3) return@lit // local return to the caller of the lambda, i.e. the forEach loop
        print(it)
    }

    loop1@ for (i in 1..100) {
        return@loop1
    }


    val myMax = 12
    return myMax + newMax
}

fun digitMax1(){
//    loop@ for (i in 1..5) {
//        loopInner@for (j in 1..5) {
//            println("i:$i j $j ${i*j}")
//            if (i * j == 8) return
//        }
//    }

   val res:Int =  run loop@{
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@loop 1 // non-local return from the lambda passed to run
            //print(it)

        }
        return@loop 1
    }
    print("$res done with nested loop")
}
println(digitMax1())




