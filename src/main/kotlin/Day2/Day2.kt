package Day2

import Day
import Helper.ReturnsAnswer

class Day2 : Day(), ReturnsAnswer {

    data class BoxDimensions(val length: Int, val width: Int, val height: Int) {
        fun getSquareFeet(): Int {
            val side1 = 2 * length * width
            val side2 = 2 * width * height
            val side3 = 2 * height * length

            val areaOfTheSmallestSide = listOf(side1, side2, side3).min()!! / 2

            return side1 + side2 + side3 + areaOfTheSmallestSide
        }
    }

    override fun getAnswer(): String {
        val dimensions = getDimensions(input)
        return dimensions.map { it.getSquareFeet() }.sum().toString()
    }

    private fun getDimensions(input: String): List<BoxDimensions> {
        return input.split("\n").filterNot { it.isEmpty() }.map { mapToDimension(it) }
    }

    private fun mapToDimension(stringDimension: String) : BoxDimensions {
        val arrayIntDimension = stringDimension.split("x").map { it.toInt() }
        return BoxDimensions(arrayIntDimension[0],arrayIntDimension[2], arrayIntDimension[2])
    }
}
