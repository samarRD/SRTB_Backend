package edu.projet.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.projet.pfe.entities.Arret;
import edu.projet.pfe.entities.Lignes;
import edu.projet.pfe.entities.Services;
import edu.projet.pfe.entities.Type;
import edu.projet.pfe.entities.Vehicule;
import edu.projet.pfe.repositories.ArretRepository;
import edu.projet.pfe.repositories.LignesRepository;
import edu.projet.pfe.repositories.ServiceRepository;

@Service
public class ArretServiceilmpl implements ArretService {
	@Autowired
	private ArretRepository AR;
	@Autowired
	private LignesRepository LR;

	@Override
	public Arret createArret(Arret a) {

		return AR.save(a);
	}

	@Override
	public List<Arret> getAllArrets() {
		return AR.findAll();
	}

	@Override
	public Arret findArretById(Long id) {
		Optional<Arret> opt = AR.findById(id);

		if (opt.isEmpty())
			return null;
		else
			return opt.get();
	}

	@Override
	public Arret UpdateArret(Arret a) {
		Optional<Arret> opt = AR.findById(a.getId());

		if (opt.isEmpty())
			return null;
		else
			return AR.save(a);
	}

	@Override
	public void DeleteArret(Long id) {

		Arret a = AR.findById(id).get();
		List<Lignes> ld = LR.findByArretdepart(a);
		List<Lignes> la = LR.findByArretarrivee(a);

		for (Lignes ligne : ld) {

			ligne.setArretdepart(null);
		}
		for (Lignes ligne : la) {

			ligne.setArretarrivee(null);
		}

		AR.deleteById(id);

	}

}
