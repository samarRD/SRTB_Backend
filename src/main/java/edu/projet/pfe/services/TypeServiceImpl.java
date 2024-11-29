package edu.projet.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.projet.pfe.entities.Marque;
import edu.projet.pfe.entities.Type;
import edu.projet.pfe.entities.Vehicule;
import edu.projet.pfe.repositories.MarqueRepository;
import edu.projet.pfe.repositories.TypeRepository;
import edu.projet.pfe.repositories.VehiculeRepository;

@Service
public class TypeServiceImpl implements TypeService {
	@Autowired
	private TypeRepository TR;
	@Autowired
	private VehiculeRepository VR;

	@Override
	public Type createType(Type t) {

		return TR.save(t);
	}

	@Override
	public List<Type> getAllTypes() {
		return TR.findAll();
	}

	@Override
	public Type findTypeById(Long id) {
		Optional<Type> opt = TR.findById(id);

		if (opt.isEmpty())
			return null;
		else
			return opt.get();
	}

	@Override
	public Type UpdateType(Type t) {
		Optional<Type> opt = TR.findById(t.getId());

		if (opt.isEmpty())
			return null;
		else
			return TR.save(t);
	}

	@Override
	public void DeleteType(Long id) {
		Type t = TR.findById(id).get();
		List<Vehicule> v = VR.findByType(t);

		for (Vehicule vehicule : v) {
			vehicule.setType(null);
		}
		TR.deleteById(id);

	}

}
