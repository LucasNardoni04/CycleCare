package br.com.umc.cyclecare.controller;

import br.com.umc.cyclecare.controller.records.usuaria.DadosUsuariaRecord;
import br.com.umc.cyclecare.model.Usuaria;
import br.com.umc.cyclecare.service.UsuariaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/usuaria")
public class UsuariaController {

    private final UsuariaService service;

    @PostMapping("/")
    public ResponseEntity<Usuaria> cadastrarUsuaria(@RequestBody DadosUsuariaRecord record) {
        return ResponseEntity.ok(service.cadastraUsuaria(record));
    }
}
