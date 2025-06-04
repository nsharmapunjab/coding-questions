package random;

public class StaticClassAccess {

	public static void main(String[] args) {

		// nested static class doesn't need instantiation of the outer class

		StaticClassAccess.NestedStaticClass nestedStatic = new StaticClassAccess.NestedStaticClass();

		nestedStatic.printMethodNestedStatic();
		
		// inner class needs instantiation of the outer class

		StaticClassAccess outer = new StaticClassAccess();

		StaticClassAccess.InnerClass inner = outer.new InnerClass();

		inner.printMethodInner();

	}

	// Static nested class

	public static class NestedStaticClass {

		public void printMethodNestedStatic() {

			System.out.println("Method of nested static class");

		}

	}

	// inner (non-static nested) class

	public class InnerClass {

		public void printMethodInner() {

			System.out.println("Method of inner(non-static nested) class");

		}

	}

}
