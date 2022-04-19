package com.kuang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kuang.pojo.User;
import org.springframework.stereotype.Repository;

@Repository //代表持久层
public interface UserMapper extends BaseMapper<User> {

//    IPage<User> selectPageVo(IPage<?> page, Integer state);
//    // or (class MyPage extends Ipage<UserVo>{ private Integer state; })
//    MyPage selectPageVo(MyPage page);
//    // or
//    List<UserVo> selectPageVo(IPage<UserVo> page, Integer state);


}
