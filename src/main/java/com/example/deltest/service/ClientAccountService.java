package com.example.deltest.service;

import com.example.deltest.exceptions.UserNotFoundException;
import com.example.deltest.model.ClientAccount;
import com.example.deltest.model.ClientRequest;
import com.example.deltest.model.ClientResponse;
import com.example.deltest.repository.ClientAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientAccountService {
    private final Logger logger = LoggerFactory.getLogger(ClientAccountService.class);
    private final ClientAccountRepository clientAccountRepository;

    public ClientAccountService(ClientAccountRepository clientAccountRepository) {
        this.clientAccountRepository = clientAccountRepository;
    }

    public ClientResponse createClientAccount(ClientRequest clientRequest) {
        ClientAccount account = new ClientAccount(clientRequest.getFullName(), clientRequest.getGender());
        return ClientResponse.fromClientAccount(clientAccountRepository.save(account));
    }

    public List<ClientResponse> getClientAccount() {
        return clientAccountRepository.findAll().stream().map(ClientResponse::fromClientAccount).toList();
    }

    public ClientResponse getClientAccountById(Long id) {
        return ClientResponse.fromClientAccount(clientAccountRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id.toString())));
    }

    @Transactional
    public ClientResponse updateClientAccount(Long id, ClientRequest clientRequest) {
        ClientAccount clientAccount = clientAccountRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id.toString()));
        clientAccount.setFullName(clientRequest.getFullName());
        clientAccount.setGender(clientRequest.getGender());
        return ClientResponse.fromClientAccount(clientAccountRepository.save(clientAccount));
    }

    @Transactional
    public void deleteClientAccount(Long id) {
        if (!clientAccountRepository.existsById(id)) {
            throw new UserNotFoundException(id.toString());
        }
        clientAccountRepository.deleteById(id);
    }
}