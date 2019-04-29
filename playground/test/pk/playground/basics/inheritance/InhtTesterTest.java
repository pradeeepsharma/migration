package pk.playground.basics.inheritance;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class InhtTesterTest {
	private InhtTester inheritanceTester = new InhtTester();

	private List<String> getEnhancedList(List<String> unSortedList){
        List<String> collectedList = unSortedList.stream().map(element -> element + " abc").collect(Collectors.toList());
        System.out.print("Orginal List :"+unSortedList);
        return collectedList;
    }

    private List<Integer> getFilteredList(String searchString){
	    Integer[] numberArray = {3,4,2,6,8,7,2,1,7,5,3,9};
        List<Integer> collectedList = Arrays.stream(numberArray).filter(num -> num > 2).sorted().collect(Collectors.toList());
        Integer reducedNumber = Arrays.stream(numberArray).filter(num -> num > 2).map(num->num*2).reduce(0, (a, i) -> a + i);
        Arrays.stream(numberArray).forEach(num-> System.out.println(num));
        System.out.println("Sum of the series :"+reducedNumber);
        System.out.println(collectedList);
        return collectedList;
    }

	@Test
	void test() {
		assertNotEquals(new Integer(4),getFilteredList("").get(1));
	}

}
