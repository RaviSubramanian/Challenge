import java.util.Arrays;
import java.util.List;

/**
 * Super class for an Item data and operations
 *
 */
class GenericItem<T> {
	GenericItem() {};
}

/**
 * Interface to support <strong>Sales and Stock</strong> with default implementation for <strong>Integer</strong> data type.
 *
 * @param <T> -  - can be of any Number format
 */
interface Salable<T> {
	abstract public T getUnitsSoldToday();
	abstract public T getPreviousdayStock();
	
	/**
	 * Default implementation is priovided for Integer. Can be overridden for custom implementation.
	 * 
	 * @return - Integer
	 */
	default public Integer getCurrentStock() {
		return ((Integer)this.getPreviousdayStock()) - ((Integer)this.getUnitsSoldToday());
	}
}

/**
 * Generic Class for SingleItem <strong>(Can handle any Number Format)</strong>
 *
 * @param <T> - can be of any Number format
 */
class SingleItem<T extends Number> extends GenericItem<T> implements Salable<T> {
	T stock, sales;

	public SingleItem(T stock, T sales) {
		this.stock = stock;
		this.sales = sales;
	}

	public T getUnitsSoldToday() {
		return sales;
	}

	public T getPreviousdayStock() {
		return stock;
	}
}

/**
 * Generic Class for Combination Item <strong>(Can handle any Number Format)</strong>
 *
 * @param <T> - can be of any Number format
 */
class ComboItem<T extends Number> extends GenericItem<T> implements Salable<T> {
	T comboStock, comboSales;

	public ComboItem(T stock, T sales) {
		this.comboStock = stock;
		this.comboSales = sales;
	}

	public T getUnitsSoldToday() {
		return comboSales;
	}

	public T getPreviousdayStock() {
		return comboStock;
	}
}

/**
 * Formating logic for printing, with default Implementation for <strong>Integer</strong> Format. should be <strong>Overridden</strong> for other formats
 *
 * @param <T>
 */
interface Formater<T> {
	public default String format(T number){
		return "**** " + number + " ****";
	}
}

/**
 * Create some Salable items and try to print the current stock of the items
 *
 */
public class HelloJava8_6 {
	public static void main(String[] args) {
		new HelloJava8_6().exec();
	}

	public void exec() {
		SingleItem<Integer> si = new SingleItem<>(100, 10);
		ComboItem<Integer> ci = new ComboItem<>(25, 5);
		List<Salable<Integer>> items = Arrays.asList(si, ci);

		// Inline instantiation & invocation of implemented method in parameter (New feature in Java 8). Gets rid of the private method printCurrentStock.
		items.forEach((item) -> System.out.println(new Formater<Integer>(){}.format(item.getCurrentStock())));
	}
}
