package com.example.demo.mapper;

import com.example.demo.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    public List<Role> selectRoleByUserid(String id);
}
