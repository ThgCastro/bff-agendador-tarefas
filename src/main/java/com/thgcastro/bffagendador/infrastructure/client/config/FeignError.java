package com.thgcastro.bffagendador.infrastructure.client.config;

import com.thgcastro.bffagendador.infrastructure.exceptions.BusinessException;
import com.thgcastro.bffagendador.infrastructure.exceptions.ConflictException;
import com.thgcastro.bffagendador.infrastructure.exceptions.ResourceNotFoundException;
import com.thgcastro.bffagendador.infrastructure.exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()){
            case 409:
                return new ConflictException("Erro! Atributo já existente");
            case 403:
                return new ResourceNotFoundException("Erro! Atributo não encontrado");
            case 401:
                return new UnauthorizedException("Usuário não autorizado!");
            default:
                return new BusinessException("Erro de servidor ou erro não previsto por personalização");
        }
    }
}
