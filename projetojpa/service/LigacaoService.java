package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Ligacao;
import com.projetojpa.repository.LigacaoRepository;

@Service
public class LigacaoService {
    private final LigacaoRepository ligacaoRepository;
    
    @Autowired
    public LigacaoService(LigacaoRepository ligacaoRepository) {
        this.ligacaoRepository = ligacaoRepository;
    }

    public List<Ligacao> getAllLigacao() {
        return ligacaoRepository.findAll();
    }

    public Ligacao getLigacaoById(Long id) {
        Optional<Ligacao> Ligacao = ligacaoRepository.findById(id);
        return Ligacao.orElse(null);
    }

    public Ligacao salvarLigacao(Ligacao ligacao) {
        return ligacaoRepository.save(ligacao);
    }

    public Ligacao updateLigacao(Long id, Ligacao updatedLigacao) {
        Optional<Ligacao> existingLigacao = ligacaoRepository.findById(id);
        if (existingLigacao.isPresent()) {
            updatedLigacao.setId(id, id);
            return ligacaoRepository.save(updatedLigacao);
        }
        return null;
    }

    public boolean deleteLigacao(Long id) {
        Optional<Ligacao> existingLigacao = ligacaoRepository.findById(id);
        if (existingLigacao.isPresent()) {
        	ligacaoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}