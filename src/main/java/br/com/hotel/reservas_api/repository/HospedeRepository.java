package br.com.hotel.reservas_api.repository;

import br.com.hotel.reservas_api.model.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long> {
    Optional<Hospede> findByEmail(String email);
    Optional<Hospede> findByCpf(String cpf);
}