package com.thgcastro.bffagendador.infrastructure.client;

import com.thgcastro.bffagendador.business.dto.in.EnderecoDTORequest;
import com.thgcastro.bffagendador.business.dto.in.LoginRequestDTO;
import com.thgcastro.bffagendador.business.dto.in.TelefoneDTORequest;
import com.thgcastro.bffagendador.business.dto.in.UsuarioDTORequest;
import com.thgcastro.bffagendador.business.dto.out.EnderecoDTOResponse;
import com.thgcastro.bffagendador.business.dto.out.TelefoneDTOResponse;
import com.thgcastro.bffagendador.business.dto.out.UsuarioDTOResponse;
import com.thgcastro.bffagendador.business.dto.out.ViaCepDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTOResponse buscarUsuarioPorEmail(@RequestParam("email") String email,
                                             @RequestHeader(value = "Authorization", required=false) String token);

    @PostMapping
    UsuarioDTOResponse savaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO usuarioDTO);

    @DeleteMapping("/{email}")
    void deletarUsuarioPorEmail(@PathVariable String email,
                                @RequestHeader(value = "Authorization", required=false) String token);

    @PutMapping
    UsuarioDTOResponse atualizaDadosUsuario(@RequestBody UsuarioDTORequest usuarioDTO,
                                            @RequestHeader(value = "Authorization", required=false) String token);

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader(value = "Authorization", required=false) String token);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader(value = "Authorization", required=false) String token);

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestHeader(value = "Authorization", required=false) String token);

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestHeader(value = "Authorization", required=false) String token);

    @GetMapping("/endereco/{cep}")
    ViaCepDTOResponse buscarDadosCep(@PathVariable String cep);
}
