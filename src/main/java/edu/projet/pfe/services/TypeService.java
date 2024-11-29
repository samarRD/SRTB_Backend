package edu.projet.pfe.services;

import java.util.List;

import edu.projet.pfe.entities.Type;

public interface TypeService {
	public Type  createType(Type t);
	public List<Type> getAllTypes();
	public Type  findTypeById(Long id);
	public Type  UpdateType(Type t);
	public void DeleteType(Long id);

}
