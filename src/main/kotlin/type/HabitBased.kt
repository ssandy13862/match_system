package type

import Individual

class HabitBased : MatchType {

    private var minId = -1
    private var matchPerson: Individual? = null

    override fun match(
        individual: Individual,
        list: MutableList<Individual>
    ): Individual? {
        println("\nmatch start")
        println("------------------------------------------------")
        println("person habits: ${individual.habits}")
        minId = -1
        list.forEachIndexed { index, person ->
            if (person.habits.containsAll(individual.habits)) {
                println("another id: ${person.id} habits: ${person.habits}")
                if (minId == -1 || minId > person.id) {
                    minId = person.id
                    matchPerson = person
                }
            }
        }
        println("------------------------------------------------")
        return matchPerson
    }

    override fun matchReverse(
        individual: Individual,
        list: MutableList<Individual>
    ): Individual? {
        println("\nmatch reverse start")
        println("------------------------------------------------")
        println("person habits: ${individual.habits}")
        minId = -1
        val matchReverseList = matchReverse(list, individual)
        matchReverseList?.forEachIndexed { index, person ->
            if (minId == -1 || minId > person.id) {
                minId = person.id
                matchPerson = person
            }
        }
        println("------------------------------------------------")
        return matchPerson
    }


    private fun matchReverse(
        list: MutableList<Individual>,
        individual: Individual
    ): MutableList<Individual>? {
        for (i in 0 until individual.habits.size) {
            list.removeIf {
                it.habits.contains(individual.habits[i])
            }
        }
        list.forEach {
            println("matchReverse person: $it")
        }
        return list
    }
}