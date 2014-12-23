import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HelloJava8_3 {
	
  public static void main(String[] args) {
 		List<Item21> purchasedItem21s = Arrays.asList(new Item21("beer","coors",2),new Item21("milk","amul",2),
								new Item21("beer","heineken",5),new Item21("chocolate","kit kat",1));
		//how many beers are bought
		int noOfBeers = 0;
		
		//This will return the Sum of all the beer items in the list
		noOfBeers  = (int) purchasedItem21s
								.stream()
								.filter(item -> item.category == "beer")
								.collect(Collectors.summarizingInt(item -> item.noOfUnits))
								.getSum();
		
		System.out.println("Number of beers bought : "  + noOfBeers);
  }
}

class Item21{
	public String category;
	public String brand;
	public int noOfUnits;

	public Item21(String category, String brand, int noOfUnits){
		this.category = category; 
		this.brand = brand;
		this.noOfUnits = noOfUnits;
	}
}