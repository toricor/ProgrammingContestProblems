fun main(args: Array<String>) {
    val (X, t) = readLine()!!.split(' ').map {it.toInt()}
    println(Math.max(X-t, 0))
}
