package cn.lit.service;

public interface UserService {
    /**
     * 查询用户积分
     * @return 查询到的用户积分
     */
    int queryPoint(String userId);

    void addPoint(String userId, Integer money);
}
