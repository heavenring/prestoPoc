package com.veneta.prestotest.presto.controller;

import com.veneta.prestotest.presto.dto.UserDTO;
import com.veneta.prestotest.presto.service.PrestoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/presto")
@RequiredArgsConstructor
public class PrestoController {

    private final PrestoService prestoService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<UserDTO> getPresto() {

        return prestoService.selectUser();
    }

    @GetMapping("/update")
    public Mono<String> updateUser(@RequestParam String userName, @RequestParam String newUserName) {

        return prestoService.updateUserName(userName, newUserName);
    }
}
