package br.com.hotel.reservas_api.service;

import br.com.hotel.reservas_api.model.Hospede;
import br.com.hotel.reservas_api.repository.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospedeService {

    @Autowired
    private HospedeRepository hospedeRepository;

    public Hospede salvar(Hospede hospede){
        if(hospedeRepository.findByEmail(hospede.getEmail()).isPresent()){
            throw new IllegalArgumentException("Email já cadastrado");
        }
        if(hospedeRepository.findByCpf(hospede.getCpf()).isPresent()){
            throw new IllegalArgumentException("CPF já cadastrado");
        }
        return hospedeRepository.save(hospede);
    }

    public Hospede buscarPorId(Long id) {
        return hospedeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Hospede não encontrado"));
    }

    public boolean existePorEmail(String email) {
        return hospedeRepository.findByEmail(email).isPresent();
    }

    public boolean existePorCpf(String cpf) {
        return hospedeRepository.findByCpf(cpf).isPresent();
    }

    public Hospede atualizar(Hospede hospede) {
        if (!hospedeRepository.existsById(hospede.getId())) {
            throw new IllegalArgumentException("Hospede não encontrado");
        }
        return hospedeRepository.save(hospede);
    }

    public void deletar(Long id) {
        if (!hospedeRepository.existsById(id)) {
            throw new IllegalArgumentException("Hospede não encontrado");
        }
        hospedeRepository.deleteById(id);
    }

 
}