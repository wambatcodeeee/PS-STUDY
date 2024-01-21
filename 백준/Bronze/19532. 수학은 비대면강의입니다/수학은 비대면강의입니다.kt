import java.util.*

fun process(a:Int,b:Int,c:Int,d:Int,e:Int,f:Int){
	for(x in -999..999){
        for(y in -999..999){
            if((a*x) + (b*y) == c){
                if((d*x) + (e*y) == f){
                    var strX = x.toString()
                    var strY = y.toString()
                    print("$strX $strY")
                }
            }
        }
    }
}

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
	var a = nextInt()
	var b = nextInt()
	var c = nextInt()
	var d = nextInt()
	var e = nextInt()
	var f = nextInt()
	process(a,b,c,d,e,f)
}
