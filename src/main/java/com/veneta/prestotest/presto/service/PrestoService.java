package com.veneta.prestotest.presto.service;

import com.veneta.prestotest.presto.dto.UserDTO;
import reactor.core.publisher.Flux;

public interface PrestoService {

    /** 사용자 조회 */
    Flux<UserDTO> selectUser();
}
