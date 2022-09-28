fun main() {
    var range = readLine()!!.toInt() //необязательное поле
    val arrayStr: String? = readLine()

    val str = arrayStr!!.split(' ')
    val str2 = str.toMutableList()

    for (i in 1 until str.size-1) {
        str2[i] = ((str[i].toDouble() +str[i-1].toDouble() + str[i+1].toDouble())/3).toString()
    }
    print(str2)
}
