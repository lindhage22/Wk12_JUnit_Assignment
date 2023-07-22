package com.promineotech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
	   testDemo = new TestDemo ();
	
	}

	@ParameterizedTest
	/*
	 * Change the name of method "test" to
	 * "assertThatTwoPositiveNumbersAreAddedCorrectly"
	 *  and add the four parameters in table. (Page 8 and 9)
	 */
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException  ) {

      /*
       * Given to positive integers 
       */
		
		if(!expectException){
            
        	/* when: the integers are added 
        	 * then: the expected value is return*/
        	
            assertThat(testDemo.addPositive(a,b)).isEqualTo(expected);
        }else{
            
        	/* when: the integers are added
               then: the expected value is return
               Use a Lambda body should be the method call to 
               testDemo.addPositive
               */
            
        	assertThatThrownBy(() -> testDemo.addPositive(a, b))
                    .isInstanceOf(IllegalArgumentException.class);

        }
        /*
         * Create a static method named argumentsForAddPositive. 
         * It should not have any parameters and it should return a Stream of Arguments. 
         * The method should return a Stream as in Stream.of();
         * Each parameter set should be wrapped in an arguments() method call. 
         */
	}
	  static Stream<Arguments> argumentsForAddPositive(){
	        // formatter:off
	        return Stream.of(
	                arguments(2,4,6,false)
	  );
	        // formatter:on
	  }
	        @Test
	        void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
	        	assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
	        	assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
	        	assertThat(testDemo.addPositive(3,2)).isEqualTo(5);
	        	assertThat(testDemo.addPositive(20,20)).isEqualTo(40);
	        	assertThat(testDemo.addPositive(1,12)).isEqualTo(13);
	        
	    }
	        
	     /*
	      * add another method named randomNumberSquared. This method obtains a 
	      * random int between 1 and 10 and then returns the square of the number.
   
	      */
	        
	        @Test
	        void assertThatNumberSquaredIsCorrect(){
	            TestDemo mockDemo = spy(testDemo);
	            doReturn(5).when(mockDemo).getRandomInt();
	            int fiveSquared = mockDemo.randomNumberSquared();
	            assertThat(fiveSquared).isEqualTo(25);
	            
	     }
}

