package random;

import java.lang.reflect.Method;

public class Reflection {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		try {
			Class c = Class.forName("sorting.MergeTwoArrays");
			Method[] m = c.getDeclaredMethods();
			for (int i = 0; i < m.length; i++) {
				System.out.println("Method Name : " + m[i].toString());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
