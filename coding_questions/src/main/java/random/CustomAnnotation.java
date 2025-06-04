package random;

import random.CustomTesterInfo.Priority;

@CustomTesterInfo(priority = Priority.HIGH, createdBy = "mkyong.com", tags = {
		"sales", "test" })
public class CustomAnnotation {

	@CustomTest
	void testA() {
		if (true)
			throw new RuntimeException("This test always failed");
	}

	@CustomTest(enabled = false)
	void testB() {
		if (false)
			throw new RuntimeException("This test always passed");
	}

	@CustomTest(enabled = true)
	void testC() {
		if (10 > 1) {
			// do nothing, this test always passed.
		}
	}

}
