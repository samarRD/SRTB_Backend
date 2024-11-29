package edu.projet.pfe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.projet.pfe.entities.Arret;
import edu.projet.pfe.entities.Lignes;
import edu.projet.pfe.entities.Services;
import edu.projet.pfe.repositories.ArretRepository;
import edu.projet.pfe.repositories.LignesRepository;

@Service
public class LigneServicelmpl implements LigneService {

	@Autowired
	private LignesRepository LR;
	@Autowired
	private ArretRepository AR;

	@Override
	public Lignes createLigne(Lignes l, Long id_arretdepart, Long id_arretarrivee) {
		Arret ar = AR.findById(id_arretarrivee).get();
		l.setArretarrivee(ar);
		Arret ad = AR.findById(id_arretdepart).get();
		l.setArretdepart(ad);
		return LR.save(l);
	}
	@Override
	public Lignes update(Lignes l,Long id_arretdepart, Long id_arretarrivee) {
		Lignes ligne = UpdateLigne(l);
		Arret ar = AR.findById(id_arretarrivee).get();
		ligne.setArretarrivee(ar);
		Arret ad = AR.findById(id_arretdepart).get();
		ligne.setArretdepart(ad);
		return LR.save(ligne);
	}
	@Override
	public Lignes UpdateLigne(Lignes l) {
		Optional<Lignes> opt = LR.findById(l.getId());

		if (opt.isEmpty())
			return null;
		else
			return LR.save(l);
	}
	@Override
	public List<Lignes> getAllLignes() {
		return LR.findAll();
	}



	@Override
	public Lignes findLigneById(Long id) {
		Optional<Lignes> opt = LR.findById(id);

		if (opt.isEmpty())
			return null;
		else
			return opt.get();
	}


	@Override
	public void DeleteLigne(Long id) {
		Lignes l = LR.findById(id).get();
		l.setArretdepart(null);
		l.setArretarrivee(null);
		LR.deleteById(id);

	}

}
