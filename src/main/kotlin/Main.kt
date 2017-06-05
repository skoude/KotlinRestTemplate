import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import entity.DataTest
import mu.KLogging
import spark.Request
import spark.Response
import spark.Spark
import utils.SystemParameters
import utils.SystemUtils


/**
 * Kotlin + spark micro framework some other small libraries to be
 * used as a small micro services templata
 */

/**
 * start the singleton RestService..
 * @author Kari Skyttä
 */
fun main(args: Array<String>) {
    RestService.main(args)
}


/**
 * Object RestService, means that we are creating a singleton.
 */
object RestService {

    // this is an example of reading some system parameters..
   val systemParam:SystemParameters? =   try {
         SystemUtils.readSystemParameters()
    }  catch (e: Exception) {
       null
    }


    /**
     * Contains main Routes for app.
     */
    fun main(args: Array<String>) {

        // Some Get -route examples
        Spark.get("/hello", { req, res -> "Hello World200" })

        // example of get method by using a function..
        Spark.get("/hellofunc", { req, res  -> testFun(req, res) })

        // convert object to json
        Spark.get("/tojson", { req, res  -> toJsonTest(req, res) } )

        // convert json to object
        Spark.get("/fromjson", { req, res  -> fromJsonTest(req, res) } )

        // Post example
        Spark.post("/testpost", { req, res -> testPost(req, res) })

        KLogging().logger.info { "the username is " + systemParam?.username }
        KLogging().logger.info { "Server is started" }

    }


    /**
     * Validate json, and store it to
     */
    private fun  fromJsonTest(request: Request, response: Response): String {
        val jsonString  = """{ "firstname":"Happy","lastname":"Gillmoure","streetAddress":"Bourbon streer 21A","postCode":"11111-23","country":"USA","email":"happygil@gil.com"}"""
        val dataObject : DataTest = jacksonObjectMapper().readValue(jsonString)
        return  dataObject.toString()
    }

    /**
     * Convert DataTest object to json string and return it.
     */
    private fun  toJsonTest(request: Request, response: Response): String {
        return jacksonObjectMapper().writeValueAsString(DataTest("Happy", "Gillmoure", "Bourbon streer 21A", "11111-23", "USA", "happygil@gil.com"))
    }


    /**
     * Convert EDN to formal json by using Jackson json converter
     *
     */
    fun testFun(request: Request, response: Response): String {


        KLogging().logger.info { "on testFun..." + request.ip() }
        return "Hello dude.."

    }


    /**
     * Returns the request body..
     */
    private fun testPost(request: spark.Request, response: spark.Response): String {

        return request.body().toString()
    }
}
