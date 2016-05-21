package Helper

import java.io.File

object TextFileReader {
    fun getFileContent(day: String): String = File("src/main/kotlin/$day/Resources/input").readText()
}