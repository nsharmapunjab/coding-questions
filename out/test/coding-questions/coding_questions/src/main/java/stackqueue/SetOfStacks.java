package stackqueue;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {

	ArrayList<Stack> stacks = new ArrayList<Stack>();
	int capacity = 5;

	public Stack<Integer> getLastStack() {

		if (stacks.size() == 0) {
			return null;
		} else {
			return stacks.get(stacks.size() - 1);
		}
	}

	public void push(int v) {

		Stack<Integer> last = getLastStack();
		if (last != null && !isAtCapacity(last)) {
			last.push(v);
		} else {
			Stack<Integer> s = new Stack<Integer>();
			s.push(v);
			stacks.add(s);
		}
	}

	public Integer pop() {

		Stack<Integer> last = getLastStack();
		if (last != null) {
			int v = last.pop();
			if (last.size() == 0) {
				stacks.remove(stacks.size() - 1);
			}
			return v;
		} else {
			return null;
		}
	}

	public boolean isAtCapacity(Stack s) {
		return s.size() == capacity;
	}

}
