package Day6

import Day
import Helper.ReturnsAnswer

class Day6 : Day(), ReturnsAnswer {
    override fun getAnswer(): String {
        val lights = Array(1000) { BooleanArray(1000) }

        this.input.split("\n").forEach {
            val indexOfFirstNumber = it.indexOfFirst { it.isDigit() }

            val actionToPerform = it.substring(0, indexOfFirstNumber - 1)

            val coordinates = it.substring(indexOfFirstNumber).split(" through ")
            val coordinatesOrigin = coordinates[0].split(",").map { it.toInt() }
            val coordinatesEnd = coordinates[1].split(",").map { it.toInt() }

            for (x in coordinatesOrigin[0]..coordinatesEnd[0]) {
                for (y in coordinatesOrigin[1]..coordinatesEnd[1]) {
                    when (actionToPerform) {
                        "toggle" -> lights.toggle(x, y)
                        "turn on" -> lights.turnOn(x, y)
                        "turn off" -> lights.turnOff(x, y)
                    }
                }
            }
        }

        return "someday i'll loop through the matrix and count the lights"
    }

    private fun Array<BooleanArray>.turnOn(x: Int, y: Int) {
        this[x][y] = true
    }

    private fun Array<BooleanArray>.turnOff(x: Int, y: Int) {
        this[x][y] = false
    }

    private fun Array<BooleanArray>.toggle(x: Int, y: Int) {
        this[x][y] = !this[x][y]
    }

    private fun Array<IntArray>.turnOn(x: Int, y: Int) {
        this[x][y] += 1
    }

    private fun Array<IntArray>.turnOff(x: Int, y: Int) {
        this[x][y] = Math.max(0, this[x][y] - 1)
    }

    private fun Array<IntArray>.toggle(x: Int, y: Int) {
        this[x][y] += 2
    }

}
