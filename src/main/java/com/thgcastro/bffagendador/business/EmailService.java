package com.thgcastro.bffagendador.business;

import com.thgcastro.bffagendador.business.dto.out.TarefasDTOResponse;
import com.thgcastro.bffagendador.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail(TarefasDTOResponse dto) {
        emailClient.enviarEmail(dto);
    }

}
