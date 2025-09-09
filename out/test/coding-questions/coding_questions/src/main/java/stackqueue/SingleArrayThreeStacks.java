package stackqueue;

public class SingleArrayThreeStacks {

	int stackSize = 300;
	int[] buffer = new int[stackSize * 3];
	int[] stackPointer = { -1, -1, -1 };

	void push(int stackNum, int item) {

		int index = stackNum * stackSize + stackPointer[stackNum] + 1;
		buffer[index] = item;
		stackPointer[stackNum]++;
	}

	int pop(int stackNum) {

		int index = stackNum * stackSize + stackPointer[stackNum];
		stackPointer[stackNum]--;
		int value = buffer[index];
		buffer[index] = 0;
		return value;
	}

	int peek(int stackNum) {

		int index = stackNum * stackSize + stackPointer[stackNum];
		return buffer[index];
	}

	boolean isEmpty(int stackNum) {

		return stackNum * stackSize + stackPointer[stackNum] == stackNum * stackSize;
//		return stackPointer[stackNum] == -1;
	}

}
