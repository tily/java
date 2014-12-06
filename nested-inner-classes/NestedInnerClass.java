class NestedInnerClass {
	static class ClassA {
		static class ClassB {
			static class ClassC {
			}
		}
	}
	public static void main(String[] args) {
		ClassA.ClassB.ClassC abc = new ClassA.ClassB.ClassC();
		System.out.println(abc); // NestedInnerClass$ClassA$ClassB$ClassC@5e8fce95
	}
}
