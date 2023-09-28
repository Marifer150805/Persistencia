package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Agenda;
import com.projetojpa.repository.AgendaRepository;

@Service
public class AgendaService {
    private final  AgendaRepository agendaRepository;
    
    @Autowired
    public  AgendaService(AgendaRepository  AgendaRepository) {
        this.agendaRepository = AgendaRepository;
    }

    public List<Agenda> getAllAgenda() {
        return agendaRepository.findAll();
    }

    public Agenda getAgendaById(Long id) {
        Optional<Agenda> Agenda = agendaRepository.findById(id);
        return Agenda.orElse(null);
    }

    public Agenda salvarAgenda(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    public Agenda updateAgenda(Long id, Agenda updatedAgenda) {
        Optional<Agenda> existingAgenda =  agendaRepository.findById(id);
        if (existingAgenda.isPresent()) {
            updatedAgenda.setId(id, id);
            return agendaRepository.save(updatedAgenda);
        }
        return null;
    }

    public boolean deleteAgenda(Long id) {
        Optional<Agenda> existingAgenda = agendaRepository.findById(id);
        if (existingAgenda.isPresent()) {
        	agendaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
