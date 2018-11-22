package org.apache.songsy.mapper;

import org.apache.songsy.entity.User;

/**
 * 用户
 * @author songshuiyang
 */
public interface UserMapper {
    User selectByPrimaryKey(Integer id);

    int insertSelective(User user);

    int updateByPrimaryKeySelective (User user);


}