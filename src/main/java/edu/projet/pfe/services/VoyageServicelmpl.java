package edu.projet.pfe.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.projet.pfe.entities.Lignes;
import edu.projet.pfe.entities.Services;
import edu.projet.pfe.entities.User;
import edu.projet.pfe.entities.Vehicule;
import edu.projet.pfe.entities.Voyage;
import edu.projet.pfe.repositories.ServiceRepository;
import edu.projet.pfe.repositories.UserRepository;
import edu.projet.pfe.repositories.VehiculeRepository;
import edu.projet.pfe.repositories.VoyageRepository;

@Service
public class VoyageServicelmpl implements VoyageService {
	@Autowired
	private VoyageRepository VR;
	@Autowired
	private UserRepository UR;
	@Autowired
	private ServiceRepository SR;
	@Autowired
	private VehiculeRepository vehiculeRepo;

	@Override
	public Voyage createVoyage(Voyage v) {
		return VR.save(v);
	}

	@Override
	public List<Voyage> getAllVoyages() {
		return VR.findAll();
	}

	@Override
	public Voyage findVoyageById(Long id) {
		Optional<Voyage> opt = VR.findById(id);

		if (opt.isEmpty())
			return null;
		else
			return opt.get();
	}

	@Override
	public Voyage UpdateVoyage(Voyage v) {
		Optional<Voyage> opt = VR.findById(v.getId());

		if (opt.isEmpty())
			return null;
		else
			return VR.save(v);
	}

	@Override
	public void DeleteVoyage(Long id) {
		VR.deleteById(id);

	}

	@Override
	public Voyage createVoyageServiceUser(Voyage v, Long user_id, Long service_id, Long vehicule_id) {

		User u = UR.findById(user_id).get();
		Services s = SR.findById(service_id).get();
		Vehicule vehicule = vehiculeRepo.findById(vehicule_id).get();
		v.setService(s);
		v.setUser(u);
		v.setVehicule(vehicule);
		return VR.save(v);
	}

	@Override
	public Voyage updateVoyageServiceUser(Voyage v, Long userrealise_id, Long vehiculerealise_id) {
		Voyage voyage = UpdateVoyage(v);

		User ur = UR.findById(userrealise_id).get();
		Vehicule vr = vehiculeRepo.findById(vehiculerealise_id).get();

		voyage.setUserrealise(ur);

		voyage.setVehiculerealise(vr);

		return VR.save(voyage);
	}

}
