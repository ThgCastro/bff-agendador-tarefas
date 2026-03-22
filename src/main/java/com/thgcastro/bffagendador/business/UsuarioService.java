package com.thgcastro.bffagendador.business;

import com.thgcastro.bffagendador.business.dto.in.EnderecoDTORequest;
import com.thgcastro.bffagendador.business.dto.in.LoginRequestDTO;
import com.thgcastro.bffagendador.business.dto.in.TelefoneDTORequest;
import com.thgcastro.bffagendador.business.dto.in.UsuarioDTORequest;
import com.thgcastro.bffagendador.business.dto.out.EnderecoDTOResponse;
import com.thgcastro.bffagendador.business.dto.out.TelefoneDTOResponse;
import com.thgcastro.bffagendador.business.dto.out.UsuarioDTOResponse;
import com.thgcastro.bffagendador.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO){
        return usuarioClient.savaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequestDTO dto){
        return usuarioClient.login(dto);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token) {
        return usuarioClient.buscarUsuarioPorEmail(email, token);
    }

    public void deletarUsuarioPorEmail(String email, String token){
        usuarioClient.deletarUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token , UsuarioDTORequest usuarioDTO){
        return usuarioClient.atualizaDadosUsuario(usuarioDTO, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token){
        return usuarioClient.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest telefoneDTO, String token){
        return usuarioClient.atualizaTelefone(telefoneDTO, idTelefone, token);
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest enderecoDTO){
        return usuarioClient.cadastraEndereco(enderecoDTO, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest telefoneDTO){
        return usuarioClient.cadastraTelefone(telefoneDTO, token);
    }

}
