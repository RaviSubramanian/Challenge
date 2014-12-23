import java.util.List;
import java.util.Arrays;

public class HelloJava8_3a {
	public static void main(String[] args) {
		List<Item> purchasedItems = Arrays.asList(
				new Item("beer", "coors", 10), new Item("milk", "amul", 2),
				new Item("beer", "heineken", 15), new Item("chocolate",
						"kit kat", 1));

		System.out.println("Number of beers bought : "
				+ purchasedItems.stream()
						.filter(item -> item.category == "beer")
						.mapToInt(item -> item.noOfUnits).sum());
	}
}

class Item {
	public String category;
	public String brand;
	public int noOfUnits;

	public Item(String category, String brand, int noOfUnits) {
		this.category = category;
		this.brand = brand;
		this.noOfUnits = noOfUnits;
	}
}