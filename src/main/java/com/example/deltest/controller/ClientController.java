package com.example.deltest.controller;

import com.example.deltest.model.ClientRequest;
import com.example.deltest.model.ClientResponse;
import com.example.deltest.service.ClientAccountService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final Logger logger = LoggerFactory.getLogger(ClientController.class);
    private final ClientAccountService clientAccountService;

    public ClientController(ClientAccountService clientAccountService) {
        this.clientAccountService = clientAccountService;
    }

    @PostMapping
    public ResponseEntity<ClientResponse> addClient(@RequestBody @Valid ClientRequest client) {
        ClientResponse clientResponse = clientAccountService.createClientAccount(client);
        URI location = URI.create("/api/clients/" + clientResponse.getId());
        return ResponseEntity.created(location).body(clientResponse);
    }

    @GetMapping
    public List<ClientResponse> getAllClients() {
        return clientAccountService.getClientAccount();
    }

    @GetMapping("/{id}")
    public ClientResponse getClientById(@PathVariable Long id) {
        return clientAccountService.getClientAccountById(id);
    }

    @PutMapping("/{id}")
    public ClientResponse updateClient(@PathVariable("id") long id, @RequestBody @Valid ClientRequest clientRequest) {
        return clientAccountService.updateClientAccount(id, clientRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable("id") long id) {
        clientAccountService.deleteClientAccount(id);
    }
}
