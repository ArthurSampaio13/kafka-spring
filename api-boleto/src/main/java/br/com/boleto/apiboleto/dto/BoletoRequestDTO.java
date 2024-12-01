package br.com.boleto.apiboleto.dto;

import jakarta.validation.constraints.NotNull;

public record BoletoRequestDTO(@NotNull(message = "O valor não pode ser nulo")
                               String codigoBarras){
}
