package utils

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File


/**
 * Object that reads the configuration from /src/main/resources/config.json.
 * Note: On kotlin, if you want a static class, there is no such thing. Instead, just
 * create object instead of class. Then you can call it like static Java class in Java..
 *
 */

object SystemUtils {
    /**
     * Read the utils.SystemParameters from src/main/resources/config.json by using fasterXml
     */
    fun readSystemParameters(): SystemParameters {
        // read the utils.SystemParameters by using FasterXML from config.json.
        val JSON = jacksonObjectMapper()
        val myList: List<SystemParameters> = JSON.readValue(File("src/main/resources/config.json").readText(charset = Charsets.UTF_8))
        return myList[0]  // Return the first object..
    }


    fun file2String(fileName: String ) : String {
        return File(fileName).readText(charset = Charsets.UTF_8)
    }

}