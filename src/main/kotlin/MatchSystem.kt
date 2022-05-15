import type.MatchType

class MatchSystem(private val matchType: MatchType) {

    private val list: MutableList<Individual> = mutableListOf()

    init {
//        println("----------- person list -----------")
        for (i in 2..100) {
            val habitList = mutableListOf<Habit>()
            for (j in 0..(Math.random() * 7).toInt()) {
                habitList.add(Habit.values()[j])
            }
            val person = Individual(
                id = i,
                gender = Gender.values()[i % 2], // 我們接受彩虹的顏色!!!
                age = 18 + (Math.random() * 30).toInt(),
                intro = "我是 $i 號，你好".toCharArray(),
                habits = habitList,
                coord = Coord(i, i)
            )
            list.add(person)
//            println("person $person")
        }
    }

    fun match(
        individual: Individual,
    ): Individual? {
        return matchType.match(individual, list)
    }

    fun matchReverse(
        individual: Individual,
    ): Individual? {
        return matchType.matchReverse(individual, list)
    }
}