import java.lang.Integer.min

fun main() {
    val text1 = "banana"
    val text2 = "aaa"
    val text3 = "bananabababananababbanana"
    val text4 = "banana"
    println(myFun(text1))
    println(myFun(text2))
    println(myFun(text3))
    println(myFun(text4))
}

fun myFun(text: String): Int {
    val countb: Int = text.length - text.replace("b", "").length
    val counta: Int = (text.length - text.replace("a", "").length) / 3
    val countn: Int = (text.length - text.replace("n", "").length) / 2
    var total = min(counta, countb)
    total = min(total, countn)
    return total
}
