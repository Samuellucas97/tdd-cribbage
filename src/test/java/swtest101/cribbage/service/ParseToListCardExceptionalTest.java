package swtest101.cribbage.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import swtest101.cribbage.exception.InputParseException;

//@RunWith(Parameterized.class)
public class ParseToListCardExceptionalTest {

	/*
	 * @Parameters(name = "{0}_ShouldReturn_{1}-{2}") public static
	 * Collection<Object[]> buildData() {
	 * 
	 * return Arrays.asList(new Object[][] { // { "AC2H8SKCAD", Arrays.asList() },
	 * // { "7C", Arrays.asList() }, // { "0D", Arrays.asList() }, // { "JH",
	 * Arrays.asList() }, // { "QS", Arrays.asList() }, // { "KC", Arrays.asList()
	 * },// }); }
	 * 
	 * @Parameter(0) public String input;
	 * 
	 * @Parameter(1) public Arrays expectedListOfCards;
	 */

	private String input;
	private final List<String> expectedListOfCards = new ArrayList<String>();

	@Test(expected = InputParseException.class)
	public void testParseToListCard_ArrayLengthEquals5() {

		input = "AC2H8SKCA";
		ParseStringService.parseToListOfStrings(input);

	}

}
