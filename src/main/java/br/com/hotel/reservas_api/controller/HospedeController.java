package br.com.hotel.reservas_api.controller;

import br.com.hotel.reservas_api.model.Hospede;
import br.com.hotel.reservas_api.service.HospedeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hospedes")
public class HospedeController {

    @Autowired
    private HospedeService hospedeService;

    @PostMapping
    public ResponseEntity<Hospede> criarHospede(@Valid @RequestBody Hospede hospede) {
        Hospede novoHospede = hospedeService.salvar(hospede);
        return new ResponseEntity<>(novoHospede, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospede> obterHospedePorId(@PathVariable Long id) {
        Hospede hospede = hospedeService.obterHospedePorId(id);
        return hospede != null ? new ResponseEntity<>(hospede, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Hospede> atualizarHospede(@PathVariable Long id, @Valid @RequestBody Hospede hospede) {
        Hospede hospedeAtualizado = hospedeService.atualizar(id, hospede);
        return hospedeAtualizado != null ? new ResponseEntity<>(hospedeAtualizado, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarHospede(@PathVariable Long id) {
        boolean deletado = hospedeService.deletar(id);
        return deletado ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}