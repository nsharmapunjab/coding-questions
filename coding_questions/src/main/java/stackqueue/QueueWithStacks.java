package stackqueue;

import java.util.Stack;

public class QueueWithStacks {

	Stack<Integer> s1;
	Stack<Integer> s2;

	public QueueWithStacks() {

		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}

	public int size() {

		return s1.size() + s2.size();
	}

	public void add(int v) {

		s1.push(v);
	}

	public Integer peek() {

		if (!s2.isEmpty()) {
			return s2.peek();
		}
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		return s2.peek();
	}

	public Integer remove() {

		if (!s2.isEmpty()) {
			return s2.pop();
		}
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		return s2.pop();
	}

}
