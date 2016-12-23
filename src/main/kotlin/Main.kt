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
        // Read the parameters from the config.json.

        // Some Get -route examples
        Spark.get("/hello", { req, res -> "Hello World200" })

        // example of get method by using a function..
        Spark.get("/hellofunc", { req, res  -> testFun(req, res) })


        // Post example
        Spark.post("/testpost", { req, res -> testPost(req, res) })


        KLogging().logger.info { "the username is " + systemParam?.username }
        KLogging().logger.info { "Server is started" }

    }


    /**
     * Convert EDN to formal json by using Jackson json converter
     *
     */
    fun testFun(request: Request, response: Response): String {

        KLogging().logger.info { "on tesFun..." + request.ip() }
        return "Hello World from function.... "
    }


    /**
     * Returns the request body..
     */
    private fun testPost(request: spark.Request, response: spark.Response): String {

        return request.body().toString()
    }
}
