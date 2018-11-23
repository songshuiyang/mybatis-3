package org.apache.songsy.mapper;

import org.apache.songsy.entity.Role;
import org.apache.songsy.entity.User;

/**
 * 用户
 * @author songshuiyang
 */
public interface RoleMapper {
    Role selectByPrimaryKey(Integer id);

    int insertSelective(Role user);

    int updateByPrimaryKeySelective(Role user);


}