import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HelloJava8_2 {
	public static void main(String[] args) {

		List<String> myList = Arrays.asList("Procter & Gamble", "Unilever", "Reckitt Benckiser", "GlaxoSmithKline");
		Collections.sort(myList, (String str1, String str2) -> str1.length()<str2.length() ? -1 : 1);
		System.out.println(myList);
		myList.forEach((str) -> MyStringUtil.printStringAndLength(str));
		 
	}

}

//Custom Utility class
class MyStringUtil{

	//reusable static utility method
	public static void printStringAndLength(String str){
		//some complex opertions
		//and then...
		System.out.println(str + " : " + str.length() );
	}
}