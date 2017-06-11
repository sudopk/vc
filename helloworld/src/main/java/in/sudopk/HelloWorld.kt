package `in`.sudopk

import java.util.*

fun main(args: Array<String>) {
    println("Hello Sonia")

    testLambdaWithReceiver {
        println("###########################")
        println(request::class)
        println(response::class)
    }

    println(String.newObject())

    Singer.sing()
    Singer.sing()

}

fun testLambdaWithReceiver(func: RequestHandler.() -> Unit) {
    val requestHandler: RequestHandler = RequestHandler(Request(), Response())

    requestHandler.func()


    val sb = StringBuilder()
    with(sb) {
        sb.length
        return@with sb
    }.length
}


fun String.Companion.newObject(): String {
    return "adsfjsdf"
}

object Singer {
    fun sing() {
        println(this)
    }
}

class Request
class Response

class RequestHandler(val request: Request, val response: Response)
