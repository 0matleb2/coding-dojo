package books;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookDiscountCalculator {
	
	public static final double[] DISCOUNTS = {
			0,
			1,
			0.95,
			0.9,
			0.8,
			0.75			
	};
	public static final double BOOK_COST = 1;	
	static final int APPROXIMATION_THRESHOLD = 12;
	
	List<Books> books;
	
	public BookDiscountCalculator() {
		books = new ArrayList<>();
	}
	
	public BookDiscountCalculator(List<Books> books) {
		this.books = books;
	}
	
	public void setBooks(List<Books> books) {
		this.books = books;
	}
	/**
	 * This method returns the total cost of the books having applied the discounts.
	 * <ul>
	 * <li>Given the number of books is 12 or less, this method will ensure the best possible discount is applied.</li>
	 * <li>Given the number of books is more than 12, an optimal discount will be approximated and applied.</li>
	 * </ul>
	 */
	public double calculateTotalCost() {
		
		if (books.size() == 0) {
			return 0;
		}
		
		double totalCost = (books.size() > APPROXIMATION_THRESHOLD) ? getApproximateOptimalCost() : getOptimalCost();
		
		System.out.printf("Total cost: $%.2f\n", totalCost);
		System.out.printf("Average book cost: $%.2f\n", totalCost / books.size());
		System.out.printf("Average discount: %.2f%%\n\n", (books.size() * BOOK_COST - totalCost) * 100 / books.size() * BOOK_COST);
		
		return totalCost;
	}
	
	double getOptimalCost() {
		
		List<List<Books>> minPartition = getOptimalPartition(books);
		
		sortPartition(minPartition);
		
		System.out.printf("Optimal partition: %s\n", minPartition);
		
		return calculatePartitionCost(minPartition);
	}
	
	void sortPartition(List<List<Books>> partition) {
        partition.sort((a, b) -> b.size() - a.size());
        partition.stream().forEach(subset -> Collections.sort(subset));
	}
	
	/**
	 * Approximates the optimal partition by greedily removing sets from the collection until
	 * the remaining number of books falls below the approximation threshold.
	 */
	double getApproximateOptimalCost() {
		
		List<Books> books = new ArrayList<>(this.books);
		
		List<List<Books>> removedSets = new ArrayList<>();
			
		for (int setSize = Books.values().length; setSize > 0; --setSize) {
			
			while (books.size() > APPROXIMATION_THRESHOLD && hasSetOfSize(books, setSize)) {
				
				Set<Books> set = new HashSet<Books>(books);
				
				for (Books book : new HashSet<Books>(books)) {
					books.remove(book);
				}
				
				removedSets.add(new ArrayList<>(set));
			}
		}
		
		List<List<Books>> minPartition = getOptimalPartition(books);
		
        minPartition.addAll(removedSets);

        sortPartition(minPartition);
        
        System.out.printf("Approximate optimal partition: %s\n", minPartition);
        
        return calculatePartitionCost(minPartition);		
	}
	
	boolean hasSetOfSize(List<Books> books, int size) {
		return (new HashSet<>(books)).size() == size;
	}
	
	List<List<Books>> getOptimalPartition(List<Books> books) {
        List<List<List<Books>>> partitions = new ArrayList<>();

        for (int blocks = 1; blocks <= books.size(); ++blocks) {
            for (List<List<Books>> partition : new PartitionIterable<>(books, blocks)) {
                if ( isValidPartition(partition) ) {
                	partitions.add(partition);
                }
            }
        }
        
        Map<List<List<Books>>, Double> partitionCostMap = partitions.stream()
			.collect(Collectors.toMap(
					Function.identity(),
					partition -> calculatePartitionCost(partition),
					(oldValue, newValue) -> oldValue)
					);
        
        System.out.printf("Partitions analyzed: %d\n", partitionCostMap.size());
                
        return Collections.min(partitionCostMap.entrySet(), Comparator.comparing(Entry::getValue)).getKey();
	}
	
	boolean isValidPartition(List<List<Books>> partition) {
		for (List<Books> subset : partition) {
			if ( !allElementsUnique(subset) ) {
				return false;
			}
		}
		return true;
	}
	
	<T> boolean allElementsUnique(List<T> list) {
		return (new HashSet<>(list)).size() == list.size();
	}
	
	double calculatePartitionCost(List<List<Books>> partition) {
		
		double totalCost = 0.0;
		
		for (List<Books> subset : partition) {
			totalCost += subset.size() * BOOK_COST * DISCOUNTS[subset.size()];
		}
		
		return totalCost;
	}
	
}
