package com.skilldistillery.roundtablegaming.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.roundtablegaming.entities.Attendee;
import com.skilldistillery.roundtablegaming.entities.Category;

@Service
@Transactional
public class CategoryDAOImpl implements CategoryDAO{

	@PersistenceContext
	EntityManager em;

	@Override
	public Category updateCategory(Category category) {
		Category updated= null;
		updated= em.find(Category.class, category.getId());
		
		updated.setDescription(category.getDescription());
		updated.setGames(category.getGames());
		updated.setName(category.getName());
		
		em.persist(updated);
		em.flush();
		
		return updated;
	}

	@Override
	public Category createCategory(Category newCategory) {
		em.persist(newCategory);
		em.flush();
		
		return newCategory;
	}
	
	
}
