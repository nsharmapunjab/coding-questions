package stackqueue;

import java.util.Stack;

public class AscendingOrderStack {

	Stack<Integer> s;

	public AscendingOrderStack() {

		s = new Stack<Integer>();
	}

	public Stack<Integer> sortStack(Stack<Integer> s) {

		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()) {
			int tmp = s.pop();
			while (!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}

		return r;
	}
}
