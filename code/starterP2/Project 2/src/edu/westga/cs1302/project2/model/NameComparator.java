package edu.westga.cs1302.project2.model;

import java.util.Comparator;

/**Arranges ingredients by name
 * 
 * @author ldeniso1
 * @version Fall 2024
 */
public class NameComparator implements Comparator<Ingredient> {
	
	@Override
	public int compare(Ingredient o1, Ingredient o2) {
		if (o1.getName() == o2.getName()) {
			return 0;
		} else {
			return 1;
		}
	}
	
	@Override
	public String toString() {
		return "Name";
	}
}
