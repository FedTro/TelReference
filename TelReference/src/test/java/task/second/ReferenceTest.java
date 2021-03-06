package task.second;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * <h1>Test-driven development testing<h1>
 * 
 * @author Fedor
 *
 */

public class ReferenceTest {

	private static Reference ref;

	@BeforeClass
	public static void init() {
		ref = new Reference();
	}

	@Test
	public void printNumbersTestCorrect1() {
		String user = "Иванов И.И.";
		int shownNumbers = ref.showNumbers(user);
		assertEquals(2, shownNumbers);

	}

	@Test
	public void printNumbersTestCorrect2() {
		String user = "Сидоров С.С.";
		int shownNumbers = ref.showNumbers(user);
		assertEquals(3, shownNumbers);

	}

	@Test
	public void printNumbersTestCorrect3() {
		String user = "Петров П.П.";
		int shownNumbers = ref.showNumbers(user);
		assertEquals(1, shownNumbers);

	}

	@Test
	public void printNumbersTestMissed() {
		String user = "Никитин В.В.";
		int shownNumbers = ref.showNumbers(user);
		assertEquals(0, shownNumbers);

	}

	@Test
	public void checkFormatTestCorrect() {
		String user = "Иванов Н.Н.";
		boolean isValid = ref.checkName(user);
		assertEquals(true, isValid);
	}

	@Test
	public void checkFormatTestIncorrect() {
		String user = "Иванов Н.";
		boolean isValid = ref.checkName(user);
		assertEquals(false, isValid);

	}

}
