package cn.lit.service;

import cn.lit.domain.User;
import cn.lit.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper = null;

    public int queryPoint(String userId) {
        User user = userMapper.queryUser(userId);
        return user.getPoints();
    }

    @Override
    public void addPoint(String userId, Integer money) {
        userMapper.addPoint(userId,money);
    }
}
