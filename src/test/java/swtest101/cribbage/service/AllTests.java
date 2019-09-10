package swtest101.cribbage.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = { 
	ScoringServiceTest.class, 
	ParseToCardTest.class, 
	ParseToCardExceptionalTest.class,
	ParseStringService.class,
	ParseToListStringExceptionalTest.class})
public class AllTests {

}
