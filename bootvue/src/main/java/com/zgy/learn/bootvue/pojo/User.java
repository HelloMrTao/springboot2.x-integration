package com.zgy.learn.bootvue.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author: renjiaxin
 * @Despcription:
 * @Date: Created in 2020/8/5 1:12
 * @Modified by: 用户的类
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
@Accessors(chain = true) //链式调用
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Double salary;
    private String phoneCode;
}


