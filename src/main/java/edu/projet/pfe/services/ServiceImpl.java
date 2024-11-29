package edu.projet.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.projet.pfe.entities.Arret;
import edu.projet.pfe.entities.Lignes;
import edu.projet.pfe.entities.Marque;
import edu.projet.pfe.entities.Services;
import edu.projet.pfe.entities.Type;
import edu.projet.pfe.entities.Vehicule;
import edu.projet.pfe.repositories.ArretRepository;
import edu.projet.pfe.repositories.LignesRepository;
import edu.projet.pfe.repositories.ServiceRepository;

@Service
public class ServiceImpl implements ServiceSRT {

	@Autowired
	private ServiceRepository SR;
	@Autowired
	private ArretRepository AR;
	@Autowired
	private LignesRepository LR;

	@Override
	public Services createService(Services s) {

		return SR.save(s);
	}

	@Override
	public List<Services> getAllServices() {
		return SR.findAll();
	}

	@Override
	public Services findServiceById(Long id) {
		Optional<Services> opt = SR.findById(id);

		if (opt.isEmpty())
			return null;
		else
			return opt.get();
	}

	@Override
	public Services UpdateService(Services s) {
		Optional<Services> opt = SR.findById(s.getId());

		if (opt.isEmpty())
			return null;
		else
			return SR.save(s);
	}

	@Override
	public void DeleteService(Long id) {
		Services s = SR.findById(id).get();
		s.setLigne(null);
		SR.deleteById(id);

	}

	@Override
	public Services create(Services s,Long id_ligne) {
		Lignes ligne = LR.findById(id_ligne).get();
		s.setLigne(ligne);
		return SR.save(s);
	}

	@Override
	public Services update(Services s,Long id_ligne) {
		Services service = UpdateService(s);
		Lignes ligne = LR.findById(id_ligne).get();
		s.setLigne(ligne);
		return SR.save(s);
	}
}
