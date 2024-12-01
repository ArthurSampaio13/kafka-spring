package br.com.boleto.apiboleto.controller.exception;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private String erro;
    private int codigo;
    private Date timestamp;
    private String path;
}
