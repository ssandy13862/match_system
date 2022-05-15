import type.DistanceBased
import type.HabitBased

fun main(args: Array<String>) {

    val matchSystem = MatchSystem(DistanceBased())

    val person = Individual(
        id = 1,
        gender = Gender.values()[0],
        age = 18 + (Math.random() * 30).toInt(),
        intro = "我是 1 號，你好".toCharArray(),
        habits = mutableListOf(Habit.CODING, Habit.SWIM, Habit.FISHING),
        coord = Coord(1, 1)
    )

    val matchResult = matchSystem.match(person)
    val matchReverseResult = matchSystem.matchReverse(person)

    print("\nresult")
    print(" \n------------------------------------------------\n")
    println("person: $person")
    println("matchResult: $matchResult")
    println("matchReverseResult: $matchReverseResult")
}