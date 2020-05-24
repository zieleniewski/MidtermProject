package com.skilldistillery.roundtablegaming.data;

import com.skilldistillery.roundtablegaming.entities.Category;

public interface CategoryDAO {

	public Category updateCategory(Category updatedCategory);
	
	
	/*
	 * Create and Disable for Scalability and future use.
	 */
	public Category createCategory(Category newCategory);

//	public boolean disableCategory(int categoryId);
//
//	public boolean enableCategory(int categoryId);


}
