package edu.westga.cs1302.bill.model;

import java.util.Comparator;

/**Arranges Bill arranged in descending price order
 * 
 * @author ldeniso1
 * @version Fall 2024
 */
public class BillDescendingPriceComparator implements Comparator<BillItem> {
	
	@Override
	public int compare(BillItem o1, BillItem o2) {
		if (o1.getAmount() < o2.getAmount()) {
			return 1;
		} else if (o1.getAmount() > o2.getAmount()) {
			return -1;
		} else {
			return 0;
		}
	}
}
