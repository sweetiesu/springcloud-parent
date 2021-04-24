package cn.lit.mapper;

import cn.lit.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 增加用户积分
     * @param user_id 用户id
     * @param point 要增加的分
     */
    void addPoint(@Param("userId") String user_id, @Param("point") int point);

    /**
     * 根据用户编号查询用户
     * @param userId 用户编号
     * @return 找到的用户bean
     */
    User queryUser(String userId);
}
