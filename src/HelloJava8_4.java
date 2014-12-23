import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class HelloJava8_4 {
  public static void main(String[] args) throws Exception{
		
 		List<Item_Old> items = Arrays.asList(new Item_Old("Coors beer", "2014-02-14"),
 													new Item_Old("Amul milk","2014-11-22"),
													new Item_Old("Heineken beer","2014-04-14"),
													new Item_Old("Kit Kat chocolate","2014-06-12"));
		 
 		// Since the method throws Exception its better off using the older For loop, or we have to wrap & unwrap it
 		for(Item_Old item: items){
			printProductAgeInDays(item);
		}
 		
 		// Using the SimpleDateFormat
 		for(Item_Old item: items){
			printProductAgeInDays2(item);
		}

  }

  //date formater
  public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
  
  // New DateTimeFormatter
  public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  
  //calculate date difference in days and print - USING DateTimeFormatter
  public static void printProductAgeInDays(Item_Old item) throws Exception{
	  // Parses the given Date string using the specified DateTimeFormatter
	  LocalDate packageDate = LocalDate.parse(item.packagedDate, formatter);
	  
	  // Returns the Current Date from system clock using the default time-zone. 
	  LocalDate currentDate = LocalDate.now();

	  // Computes the Difference in Days between the given dates
	  long diffInDays = ChronoUnit.DAYS.between(packageDate, currentDate);
	  long diffInMonths = ChronoUnit.MONTHS.between(packageDate, currentDate);
	    
	  System.out.print(item.product + " is " + diffInDays + " days old \n");
	  System.out.print("--------------" + item.product + " is " + diffInMonths + " Months old \n");
  }
  
  //calc date difference in days and print - USING SimpleDateFormat
  public static void printProductAgeInDays2(Item_Old item) throws Exception{
	  // SimpleDateFormat can also be used with some tweaks
	  Date pkdDate = sdf.parse(item.packagedDate);
	  // This returns the LocalDate instance using the default System time-zone
	  LocalDate packageDate = LocalDateTime.ofInstant(pkdDate.toInstant(), ZoneId.systemDefault()).toLocalDate();
	  // Returns the Current Date from system clock using the default time-zone. 
	  LocalDate currentDate = LocalDate.now();

	  // Computes the Difference in Days between the given dates
	  long diffInDays = ChronoUnit.DAYS.between(packageDate, currentDate);
	    
	  System.out.print(item.product + " is " + diffInDays + " days old \n");
  }
}


class Item_Old{
	public String product;
	public String packagedDate;

	public Item_Old(String product, String packagedDate){
		this.product = product; 
		this.packagedDate = packagedDate;
	}
}