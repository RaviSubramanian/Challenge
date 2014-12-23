import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Test {
  public static void main(String[] args) throws Exception{
		
 		List<Item5> Item5s = Arrays.asList(new Item5("Coors beer", "2014-02-14"),
 													new Item5("Amul milk","2014-02-14"),
													new Item5("Heineken beer","2014-01-01"),
													new Item5("Kit Kat chocolate","2014-06-12"));
		//printProductAgeInDays;
		Item5s.forEach(Item5 -> printProductAgeInDays(Item5));

  }

  //calc date difference in days and print  
  public static void printProductAgeInDays (Item5 Item5){
  
		System.out.print(Item5.product + " is ");
		System.out.println(ChronoUnit.DAYS.between(LocalDate.parse(Item5.packagedDate), LocalDate.now()) +" days old");
  }


}


class Item5{
	public String product;
	public String packagedDate;

	public Item5(String product, String packagedDate){
		this.product = product; 
		this.packagedDate = packagedDate;
	}
}

