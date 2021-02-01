val listOfNull = mutableListOf<String?>(null,null,null)
listOfNull.forEachIndexed{index,s -> println(index) }
listOfNull.removeAt(1)
listOfNull.forEachIndexed{index,s -> println(index) }


val list2 = mutableListOf<String?>("Test","Test2")
val list3 = list2.subList(1,list2.size)
println(list3.isEmpty())
println(list3.getOrNull(3))
list2.forEachIndexed{index,s -> println(index) }


val list4 = mutableListOf<String?>("Test","Test2")
list4.subList(0,1).forEachIndexed{index,s -> println(s) }

val index= 1
val isIn = index in 1..3
print(isIn)