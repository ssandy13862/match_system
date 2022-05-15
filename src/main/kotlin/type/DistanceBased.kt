package type

import Individual
import kotlin.math.pow
import kotlin.math.sqrt

class DistanceBased : MatchType {

    private var minId = -1
    private var minDistance = -1
    private var maxDistance = -1
    private var matchPerson: Individual? = null

    override fun match(
        individual: Individual,
        list: MutableList<Individual>
    ): Individual? {
        println("\nmatch start")
        println("------------------------------------------------")
        minId = -1
        minDistance = -1
        list.forEachIndexed { index, person ->
            val distance = getDistance(person, individual)
            println("person id: ${person.id} distance: $distance")
            if (minDistance == -1 || minDistance > distance) {
                minDistance = distance
                matchPerson = person
            } else if (minDistance == distance) {
                if (matchPerson?.id ?: -1 > person.id) {
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
        list.forEachIndexed { index, person ->
            val distance = getDistance(person, individual)
//            println("person id: ${person.id} distance: $distance")
            if (maxDistance == -1 || maxDistance < distance) {
                maxDistance = distance
                matchPerson = person
            } else if (minDistance == distance) {
                if (matchPerson?.id ?: -1 > person.id) {
                    matchPerson = person
                }
            }
        }
//        println("------------------------------------------------")
        return matchPerson
    }

    private fun getDistance(own: Individual, another: Individual): Int {
        val xDistance = (own.coord.x - another.coord.x).toDouble().pow(2.0)
        val yDistance = (own.coord.y - another.coord.y).toDouble().pow(2.0)
        return sqrt(xDistance + yDistance).toInt()
    }
}