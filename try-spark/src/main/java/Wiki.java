import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class Wiki {
	public static class Page {
		public String name;

		public Page(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public static void main(String[] args) {
		get("/", (req, res) -> {
			return "Hello World";
		});

		get("/:PageName", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			model.put("hello", "Velocity World");
			model.put("page", new Page("Foobar"));
			return new ModelAndView(model, "hello.wm");
		}, new VelocityTemplateEngine());

		get("/new", (req, res) -> {
			return "Hello World";
		});

		get("/:PageName/edit", (req, res) -> {
			return "Hello World";
		});

		post("/", (req, res) -> {
			return "Hello World";
		});

		put("/:PageName", (req, res) -> {
			return "Hello World";
		});

		delete("/:PageName", (req, res) -> {
			return "Hello World";
		});
	}
}
