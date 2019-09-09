package swtest101.cribbage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import swtest101.cribbage.entity.Card;


public class ScoringService {

	public static Integer calculateScore(String handOfCards) {
	
		Integer score = 0;
		
		// QUEBRANDO A STRING EM UMA LISTA DE STRINGS
		List<String> listOfStrings = ParseStringService.parseToListOfStrings(handOfCards);
		
		// CONVERTENDO A LISTA DE STRINGS EM UMA LISTA DE CARTAS
		List<Card> listOfCards= ParseStringService.parseToListOfCards(listOfStrings);
		
		// ::: VERIFICANDO REGRAS ::
		
		/// -> (RULE) Pair of cards: 2 points
		score = rulePairOfCards_2Points(score, listOfCards);	
		
		/// -> (RULE) Straight of three cards or more: 1 point per card
		score = ruleStraightOfThreeCardsOrMore_1PointPerCard(score, listOfCards);
		
		
		return score;
	}

	public static Integer rulePairOfCards_2Points(Integer score, List<Card> listOfCards) {
		
		HashMap<Integer, Integer> ranksMap = new HashMap<Integer, Integer>();
		
		// CONTANDO A OCORRENCIA DA LETRA
		for( Card card: listOfCards) {
			Integer rank = card.getRank();
			
			if( ranksMap.containsKey(rank) ) {
				Integer i = ranksMap.get(rank);
				ranksMap.replace(rank, i, ++i);
			} 
			else {
				ranksMap.put(rank, 1);
			}
				
		}
		
		// ENCONTRANDO AS CARTAS PARES
		for(Map.Entry<Integer, Integer> i: ranksMap.entrySet()) {
			if( i.getValue() == 2)
				score += 2;
		}
		return score;
	}

	public static Integer ruleStraightOfThreeCardsOrMore_1PointPerCard(Integer score, List<Card> listOfCards) {
		
		HashMap<Integer, Integer> ranksMap = new HashMap<Integer, Integer>();
		
		// CONTANDO A OCORRENCIA DA LETRA
		for( Card card: listOfCards) {
			Integer rank = card.getRank();
			
			if( ranksMap.containsKey(rank) ) {
				Integer i = ranksMap.get(rank);
				ranksMap.replace(rank, i, ++i);
			} 
			else {
				ranksMap.put(rank, 1);
			}
				
		}
		
		
		Object[] rankArray = ranksMap.keySet().toArray();

		for( int i = 0; i < rankArray.length; ++i){
			Integer k = ranksMap.get(  rankArray[i] );				
			Object l = rankArray[i];
			
			/// POSSUO UMA SEQUENCIA DE **3** CARTAS
			if(ranksMap.get((int)l+1) != null && ranksMap.get((int)l+2) != null) { 
				
				score += (3*k);
				
				i+= 3;
				
				/// POSSUO UMA SEQUENCIA DE **4** CARTAS
				if(ranksMap.get((int)l+3) != null) { 
					score += 1;
				
					i+=1;
					
					/// POSSUO UMA SEQUENCIA DE **5** CARTAS
					if( ranksMap.get((int)l+4) != null) { 
						score += 1;
						i+=1;
					}
				}
			}	
				
		
		}
	
		return score;
	}

	public static Integer ruleCardValuesThatAddUpTo15_2Points(int score, List<Card> listOfCards) {
		
		int summation = 0;
		
		for( Card card : listOfCards)
			summation += card.getRank();
		
		if( summation == 15)
			score += 2;
		
		
		return score;
	}
}
