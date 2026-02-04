package com.veneta.prestotest.presto.service;

import com.veneta.prestotest.presto.dao.PrestoDAO;
import com.veneta.prestotest.presto.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrestoServiceImpl implements PrestoService{

    private final PrestoDAO prestoDAO;
    private final Scheduler prestoScheduler;

    @Override
    public Flux<UserDTO> selectUser() {

        // JDBC는 기본적으로 동기 방식이기 때문에
        // 별도의 스레드 풀 사용
        return Flux.<UserDTO>create(sink -> {
            try {
                // DB에서 한 줄 읽을 때마다 sink.next()로 스트림에 태움
                prestoDAO.selectUser(context -> {
                    sink.next(context.getResultObject());
                });
                // DB 조회 종료
                sink.complete();
            } catch (Exception e) {
                // sink 중 Error 처리
                sink.error(e);
            }
        }).subscribeOn(prestoScheduler);
    }
}
