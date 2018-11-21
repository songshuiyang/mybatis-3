package org.apache.songsy.mapper;

import org.apache.songsy.entity.User;

/**
 * 用户
 * @author songshuiyang
 */
public interface UserMapper {
    User selectByPrimaryKey(Integer id);
}