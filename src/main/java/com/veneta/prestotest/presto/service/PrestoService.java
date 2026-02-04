package com.veneta.prestotest.presto.service;

import com.veneta.prestotest.presto.dto.UserDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

public interface PrestoService {

    /** 사용자 조회 */
    Flux<UserDTO> selectUser();
}
