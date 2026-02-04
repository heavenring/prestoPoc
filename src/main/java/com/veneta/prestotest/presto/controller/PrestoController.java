package com.veneta.prestotest.presto.controller;

import com.veneta.prestotest.presto.dto.UserDTO;
import com.veneta.prestotest.presto.service.PrestoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/presto")
@RequiredArgsConstructor
public class PrestoController {

    private final PrestoService prestoService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<UserDTO> getPresto() {

        return prestoService.selectUser();
    }
}
