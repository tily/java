import scala.io.Source

def getWidth(s: String) :Int = s.length.toString.length

def main(args: Array[String]) =
	if(args.length > 0) {
		val lines = Source.fromFile(args(0)).getLines().toList
		val width = lines.reduceLeft((a, b) =>
			if(a.length > b.length) { a } else { b }
		)
		val lineWidth = getWidth(width.toString)
		for(line <- lines) {
			val numSpaces = lineWidth - getWidth(line)
			val spaces = " " * numSpaces
			println(spaces + line.length + " | " + line)
		}
	} else {
		Console.err.println("Error: please specify filename")
	}

main(args)
