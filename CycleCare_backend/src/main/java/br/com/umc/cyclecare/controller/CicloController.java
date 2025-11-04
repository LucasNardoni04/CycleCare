//package br.com.umc.cyclecare.controller;
//
//import br.com.umc.cyclecare.controller.records.calendario.DadosCicloRecord;
//import br.com.umc.cyclecare.model.Ciclo;
//import br.com.umc.cyclecare.model.User;
//import br.com.umc.cyclecare.service.CicloService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@AllArgsConstructor
//@RequestMapping("/calendario")
//@CrossOrigin
//public class CicloController {
//
//    private final CicloService cicloService;
//
//    @PostMapping("/cadastrar")
//    public DadosCicloRecord cadastrar(@RequestBody DadosCicloRecord record, @Aut User user) {
//        Ciclo ciclo = cicloService.cadastrarCiclo(record, user);
//        return new DadosCicloRecord();
//    }
//}
