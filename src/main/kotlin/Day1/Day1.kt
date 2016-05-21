package Day1

import Day
import Helper.ReturnsAnswer

class Day1 : Day(), ReturnsAnswer {

    override fun getAnswer(): String {
        return calculateFloor(input).toString()
    }

    private fun calculateFloor(input: String): Int {
        var floor: Int = 0

        input.forEach {
            when (it) {
                '(' -> floor++
                ')' -> floor--
            }
        }

        return floor
    }
}