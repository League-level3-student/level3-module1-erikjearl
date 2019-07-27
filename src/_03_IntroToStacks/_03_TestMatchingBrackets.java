package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		char[] arr = b.toCharArray();
		Stack<String> stck = new Stack<String>();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == '{') {
				stck.push("a");
			}
			if(arr[i] == '}' && stck.size() > 0) {
				stck.pop();
			}
		}
		if(stck.size() == 0)
			return true;
		return false;
	}

}