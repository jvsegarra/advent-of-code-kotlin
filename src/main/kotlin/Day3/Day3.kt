package Day3

import Day
import Helper.ReturnsAnswer

class Day3 : Day(), ReturnsAnswer {
    override fun getAnswer(): String {
        var currentPosition = Pair(0, 0)
        val visitedHouses = hashSetOf(currentPosition)

        input.forEach {
            var newPosition = currentPosition.copy()

            when (it) {
                '^' -> newPosition = Pair(currentPosition.first, currentPosition.second + 1)
                'v' -> newPosition = Pair(currentPosition.first, currentPosition.second - 1)
                '<' -> newPosition = Pair(currentPosition.first - 1, currentPosition.second)
                '>' -> newPosition = Pair(currentPosition.first + 1, currentPosition.second)
            }
            
            currentPosition = newPosition
            visitedHouses += currentPosition
        }

        return visitedHouses.size.toString()
    }
}
