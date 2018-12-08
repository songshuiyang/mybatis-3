package org.apache.songsy.mapper;

import org.apache.songsy.entity.User;

import java.util.List;

/**
 * 用户
 * @author songshuiyang
 */
public interface UserMapper {
    User selectByPrimaryKey(Integer id);

    List<User> selectSelective(User user);

    int insertSelective(User user);

    int updateByPrimaryKeySelective (User user);


}