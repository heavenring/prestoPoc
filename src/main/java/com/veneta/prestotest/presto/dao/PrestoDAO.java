package com.veneta.prestotest.presto.dao;

import com.veneta.prestotest.presto.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.ResultHandler;

import java.util.List;

@Mapper
public interface PrestoDAO {
    // List가 아닌 void이며, 한 줄씩 처리할 핸들러를 넘깁니다.
    void selectUser(ResultHandler<UserDTO> handler);
}
