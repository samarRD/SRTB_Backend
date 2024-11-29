package edu.projet.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.projet.pfe.entities.Marque;
import edu.projet.pfe.entities.Vehicule;
import edu.projet.pfe.repositories.MarqueRepository;
import edu.projet.pfe.repositories.VehiculeRepository;

@Service
public class MarqueServiceImpl implements MarqueService{
	@Autowired
	private MarqueRepository MR;
	@Autowired
	private VehiculeRepository VR;
	@Override
	public Marque createMarque (Marque m) {
		
		return MR.save(m);
	}

	@Override
	public List<Marque> getAllMarques() {
		return MR.findAll();
	}

	@Override
	public Marque findMarqueById(Long id) {
     Optional<Marque> opt = MR.findById(id);
		
		if(opt.isEmpty())
			return null;
		else
			return opt.get();
	}

	@Override
	public Marque UpdateMarque(Marque m) {
     Optional <Marque> opt = MR.findById(m.getId());
		
		if(opt.isEmpty())
			return null;
		else
			return MR.save(m);
	}

	@Override
	public void DeleteMarque(Long id) {
		Marque m = MR.findById(id).get();
		List<Vehicule> v = VR.findByMarque(m);

		for (Vehicule vehicule : v) {
			vehicule.setMarque(null);
		}
		MR.deleteById(id);

	}
}
