package com.king.admin.system;

import com.king.system.pojo.SysMenu;
import com.king.system.service.SysMenuServiceI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class SysMenuTests {

    @Autowired
    private SysMenuServiceI sysMenuService;

    @Test
    void test4SysMenuCreate() {
        SysMenu sysMenu = new SysMenu();

        sysMenu.setName("name");
//        sysMenu.setPid("1");
        sysMenu.setHref("hr");
        sysMenu.setRemark("re");
//        sysMenu.setIcon("ic");
//        sysMenu.setSort(2);
//        sysMenu.setTarget("ta");
//        sysMenu.setType("ty");
        sysMenu.setPermission("per");
        sysMenu.setCreateUserId("cui");
        sysMenu.setUpdateUserId("uui");

        boolean result = sysMenuService.create(sysMenu);

        System.out.println(result);
    }

    @Test
    void test4CreateBatch() {
        List<SysMenu> list = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            SysMenu sysMenu = new SysMenu();

            sysMenu.setName("name" + i);
//            sysMenu.setPid(i + "");
            sysMenu.setHref("hr" + i);
            sysMenu.setRemark("re" + i);
//            sysMenu.setIcon("ic" + i);
            sysMenu.setSort(i);
//            sysMenu.setTarget("ta" + i);
//            sysMenu.setType("ty" + i);
//            sysMenu.setPermission("per" + i);
            sysMenu.setCreateUserId("cui" + i);
            sysMenu.setUpdateUserId("uui" + i);
            sysMenu.setDeleteFlag(0);

            list.add(sysMenu);
        }

        boolean result = sysMenuService.createBatch(list);

        System.out.println(result);
    }

    @Test
    void test4DeleteByPk() {
        SysMenu sysMenu = new SysMenu();

        sysMenu.setId("d26b45ae-5f56-4914-8547-098e07b5d416");

        boolean result = sysMenuService.deleteByPk(sysMenu);

        System.out.println(result);
    }

    @Test
    void test4DeleteBatch() {
        List<SysMenu> menus = new LinkedList<>();

        SysMenu sysMenu1 = new SysMenu();
        sysMenu1.setId("dbcdd825-6367-4ac5-94d5-f7607dff1f10");

        SysMenu sysMenu2 = new SysMenu();
        sysMenu2.setId("e9b0875c-9a17-4614-bfcb-f557ce40490d");

        menus.add(sysMenu1);
        menus.add(sysMenu2);

        boolean result = sysMenuService.deleteBatch(menus);
        System.out.println(result);
    }

    @Test
    void test4UpdateByPk() {
        SysMenu sysMenu = new SysMenu();

        sysMenu.setId("16a92064-8287-429e-989b-4f84e3ecc9ec");
        sysMenu.setName("king");
//        sysMenu.setPid("");
        sysMenu.setHref("aaaaaaaaaaa");
        sysMenu.setRemark("aaaaaaaaaaaaa");
        sysMenu.setIcon("aaaaaaaaaaaaaaaa");
//        sysMenu.setSort(2);
        sysMenu.setTarget("aaaaaaaaaaaa");
        sysMenu.setType("ty");
        sysMenu.setPermission("aaaaaaaaaaaaaaaaa");
//        sysMenu.setCreateUserId("cui");
//        sysMenu.setUpdateUserId("uui");

        boolean result = sysMenuService.updateByPk(sysMenu);

        System.out.println(result);
    }

    @Test
    void test4UpdateDeleteFlag() {
        SysMenu sysMenu = new SysMenu();

        sysMenu.setId("16a92064-8287-429e-989b-4f84e3ecc9ec");
        sysMenu.setDeleteFlag(1);

        boolean result = sysMenuService.updateDeleteFlag(sysMenu);

        System.out.println(result);
    }

    @Test
    void test4Read4DetailByPk() {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setId("16a92064-8287-429e-989b-4f84e3ecc9ec");

        SysMenu result = sysMenuService.read4DetailByPk(sysMenu);

        System.out.println(result);
    }

    @Test
    void test4Read4List() {
        SysMenu sysMenu = new SysMenu();

        sysMenu.setTarget("_self");

        List<SysMenu> result = sysMenuService.read4List(sysMenu);

        System.out.println(result);
    }

    @Test
    void test4Read4Count() {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setTarget("_self");
        sysMenu.setDeleteFlag(0);

        int result = sysMenuService.read4Count(sysMenu);

        System.out.println(result);
    }

}
