package com.hncj.entity;

import cn.afterturn.easypoi.excel.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ExcelTarget("users")
public class User implements Serializable {

    @Excel(name = "编号",orderNum = "0")
    private String id;
    @Excel(name = "姓名",orderNum = "1")
    private String name;
    @Excel(name = "年龄",orderNum = "3",suffix = "~~")
    private Integer age;
    @Excel(name = "生日",orderNum = "2",width = 35.0,format = "yyyy-MM-dd HH:mm:ss")
    private Date bir;
    @Excel(name = "状态",orderNum = "4",replace = {"激活_1","锁定_0"})
    private String status;

    @ExcelIgnore
    private List<String> hobbys;
    @Excel(name = "爱好",orderNum = "5",width = 20.0)
    private String hobbyStr;

    public String getHobbyStr(){
        StringBuilder stringBuilder = new StringBuilder();
        hobbys.forEach(e->{
            stringBuilder.append(e).append("、");
        });
        return stringBuilder.toString();
    }

    @ExcelEntity
    private Card card;

    @ExcelCollection(name = "订单列表",orderNum = "8")
    private List<Order> orders;

    @Excel(name = "头像",width = 20,type = 2,imageType = 1)
    private String photo;

}
