package com.barcicki.gorcalculator.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.barcicki.gorcalculator.core.Calculator;
import com.barcicki.gorcalculator.core.Opponent;
import com.barcicki.gorcalculator.core.Tournament;
import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class GorCalculatorTest {
	private class TestCase {
		private float gorA;
		private float gorB;
		private float gameResult;
		private float handicap;
		private float category;
		private float expectedRatingChange;

		public float getGorA() {
			return gorA;
		}

		public float getGorB() {
			return gorB;
		}

		public float getGameResult() {
			return gameResult;
		}

		public float getHandicap() {
			return handicap;
		}

		public float getCategory() {
			return category;
		}

		public float getExpectedRatingChange() {
			return expectedRatingChange;
		}
		
		public TestCase(float gorA, float gorB, float gameResult, float handicap, float category, float expectedRatingChange)
		{
			this.gorA = gorA;
			this.gorB = gorB;
			this.gameResult = gameResult;
			this.handicap = handicap;
			this.category = category;
			this.expectedRatingChange = expectedRatingChange;
		}
	}
	
	@Test
	public void CalculateRatingChangeTests() {
		TestCase[] testCases = new TestCase[] {
				/* Piotr Wysocki's results at 2013-01-12 Cracow Go Tournament */
			new TestCase(1914, 1891, Opponent.WIN, Opponent.NO_HANDICAP, Tournament.CATEGORIES.get(Tournament.CATEGORY_A), 13.885f),
			new TestCase(1914, 2103, Opponent.WIN, Opponent.NO_HANDICAP, Tournament.CATEGORIES.get(Tournament.CATEGORY_A), 26.096f),
			new TestCase(1914, 2407, Opponent.LOSS, Opponent.NO_HANDICAP, Tournament.CATEGORIES.get(Tournament.CATEGORY_A), -0.087f),
			new TestCase(1914, 2174, Opponent.WIN, Opponent.NO_HANDICAP, Tournament.CATEGORIES.get(Tournament.CATEGORY_A), 28.102f),
			new TestCase(1914, 2362, Opponent.LOSS, Opponent.NO_HANDICAP, Tournament.CATEGORIES.get(Tournament.CATEGORY_A), -0.253f),
		};

		int i = 1;
		for (TestCase testCase : testCases)
		{
			float actual = Calculator.calculateRatingChange
					(testCase.getGorA(), testCase.getGorB(), testCase.getGameResult(), testCase.getHandicap(), testCase.getCategory());
			assertEquals("Invalid ratingChange in test case #" + i, testCase.getExpectedRatingChange(), actual, 0.01);
			i++;
		}
	}
}
