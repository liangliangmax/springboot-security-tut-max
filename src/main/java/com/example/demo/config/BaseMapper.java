package com.example.demo.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 这个是tkmybatis的通用配置类，不能和别的Mapper类放在一起，否则会报错
 * 使用的时候别的Mapper类继承这个接口即可
 * @param <T>
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
