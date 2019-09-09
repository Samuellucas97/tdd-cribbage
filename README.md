## Cribbage with TDD
## Introduction  

This folder contains the implementation of the Cribbage game made using the Test-driven Development (TDD) technique. Given this, it refers to one of the activities of the 1st unit of the _Software Test I_ discipline taught by dr. Eiji Adachi Medeiros Barbosa Bachelor of Information Technology at the Federal University of Rio Grande do Norte (__UFRN__).


- [Prerequisites](#prerequisites) - Project prerequisites
- [Cribbage Scoring Rules](#cribbage-scoring-rules) - Punctuation Rules of the game Cribbage.
- [Authors](#authors) - Project authors.


## Prerequisites

You need the following programs to use this repository:

 - Eclipse

## Cribbage Scoring Rules

Cribbage scoring is based on a hand of four cards plus a "starter" card. The score is calculated by finding all combinations of cards that meet the following criteria:

    Pair of cards: 2 points
    Straight of three cards or more: 1 point per card
        Aces are low, so A, 2, 3 is a valid straight, but Q, K, A is not.
    4-card flush excluding starter card: 4 points
    5-card flush including starter card: 5 points
    Jack in the hand whose suit matches the starter card's suit: 1 point
    Card values that add up to 15: 2 points
        Aces' values are 1.
        Jacks, Queens, and Kings' values are 10.
        All other cards' values are equal to their numbers.
        Example: King + Ace + 4 = 10 + 1 + 4 = 15.

Every unique combination of cards can be used. For example, a hand consisting of 7 of Hearts, 8 of Spades, 8 of Hearts, 8 of Diamonds, with a starter card of 9 of Clubs can be scored as follows:

    8 of Spades + 8 of Hearts: pair (2 points)
    8 of Spades + 8 of Diamonds: pair (2 points)
    8 of Hearts + 8 of Diamonds: pair (2 points)
    7 of Hearts + 8 of Spades + 9 of Clubs: straight (3 points)
    7 of Hearts + 8 of Hearts + 9 of Clubs: straight (3 points)
    7 of Hearts + 8 of Diamonds + 9 of Clubs: straight (3 points)
    7 of Hearts + 8 of Spades: adds up to 15 (2 points)
    7 of Hearts + 8 of Hearts: adds up to 15 (2 points)
    7 of Hearts + 8 of Diamonds: adds up to 15 (2 points)

Total score: 21 (A very good hand!)

However, subsets of straights and flushes may only be counted once. In other words, a four-card straight is only worth three points; it doesn't get counted as a three-card straight and a four-card straight. Same for flushes. For example, a hand consisting of 2, 3, 4, and 5 of Hearts, with a starter card of 6 of Hearts, would be scored as follows:

    2, 3, 4, 5, 6 of Hearts: straight (5 points)
    2, 3, 4, 5, 6 of Hearts: flush (5 points)
    2, 3, 4, 6 of Hearts: adds up to 15 (2 points)
    4, 5, 6 of Hearts: adds up to 15 (2 points)

Total score: 14 (A good score, but not as amazing as you might expect from a straight flush.)


## Authors 

| Name: | Github: | Email: |  
| ---------- | ------------- | ------------- |
|`Samuel Lucas de Moura Ferino` 	| https://github.com/Samuellucas97 |_samuellucas97@ufrn.edu.br_  
|`Thiago da Costa Monteiro` 	| https://github.com/Mindundersiege |  
  