fun main() {
    val count = readLine()!!.toInt()

    for(k in 1..count){
        val str = readLine()
        val strSplit = str!!.split(" ")
        val n = strSplit[0].toInt()
        val m = strSplit[1].toInt()
        var i = 0
        var j = 0
        val arr = Array(n) { Array(m) { 0 } }
        arr[0][0] = n * m

        for (number in n * m downTo 1) {
            arr[i][j] = number
            if ((j == 0) or (i == n - 1)) {
                if (j == 0) {
                    if (i + 1 < m) {
                        j += i + 1
                        i = 0
                    } else {
                        i = i - m + 2
                        j = m - 1
                    }
                } else {
                    if (i == n - 1) {
                        i = j + n - m + 1
                        j = m - 1
                    }
                }
            } else {
                i += 1
                j -= 1
            }
        }

        for (a in arr) {
            for (b in a) {
                if (b / 10 == 0) print("0")
                print("$b ")
            }
            println()
        }
    }
}