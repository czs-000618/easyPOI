package com.hncj;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.hncj.entity.Card;
import com.hncj.entity.Emp;
import com.hncj.entity.Order;
import com.hncj.entity.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class testPOI {
    public List<User> getUsers(){
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setName("czs_"+i);
            user.setAge(10+i);
            user.setBir(new Date());

            Card card = new Card();
            card.setNo("00000000");
            card.setAddress("asdafasfad");

            user.setCard(card);

            List<Order> orders = new ArrayList<>();
            orders.add(new Order("12","commodity"));
            orders.add(new Order("13","commodity"));
            orders.add(new Order("14","commodity"));
            user.setOrders(orders);

            user.setPhoto("C:\\Users\\Admin\\Desktop\\QQ截图20210111191357.png");

            if(i%2==0){
                user.setStatus("1");
                user.setHobbys(Arrays.asList("篮球","看书"));
            }else{
                user.setStatus("0");
                user.setHobbys(Arrays.asList("喝酒","抽烟"));
            }
            users.add(user);
        }
        return users;
    }

    @Test
    public void testExport() throws IOException {
        List<User> users = getUsers();
        //导出excel
        //参数1:exportParams 导出配置对象  参数2:导出的类型  参数3:导出数据集合
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息列表", "用户信息"), User.class, users);

        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Admin\\Desktop\\aa.xls");
        workbook.write(outputStream);

        outputStream.close();
        workbook.close();
    }

    public void testImport() throws Exception {
        ImportParams importParams = new ImportParams();
        importParams.setTitleRows(1);
        importParams.setHeadRows(1);
        importParams.setNeedSave(true);
        importParams.setSaveUrl("C:\\Users\\Admin\\Desktop\\easypoi\\src\\main\\images");
        importParams.setImportFields(new String[]{"编号","状态"});//判断导入excel是否包含这两列
        List<Emp> emps = ExcelImportUtil.importExcel(new FileInputStream("C:\\Users\\Admin\\Desktop\\emp.xls"), Emp.class, importParams);
        emps.forEach(System.out::println);
    }

}
