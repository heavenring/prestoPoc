package com.veneta.prestotest.presto.service;

import com.veneta.prestotest.presto.dto.UserDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PrestoService {

    /** 사용자 조회 */
    Flux<UserDTO> selectUser();

    /** 리턴 타입을 String으로 지정 ("success" 반환용) */
    Mono<String> updateUserName(String oldName, String newName);
}
