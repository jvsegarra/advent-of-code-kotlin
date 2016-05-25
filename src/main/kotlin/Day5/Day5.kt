package Day5

import Day
import Helper.ReturnsAnswer

class Day5 : Day(), ReturnsAnswer {
    val forbiddenSubstrings = arrayOf("ab", "cd", "pq", "xy")

    override fun getAnswer(): String {
        val numberOfNiceStrings = this.input.split("\n").count {
            it.isNiceString()
        }

        return numberOfNiceStrings.toString()
    }

    fun String.isNiceString(): Boolean {
        return !containsForbiddenStrings(this) && itHasALetterThatAppearsTwice(this) && containsThreeVowels(this)
    }

    private fun containsForbiddenStrings(string: String): Boolean {
        return forbiddenSubstrings.any { string.contains(it) }
    }

    private fun itHasALetterThatAppearsTwice(string: String): Boolean {
        for ((index, value) in string.withIndex()) {
            if (index == string.length - 1) return false
            if (value == string[index + 1]) return true
        }

        return false
    }

    private fun containsThreeVowels(string: String): Boolean {
        return string.count { it in "aeiou" } >= 3
    }
}
