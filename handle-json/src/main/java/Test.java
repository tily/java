import net.arnx.jsonic.JSON;

class Test {
	public static void main(String[] args) {
		class Pojo {
			public String hoge;

			/**
			 * @return the hoge
			 */
			public String getHoge() {
				return hoge;
			}

			/**
			 * @param hoge the hoge to set
			 */
			public void setHoge(String hoge) {
				this.hoge = hoge;
			}
		}
		Pojo pojo = new Pojo();
		pojo.setHoge("hello json");
		String json = JSON.encode(pojo);
		System.out.println(json);
	}
}
