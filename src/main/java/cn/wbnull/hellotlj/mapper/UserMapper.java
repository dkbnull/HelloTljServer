package cn.wbnull.hellotlj.mapper;

import cn.wbnull.hellotlj.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author dukunbiao(null) 2020-02-05
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    List<User> selectByUsername(@Param("username") String username);
}
