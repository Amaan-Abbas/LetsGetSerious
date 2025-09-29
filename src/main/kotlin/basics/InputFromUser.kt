package basics

//fun main() {
//
//    //use readln() which returns a string but returns an error when reaches the end of the function.
//    //use null checker for it returns a nullable string (String?) which needs to be handled using null safety or not null operator (!!)
//    val input = readln().toIntOrNull()
//
//    if (input == null) {
//        println("It is null!")
//    }
//
//    println(input)
//
//}


//the function bellow describes how the readlnOrNull returns the null value when the code is in execution.
fun main() {
    println("Enter lines (press Ctrl+D or Ctrl+Z to end):")

    while (true) {
        val input = readlnOrNull()
        if (input == null) {
            println("End of input reached (null returned).")
            break
        } else {
            println("You entered: $input")
        }
    }
}