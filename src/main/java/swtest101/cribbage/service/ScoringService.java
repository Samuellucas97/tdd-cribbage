package swtest101.cribbage.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import swtest101.cribbage.entity.Card;

public class ScoringService {
	private static Integer score = 0;

	public static Integer calculateScore(String handOfCards) {

		// QUEBRANDO A STRING EM UMA LISTA DE STRINGS
		List<String> listOfStrings = ParseStringService
				.parseToListOfStrings(handOfCards);

		// CONVERTENDO A LISTA DE STRINGS EM UMA LISTA DE CARTAS
		List<Card> listOfCards = ParseStringService
				.parseToListOfCards(listOfStrings);

		// ::: VERIFICANDO REGRAS ::

		// / -> (RULE) Pair of cards: 2 points
		score = rulePairOfCards_2Points(score, listOfCards);

		// / -> (RULE) Straight of three cards or more: 1 point per card
		score = ruleStraightOfThreeCardsOrMore_1PointPerCard(score, listOfCards);

		// / -> (RULE) 4-card flush excluding starter card: 4 points
		score = rule4CardFlushExcludingStarterCard_4Points(score, listOfCards);

		// / -> (RULE) 5-card flush including starter card: 5 points
		score = rule5CardFlushIncludingStarterCard_5Points(score, listOfCards);

		score = ruleCardValuesThatAddUpTo15_2Points(score, listOfCards);

		return score;
	}

	public static Integer rulePairOfCards_2Points(Integer score,
			List<Card> listOfCards) {

		Card card1 = new Card();
		Card card2 = new Card();

		for (int i = 0; i < listOfCards.size(); ++i) {
			card1 = listOfCards.get(i);
			for (int j = i + 1; j < listOfCards.size(); ++j) {
				card2 = listOfCards.get(j);
				if (card1.getRank() == card2.getRank()) {
					score += 2;
				}
			}
		}

		return score;

	}

	public static Integer ruleStraightOfThreeCardsOrMore_1PointPerCard(
			Integer score, List<Card> listOfCards) {

		HashMap<Integer, Integer> ranksMap = new HashMap<Integer, Integer>();

		// CONTANDO A OCORRENCIA DA LETRA
		for (Card card : listOfCards) {
			Integer rank = card.getRank();

			if (ranksMap.containsKey(rank)) {
				Integer i = ranksMap.get(rank);
				ranksMap.replace(rank, i, ++i);
			} else {
				ranksMap.put(rank, 1);
			}

		}

		Object[] rankArray = ranksMap.keySet().toArray();

		for (int i = 0; i < rankArray.length; ++i) {
			Integer k = ranksMap.get(rankArray[i]);
			Object l = rankArray[i];

			// / POSSUO UMA SEQUENCIA DE **3** CARTAS
			if (ranksMap.get((Integer) l + 1) != null
					&& ranksMap.get((Integer) l + 2) != null) {

				score += (3 * k);

				i += 3;

				// / POSSUO UMA SEQUENCIA DE **4** CARTAS
				if (ranksMap.get((Integer) l + 3) != null) {
					score += 1;

					i += 1;

					// / POSSUO UMA SEQUENCIA DE **5** CARTAS
					if (ranksMap.get((Integer) l + 4) != null) {
						score += 1;
						i += 1;
					}
				}
			}

		}

		return score;
	}

	public static Integer rule4CardFlushExcludingStarterCard_4Points(int score,
			List<Card> listOfCards) {

		Boolean exist4CardFlush = true;

		// / Verificando se todas as quatro cartas sao do mesmo naipe
		for (int i = 1; i < listOfCards.size(); ++i) {
			if (listOfCards.get(i).getSuit() != listOfCards.get(1).getSuit()) {
				exist4CardFlush = false;
			}
		}

		if (exist4CardFlush) {
			score += 4;
		}

		return score;
	}

	public static Integer rule5CardFlushIncludingStarterCard_5Points(int score,
			List<Card> listOfCards) {

		Boolean exist5CardFlush = true;

		// / Verificando se todas as cinco cartas sao do mesmo naipe
		for (int i = 0; i < listOfCards.size(); ++i) {
			if (listOfCards.get(i).getSuit() != listOfCards.get(0).getSuit()) {
				exist5CardFlush = false;
			}
		}

		if (exist5CardFlush) {
			score += 5;
		}

		return score;
	}

	public static Integer ruleJackInTheHandWhoseSuitMatchesTheStarterCardSuit_1Point(
			int score, List<Card> listOfCards) {

		if (listOfCards.get(0).getRank() == 11) {
			score += 1;
		}

		return score;
	}

	public static Integer ruleCardValuesThatAddUpTo15_2Points_5Length(
			int score, List<Card> listOfCards) {
		int summation = 0;

		for (Card card : listOfCards) {

			if (card.getRank() == 11) {
				summation += 10;
			} else if (card.getRank() == 12) {
				summation += 10;
			} else if (card.getRank() == 13) {
				summation += 10;
			} else {
				summation += card.getRank();
			}
		}

		if (summation == 15) {
			score += 2;
		}

		return score;
	}

	public static Integer ruleCardValuesThatAddUpTo15_2Points_4Length(
			int score, List<Card> listOfCards) {

		int summation = 0;

		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<Card> cards_aux = new ArrayList<Card>();

		for (int i = 0; i < listOfCards.size(); ++i) {
			cards.add(listOfCards.get(i));
		}

		for (int i = 0; i < listOfCards.size(); ++i) {

			cards_aux = (ArrayList<Card>) cards.clone();
			cards_aux.remove(i);
			summation = 0;

			for (Card card : cards_aux) {

				if (card.getRank() == 11) {
					summation += 10;
				} else if (card.getRank() == 12) {
					summation += 10;
				} else if (card.getRank() == 13) {
					summation += 10;
				} else {
					summation += card.getRank();
				}
			}

			if (summation == 15) {
				score += 2;
			}
		}

		return score;
	}

	public static Integer ruleCardValuesThatAddUpTo15_2Points_3Length(
			int score, List<Card> listOfCards) {

		int summation = 0;

		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<Card> cards_aux = new ArrayList<Card>();
		ArrayList<Card> cards_aux_aux = new ArrayList<Card>();

		for (int i = 0; i < listOfCards.size(); ++i) {
			cards.add(listOfCards.get(i));
		}

		for (int j = 0; j < listOfCards.size(); ++j) {

			cards_aux_aux = (ArrayList<Card>) cards.clone();
			cards_aux_aux.remove(j);
			summation = 0;

			for (int i = 0; i < listOfCards.size() - 1 && j != i; ++i) {

				cards_aux = (ArrayList<Card>) cards_aux_aux.clone();
				cards_aux.remove(i);
				summation = 0;

				for (Card card : cards_aux) {

					if (card.getRank() == 11) {
						summation += 10;
					} else if (card.getRank() == 12) {
						summation += 10;
					} else if (card.getRank() == 13) {
						summation += 10;
					} else {
						summation += card.getRank();
					}
				}

				if (summation == 15) {
					score += 2;

				}

			}

		}

		return score;

	}

	public static Integer ruleCardValuesThatAddUpTo15_2Points_2Length(
			int score, List<Card> listOfCards) {

		Card card1 = new Card();
		Card card2 = new Card();
		Integer summation = 0;

		for (int i = 0; i < listOfCards.size(); ++i) {
			card1 = listOfCards.get(i);
			for (int j = i + 1; j < listOfCards.size(); ++j) {
				if (card1.getRank() == 11) {
					summation += 10;
				} else if (card1.getRank() == 12) {
					summation += 10;
				} else if (card1.getRank() == 13) {
					summation += 10;
				} else {
					summation += card1.getRank();
				}
				card2 = listOfCards.get(j);
				if (card2.getRank() == 11) {
					summation += 10;
				} else if (card2.getRank() == 12) {
					summation += 10;
				} else if (card2.getRank() == 13) {
					summation += 10;
				} else {
					summation += card2.getRank();
				}
				if (summation == 15) {
					score += 2;
				}
				summation = 0;
			}
		}

		return score;

	}

	public static Integer ruleCardValuesThatAddUpTo15_2Points(int score,
			List<Card> listOfCards) {

		// ::: VERIFICANDO SUBREGRAS ::
		score = ruleCardValuesThatAddUpTo15_2Points_2Length(score, listOfCards);
		score = ruleCardValuesThatAddUpTo15_2Points_3Length(score, listOfCards);
		score = ruleCardValuesThatAddUpTo15_2Points_4Length(score, listOfCards);
		score = ruleCardValuesThatAddUpTo15_2Points_5Length(score, listOfCards);

		return score;

	}

}
