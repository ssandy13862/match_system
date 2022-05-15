package type

import Individual

interface MatchType {
    fun match(individual: Individual, list: MutableList<Individual>): Individual?
    fun matchReverse(individual: Individual, list: MutableList<Individual>): Individual?
}