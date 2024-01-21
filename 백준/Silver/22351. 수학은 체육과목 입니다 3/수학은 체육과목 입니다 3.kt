import java.util.*

fun process(input:String) {
    for (i in 1..3) {
        var str = input.substring(0 until i)
        var a = str.toInt()
		var n = str
        
        while (n.length < input.length) {
            a += 1
            n += a.toString()
        }

        if (n == input) {
            print("$str $a")
            break
        }
    }
}

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
	var input = nextLine()
	process(input)
}