data class Individual(
    var id: Int,
    var gender: Gender,
    var age: Int,
    var intro: CharArray,
    var habits: MutableList<Habit>,
    var coord: Coord
)

data class Coord(
    var x: Int,
    var y: Int
)

enum class Gender {
    MALE,
    FEMALE
}

enum class Habit(val value: Int) {
    SING(0),
    DANCE(1),
    SHOPPING(2),
    HIKING(3),
    SWIM(4),
    FISHING(5),
    CODING(6),
    DRAWING(7)
}
