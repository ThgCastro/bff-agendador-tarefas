package com.thgcastro.bffagendador.business.dto.in;

import com.thgcastro.bffagendador.business.enums.StatusNotificacaoEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefasDTORequest {

    private String nomeTarefa;
    private String descricao;
    private LocalDateTime dataEvento;
}
