package edu.projet.pfe.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.projet.pfe.entities.Lignes;
import edu.projet.pfe.entities.Marque;
import edu.projet.pfe.entities.Services;
import edu.projet.pfe.entities.Type;
import edu.projet.pfe.entities.User;
import edu.projet.pfe.entities.Vehicule;
import edu.projet.pfe.repositories.LignesRepository;
import edu.projet.pfe.repositories.MarqueRepository;
import edu.projet.pfe.repositories.TypeRepository;
import edu.projet.pfe.repositories.UserRepository;
import edu.projet.pfe.repositories.VehiculeRepository;


@Service
public class VehiculeServiceImpl implements VehiculeService {

	@Autowired
	private VehiculeRepository VR;
	@Autowired
	private UserRepository ur;
	@Autowired
	private TypeRepository tr;
	@Autowired
	private MarqueRepository mr ;
	@Override
	public Vehicule createVehicule(Vehicule v) {

		return VR.save(v);
	}

	@Override
	public List<Vehicule> getAllVehicules() {
		return VR.findAll();
	}

	@Override
	public Vehicule findVehiculeById(Long id) {
		Optional<Vehicule> opt = VR.findById(id);

		if (opt.isEmpty())
			return null;
		else
			return opt.get();
	}

	@Override
	public Vehicule UpdateVehicule(Vehicule v) {
		Optional<Vehicule> opt = VR.findById(v.getId());

		if (opt.isEmpty())
			return null;
		else
			return VR.save(v);
	}

	@Override
	public void DeleteVehicule(Long id) {
		Vehicule v = VR.findById(id).get();
		v.setType(null);
		v.setMarque(null);
		
		VR.deleteById(id);

	}
	/*@Override
	public Vehicule updatevehiculeUser(Vehicule v, Long id) {
		User user = ur.findById(id).get();
		Vehicule V = VR.findById(v.getId()).get();
		V.setUsers(Collections.singletonList(user));
		return VR.save(V);
	}
	@Override
	public Vehicule addvehiculeUser(Vehicule v , Long id)
	{
		  User user = ur.findById(id).get();
		    v.setUsers(Collections.singletonList(user));
	
		   return VR.save(v);
	}*/
	@Override
	public Vehicule createTypeMarqueVehicule(Vehicule v, Long id_type , Long id_marque) {

		Type t = tr.findById(id_type).get();
		v.setType(t);
		Marque m = mr.findById(id_marque).get();
		v.setMarque(m);
		return VR.save(v);
	}

	@Override
	public Vehicule updateTypeMarqueVehicule(Vehicule v, Long id_type , Long id_marque) {
	  Vehicule vehicule =	UpdateVehicule(v);
	  Type t = tr.findById(id_type).get();
		v.setType(t);
		Marque m = mr.findById(id_marque).get();
		v.setMarque(m);
		return VR.save(v);
		}
}
