package cn.wbnull.hellotlj.mapper;

import cn.wbnull.hellotlj.entity.Gametable;
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
public interface GametableMapper extends BaseMapper<Gametable> {

    List<Gametable> selectByTableId(@Param("tableId") String tableId);

    List<Gametable> selectByTableIdAndUserId(@Param("tableId") String tableId, @Param("userId") String userId);
}
