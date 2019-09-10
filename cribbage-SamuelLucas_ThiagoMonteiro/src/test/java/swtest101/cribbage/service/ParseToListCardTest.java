package swtest101.cribbage.service;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import swtest101.cribbage.entity.Card;
import swtest101.cribbage.entity.Suit;

//@RunWith(Parameterized.class)
public class ParseToListCardTest {

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
	private final List<Card> expectedListOfCards = new ArrayList<Card>();

	@Test
	public void testParseToListOfCard_ArrayLengthEqualsWithCardArrayLength() {

		input = "AC2H8SKCAD";
		final List<String> listOfString = ParseStringService.parseToListOfStrings(input);
		
		List<Card> resultListOfCards = ParseStringService.parseToListOfCards(listOfString);
		
		assertThat(resultListOfCards.size(), is(equalTo(5)));

	}

	
	@Test
	public void testParseToListOfCard_StringArrayOrdenedEqualsWithCardArray() {

		input = "AC2H8SKCAD";
		final List<String> listOfString = ParseStringService.parseToListOfStrings(input);

		expectedListOfCards.add( new Card(1, Suit.CLUBS) );
		expectedListOfCards.add( new Card(2, Suit.HEARTS) );
		expectedListOfCards.add( new Card(8, Suit.SPADES) );
		expectedListOfCards.add( new Card(13, Suit.CLUBS) );
		expectedListOfCards.add( new Card(1, Suit.DIAMONDS) );
		
		List<Card> resultListOfCards = ParseStringService.parseToListOfCards(listOfString);
		
		for( int i=0; i<resultListOfCards.size(); ++i) {
			assertThat(expectedListOfCards.get(i), is(equalTo(resultListOfCards.get(i))));			
		}
		
	}

	

}
