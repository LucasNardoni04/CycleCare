package br.com.umc.cyclecare.controller;

import br.com.umc.cyclecare.controller.records.calendario.DadosCalendarioRecord;
import br.com.umc.cyclecare.model.CalendarioCiclo;
import br.com.umc.cyclecare.service.CalendarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/calendario")
@CrossOrigin
public class CalendarioController {

    private final CalendarioService service;

    @PostMapping("/")
    public ResponseEntity<CalendarioCiclo> cadastraCiclo(@RequestBody DadosCalendarioRecord record) {
        return ResponseEntity.ok(service.cadastrarCalendarioCiclo(record));
    }
}
