package com.nissan.repo;

import java.util.Optional;

import com.nissan.model.Professor;

public interface ICrudRepository {
	// Create a professor
	public void insertEntity();
	// List all professor
	public void listEntity();
	// Update professor
	public void editEntity();
	// Delete professor
	public void deleteEntity();
	// Search by Id
	public Optional<Professor> searchEntity(String name);	
}
