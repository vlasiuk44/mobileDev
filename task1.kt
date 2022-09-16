import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

fun main(args: Array<String>) {
    val file = File("roles.txt")
    var names = emptyArray<String>()
    var texts = emptyArray<String>()
    var flag: Boolean = false

    try { //чтение файла в два массива - имена и текст
        BufferedReader(FileReader(file)).use { br ->
            var line: String?
            while (br.readLine().also { line = it } != null) {
                if (line == "textLines:") {
                    flag = true
                }
                if (line != "roles:" && line != "textLines:") {
                    if (!flag) {
                        names += line.toString()
                    } else {
                        texts += line.toString()
                    }
                }
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }

    var test: Array<List<String>> = emptyArray() //разбить массив с текстом на имена и фразы
    for (i in texts.indices) {
        test += texts[i].split(":")

    }

    var result: Array<Pair<String, String>> = emptyArray() //созать отношение фраз к массиву всех имен
    for (i in texts.indices) {
        result += Pair(names.indexOf(test[i][0]).toString(), i.toString())
    }

    for(i in names.indices){ //привести к читаемому виду
        println(names[i]+":")
        for(j in test.indices){
            if(i==result[j].toList()[0].toInt()){
                println((j+1).toString()+")"+test[j][1])
            }
        }
        println()

    }
}