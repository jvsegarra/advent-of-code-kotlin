package Day4

import Day
import Helper.ReturnsAnswer
import java.security.MessageDigest

class Day4 : Day(), ReturnsAnswer {
    override fun getAnswer(): String {
        val md = MessageDigest.getInstance("MD5")
        var i = 0

        while (true) {
            md.update((this.input + i).toByteArray())
            val hashBytes = md.digest()

            if (
                hashBytes[0].toString().equals("0") &&
                hashBytes[1].toString().equals("0") &&
                hashBytes[2].toString().equals("0") &&
                hashBytes[3].toString().equals("0") &&
                hashBytes[4].toString().equals("0")
            ) {
                return i.toString()
            }

            i++
        }
    }
}