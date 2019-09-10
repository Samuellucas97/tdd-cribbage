package swtest101.cribbage.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import swtest101.cribbage.entity.Card;

public class ScoringServiceTest {

	@Test
	@Ignore
	public void test() {
		final String handOfCards = "JH5D5S5C5H";
		final Integer score = ScoringService.calculateScore(handOfCards);

		assertThat(score, is(equalTo(29)));
	}

	@Test
	public void testRulePairOfCards_2Points_AreSequence() {
		final String handOfCards = "JH5D5SKCAH";
		
		// QUEBRANDO A STRING EM UMA LISTA DE STRINGS
		List<String> listOfStrings = ParseStringService.parseToListOfStrings(handOfCards);
		
		// CONVERTENDO A LISTA DE STRINGS EM UMA LISTA DE CARTAS
		List<Card> listOfCards= ParseStringService.parseToListOfCards(listOfStrings);
		
		final Integer score = ScoringService.rulePairOfCards_2Points(0, listOfCards);
		
		assertThat(score, is(equalTo(2)));
	}
	
	@Test
	public void testRulePairOfCards_2Points_DontAreSequence() {
		
		final String handOfCards = "JH5DASKC5H";
		
		// QUEBRANDO A STRING EM UMA LISTA DE STRINGS
		List<String> listOfStrings = ParseStringService.parseToListOfStrings(handOfCards);
		
		// CONVERTENDO A LISTA DE STRINGS EM UMA LISTA DE CARTAS
		List<Card> listOfCards= ParseStringService.parseToListOfCards(listOfStrings);
		
		final Integer score = ScoringService.rulePairOfCards_2Points(0, listOfCards);
		
		assertThat(score, is(equalTo(2)));

	}
		
	@Test
	public void testRuleStraightOfThreeCardsOrMore_1PointPerCard_3Cards() {
		final String handOfCards = "JH5D6S7CAH";
		// QUEBRANDO A STRING EM UMA LISTA DE STRINGS
		List<String> listOfStrings = ParseStringService.parseToListOfStrings(handOfCards);
			
		// CONVERTENDO A LISTA DE STRINGS EM UMA LISTA DE CARTAS
		List<Card> listOfCards= ParseStringService.parseToListOfCards(listOfStrings);
				
		final Integer score = ScoringService.ruleStraightOfThreeCardsOrMore_1PointPerCard(0, listOfCards);
				
		assertThat(score, is(equalTo(3)));
	}
	
	@Test
	public void testRuleStraightOfThreeCardsOrMore_1PointPerCard_Twice3Cards() {
		final String handOfCards = "JH5D6S7C5H";
		// QUEBRANDO A STRING EM UMA LISTA DE STRINGS
		List<String> listOfStrings = ParseStringService.parseToListOfStrings(handOfCards);
			
		// CONVERTENDO A LISTA DE STRINGS EM UMA LISTA DE CARTAS
		List<Card> listOfCards= ParseStringService.parseToListOfCards(listOfStrings);
				
		final Integer score = ScoringService.ruleStraightOfThreeCardsOrMore_1PointPerCard(0, listOfCards);
				
		assertThat(score, is(equalTo(6)));
	}	
	@Test
	public void testRuleStraightOfThreeCardsOrMore_1PointPerCard_4Cards() {
		final String handOfCards = "4H5DAS7C6H";

		// QUEBRANDO A STRING EM UMA LISTA DE STRINGS
		List<String> listOfStrings = ParseStringService.parseToListOfStrings(handOfCards);
		
		// CONVERTENDO A LISTA DE STRINGS EM UMA LISTA DE CARTAS
		List<Card> listOfCards= ParseStringService.parseToListOfCards(listOfStrings);
		
		final Integer score = ScoringService.ruleStraightOfThreeCardsOrMore_1PointPerCard(0, listOfCards);
		
		assertThat(score, is(equalTo(4)));
	}
			
	@Test
	public void testRuleStraightOfThreeCardsOrMore_1PointPerCard_5Cards() {
		final String handOfCards = "3H5D6S7C4H";

		// QUEBRANDO A STRING EM UMA LISTA DE STRINGS
		List<String> listOfStrings = ParseStringService.parseToListOfStrings(handOfCards);
		
		// CONVERTENDO A LISTA DE STRINGS EM UMA LISTA DE CARTAS
		List<Card> listOfCards= ParseStringService.parseToListOfCards(listOfStrings);
		
		final Integer score = ScoringService.ruleStraightOfThreeCardsOrMore_1PointPerCard(0, listOfCards);

		assertThat(score, is(equalTo(5)));
	}
	
	@Test
	public void testRule4CardFlushExcludingStarterCard_4Points() {
		final String handOfCards = "3H5D6D7D4D";

		// QUEBRANDO A STRING EM UMA LISTA DE STRINGS
		List<String> listOfStrings = ParseStringService.parseToListOfStrings(handOfCards);
		
		// CONVERTENDO A LISTA DE STRINGS EM UMA LISTA DE CARTAS
		List<Card> listOfCards= ParseStringService.parseToListOfCards(listOfStrings);
		
		final Integer score = ScoringService.rule4CardFlushExcludingStarterCard_4Points(0, listOfCards);

		assertThat(score, is(equalTo(4)));
	}	
	
	@Test
	public void testRule5CardFlushIncludingStarterCard_5Points() {
		final String handOfCards = "3D5D6D7D4D";

		// QUEBRANDO A STRING EM UMA LISTA DE STRINGS
		List<String> listOfStrings = ParseStringService.parseToListOfStrings(handOfCards);
		
		// CONVERTENDO A LISTA DE STRINGS EM UMA LISTA DE CARTAS
		List<Card> listOfCards= ParseStringService.parseToListOfCards(listOfStrings);
		
		final Integer score = ScoringService.rule5CardFlushIncludingStarterCard_5Points(0, listOfCards);

		assertThat(score, is(equalTo(5)));
	}	
	
	@Test
	public void testRuleJackInTheHandWhoseSuitMatchesTheStarterCardSuit_1Point() {
		final String handOfCards = "JH8D2S2C2H";

		// QUEBRANDO A STRING EM UMA LISTA DE STRINGS
		List<String> listOfStrings = ParseStringService.parseToListOfStrings(handOfCards);
		
		// CONVERTENDO A LISTA DE STRINGS EM UMA LISTA DE CARTAS
		List<Card> listOfCards= ParseStringService.parseToListOfCards(listOfStrings);
		
		final Integer score = ScoringService.ruleJackInTheHandWhoseSuitMatchesTheStarterCardSuit_1Point(0, listOfCards);

		assertThat(score, is(equalTo(1)));
	}
	
	
	@Test
	public void testRuleCardValuesThatAddUpTo15_2Points_5Length() {
		final String handOfCards = "AH8D2S2C2H";

		// QUEBRANDO A STRING EM UMA LISTA DE STRINGS
		List<String> listOfStrings = ParseStringService.parseToListOfStrings(handOfCards);
		
		// CONVERTENDO A LISTA DE STRINGS EM UMA LISTA DE CARTAS
		List<Card> listOfCards= ParseStringService.parseToListOfCards(listOfStrings);
		
		final Integer score = ScoringService.ruleCardValuesThatAddUpTo15_2Points_5Length(0, listOfCards);

		assertThat(score, is(equalTo(2)));
	}

	@Test
	public void testRuleCardValuesThatAddUpTo15_2Points_4Length() {
		final String handOfCards = "3H8D2S2C3H";

		// QUEBRANDO A STRING EM UMA LISTA DE STRINGS
		List<String> listOfStrings = ParseStringService.parseToListOfStrings(handOfCards);
		
		// CONVERTENDO A LISTA DE STRINGS EM UMA LISTA DE CARTAS
		List<Card> listOfCards= ParseStringService.parseToListOfCards(listOfStrings);
		
		final Integer score = ScoringService.ruleCardValuesThatAddUpTo15_2Points_4Length(0, listOfCards);

		assertThat(score, is(equalTo(4)));
	}

	@Test
	public void testRuleCardValuesThatAddUpTo15_2Points_3Length() {
		final String handOfCards = "AH9D5SACAH";

		// QUEBRANDO A STRING EM UMA LISTA DE STRINGS
		List<String> listOfStrings = ParseStringService.parseToListOfStrings(handOfCards);
		
		// CONVERTENDO A LISTA DE STRINGS EM UMA LISTA DE CARTAS
		List<Card> listOfCards= ParseStringService.parseToListOfCards(listOfStrings);
		
		final Integer score = ScoringService.ruleCardValuesThatAddUpTo15_2Points_3Length(0, listOfCards);

		assertThat(score, is(equalTo(6)));
	}
	
	@Test
	public void testRuleCardValuesThatAddUpTo15_2Points_2Length() {
		final String handOfCards = "KH5DQSJCQH";

		// QUEBRANDO A STRING EM UMA LISTA DE STRINGS
		List<String> listOfStrings = ParseStringService.parseToListOfStrings(handOfCards);
		
		// CONVERTENDO A LISTA DE STRINGS EM UMA LISTA DE CARTAS
		List<Card> listOfCards= ParseStringService.parseToListOfCards(listOfStrings);
		
		final Integer score = ScoringService.ruleCardValuesThatAddUpTo15_2Points_2Length(0, listOfCards);

		assertThat(score, is(equalTo(8))); 
	}
		
}
