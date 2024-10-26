package edu.westga.cs1302.project2.model;

import java.util.Comparator;

/**Arranges ingredients by type
 * 
 * @author ldeniso1
 * @version Fall 2024
 */
public class TypeComparator implements Comparator<Ingredient> {
	
	@Override
	public int compare(Ingredient o1, Ingredient o2) {
		if (o1.getType() == o2.getType()) {
			return 0;
		}
		if (o1.getType() != o2.getType()) {
			return 1;
		}
		return o1.getType().compareTo(o2.getType());
	}
	
	@Override
	public String toString() {
		return "Type";
	}
}
