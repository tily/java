import static spark.Spark.*;

public class TrySpark {
	public static void main(String[] args) {
		get("/hello", (req, res) -> "Hello World");
	}
}
