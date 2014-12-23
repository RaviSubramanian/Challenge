package challenge.six;


import java.util.*;


//Super class for an Item data and operations
//but also strictly no sales related info in this class
class GenericItem{
	GenericItem(){};
	//lot of item specific methods
}

//so we have an interface to support sales and stock
interface Salable {
	abstract public int getUnitsSoldToday();
	abstract public int getPreviousdayStock();
	abstract public int getCurrentStock();
}

//create a class for SingleItem 
class SingleItem extends GenericItem implements Salable{
	int stock, sales;

	public SingleItem(int stock, int sales ){
		this.stock = stock; 
		this.sales = sales;
	}	

	public int getUnitsSoldToday(){return sales;}
	public int getPreviousdayStock(){return stock;}

	//duplicate implementation in all the 'Salable' items
	public int getCurrentStock(){
		return getPreviousdayStock() - getUnitsSoldToday();
	}
}

//create a class for Combination Item 
class ComboItem extends GenericItem implements Salable {
	int comboStock, comboSales;

	public ComboItem(int stock, int sales ){
		this.comboStock = stock; 
		this.comboSales = sales;
	}	

	public int getUnitsSoldToday(){return comboSales;}
	public int getPreviousdayStock(){return comboStock;}

	//duplicate implementation in all the 'Salable' items
	public int getCurrentStock(){
		return getPreviousdayStock() - getUnitsSoldToday();
	}

}

//to implement formating logic while printing
interface Formater {
	abstract public String format(int number);
}



//Create some Salable items and try to print the current stock of the items
public class HelloJava8_6_ques {

	public static void main(String[] args) {
		new HelloJava8_6_ques().exec();
	}
	
	public void exec() {
		SingleItem si = new SingleItem(100,10);
		ComboItem ci = new ComboItem(25,5);

		List<Salable> items = Arrays.asList(si,ci);

		for(Salable item: items){
			printCurrentStock(item.getCurrentStock() , new Formater(){
																	public String format(int number){
																		//based on the number value format logic is decided
																		return "**** " +  number + " ****";
																	}		
															 	} );
		}
	}

	void printCurrentStock( int stock, Formater formater){
		System.out.println(formater.format(stock)); 
	}

}


