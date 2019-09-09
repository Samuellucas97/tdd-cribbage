package swtest101.cribbage.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

//@RunWith(Parameterized.class)
public class ParseToListStringTest {

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

	@Test
	public void testParseToCard_ArrayLengthEquals5() {

		input = "AC2H8SKCAD";

		expectedListOfCards.add("AC");
		expectedListOfCards.add("2H");
		expectedListOfCards.add("8S");
		expectedListOfCards.add("KC");
		expectedListOfCards.add("AD");

		final List<String> listOfCards = ParseStringService.parseToListOfStrings(input);

		assertThat(listOfCards.size(), is(equalTo(5)));

	}

	@Test
	public void testParseToCard_StringSameElementsAsArray() {

		input = "AC2H8SKCAD";

		expectedListOfCards.add("AC");
		expectedListOfCards.add("2H");
		expectedListOfCards.add("8S");
		expectedListOfCards.add("KC");
		expectedListOfCards.add("AD");

		final List<String> listOfCards = ParseStringService.parseToListOfStrings(input);

		for (int i = 0; i < expectedListOfCards.size(); ++i) {
			assertThat(listOfCards.get(i), is(equalTo(expectedListOfCards.get(i))));
		}

	}

}
