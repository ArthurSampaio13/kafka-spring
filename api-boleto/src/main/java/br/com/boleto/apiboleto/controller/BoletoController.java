package br.com.boleto.apiboleto.controller;

import br.com.boleto.apiboleto.dto.BoletoDTO;
import br.com.boleto.apiboleto.dto.BoletoRequestDTO;
import br.com.boleto.apiboleto.service.BoletoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/controller")
@RequiredArgsConstructor
public class BoletoController {
    private final BoletoService boletoService;

    @PostMapping
    public ResponseEntity<BoletoDTO> salvar(@Valid @RequestBody BoletoRequestDTO boletoRequestDTO) {
        var boleto = boletoService.salvar(boletoRequestDTO.codigoBarras());
        return new ResponseEntity<>(boleto, HttpStatus.CREATED);
    }
}
