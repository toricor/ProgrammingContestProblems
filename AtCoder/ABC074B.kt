fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val k = readLine()!!.toInt()
    val arr = readLine()!!.split(' ').map{it.toInt()}
    var ans = 0
    for (i in (0..n - 1)) {
        val adist = arr[i] * 2
        val bdist = (k - arr[i]) * 2
        ans += if (adist < bdist) adist else bdist
    }
    println(ans)
}
