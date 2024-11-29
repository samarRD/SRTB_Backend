package edu.projet.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.projet.pfe.entities.User;
import edu.projet.pfe.entities.Vehicule;
import edu.projet.pfe.entities.Versement;
import edu.projet.pfe.repositories.VehiculeRepository;
import edu.projet.pfe.repositories.VersementRepository;

@Service
public class VersementServicelmpl implements VersementService {
	@Autowired
	private VersementRepository VR;
	@Autowired
	private VehiculeRepository V;
	@Override
	public Versement createVersement(Versement v ,long id) {
		
		Vehicule vehic = V.findById(id).get();
		v.setVehicule(vehic);
		return VR.save(v);
	}

	@Override
	public List<Versement> getAllVersements() {
		return VR.findAll();
	}
	
	@Override
	public Versement findVersementById(Long id) {
		Optional<Versement> opt = VR.findById(id);

		if (opt.isEmpty())
			return null;
		else
			return opt.get();
	}

	@Override
	public Versement UpdateVersement(Versement v) {
		Optional<Versement> opt = VR.findById(v.getId());

		if (opt.isEmpty())
			return null;
		else
			return VR.save(v);
	}

	@Override
	public void DeleteVersement(Long id) {

		VR.deleteById(id);

	}

}
