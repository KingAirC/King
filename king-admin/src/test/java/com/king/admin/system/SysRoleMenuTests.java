package com.king.admin.system;

import com.king.system.pojo.SysRoleMenu;
import com.king.system.service.SysRoleMenuServiceI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class SysRoleMenuTests {

    @Autowired
    private SysRoleMenuServiceI sysRoleMenuService;

    @Test
    void test4Create() {
        SysRoleMenu sysRoleMenu = new SysRoleMenu();

        sysRoleMenu.setMenuId("menu3");
        sysRoleMenu.setRoleId("role2");
        sysRoleMenu.setCreateUserId("sadf");

        boolean result = sysRoleMenuService.create(sysRoleMenu);

        System.out.println(result);
    }

    @Test
    void test4createBatch() {
        List<SysRoleMenu> sysRoleMenus = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();

            sysRoleMenu.setRoleId("r" + i);
            sysRoleMenu.setMenuId("m" + i);

            sysRoleMenus.add(sysRoleMenu);
        }

        boolean result = sysRoleMenuService.createBatch(sysRoleMenus);

        System.out.println(result);
    }

    @Test
    void test4DeleteByPk() {
        SysRoleMenu sysRoleMenu = new SysRoleMenu();

        sysRoleMenu.setMenuId("m0");
        sysRoleMenu.setRoleId("r0");

        boolean result = sysRoleMenuService.deleteByPk(sysRoleMenu);

        System.out.println(result);
    }

    @Test
    void test4DeleteBatchByRoleId() {
        SysRoleMenu sysRoleMenu = new SysRoleMenu();

        sysRoleMenu.setRoleId("role2");

        boolean result = sysRoleMenuService.deleteBatchByRoleId(sysRoleMenu);

        System.out.println(result);
    }

    @Test
    void test4deleteBatchByMenuId() {
        SysRoleMenu sysRoleMenu = new SysRoleMenu();

        sysRoleMenu.setMenuId("m1");

        boolean result = sysRoleMenuService.deleteBatchByMenuId(sysRoleMenu);

        System.out.println(result);
    }
}
