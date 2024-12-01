package br.com.boleto.apiboleto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BoletoRequestDTO(@NotNull(message = "valor não pode ser nulo")
                               @NotBlank(message = "valor não pode ser nulo")
                               String codigoBarras){
}
