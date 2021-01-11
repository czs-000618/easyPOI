package com.hncj.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;

@Data
@ExcelTarget("card")
public class Card implements Serializable {
    @Excel(name = "身份证号码",width = 20.0,orderNum = "0")
    private String no;

    @Excel(name = "居住地址",width = 40.0,orderNum = "1")
    private String address;
}
