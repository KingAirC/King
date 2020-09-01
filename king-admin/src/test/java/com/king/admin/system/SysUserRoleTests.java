package com.king.admin.system;

import com.king.system.pojo.SysUserRole;
import com.king.system.service.SysUserRoleServiceI;
import com.sun.org.apache.bcel.internal.generic.LLOAD;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class SysUserRoleTests {
    @Autowired
    private SysUserRoleServiceI sysUserRoleService;

    @Test
    void test4Create() {
        SysUserRole sysUserRole = new SysUserRole();

        sysUserRole.setRoleId("r2");
        sysUserRole.setUserId("u1");
        sysUserRole.setCreateUserId("king");

        boolean result = sysUserRoleService.create(sysUserRole);

        System.out.println(result);
    }

    @Test
    void test4CreateBatch() {
        List<SysUserRole> sysUserRoles = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            SysUserRole sysUserRole = new SysUserRole();

            sysUserRole.setUserId("user" + i);
            sysUserRole.setRoleId("role" + i);

            sysUserRoles.add(sysUserRole);
        }

        boolean result = sysUserRoleService.createBatch(sysUserRoles);

        System.out.println(result);
    }

    @Test
    void test4DeleteByPk() {
        SysUserRole sysUserRole = new SysUserRole();

        sysUserRole.setRoleId("r1");
        sysUserRole.setUserId("u1");

        boolean result = sysUserRoleService.deleteByPk(sysUserRole);

        System.out.println(result);
    }

    @Test
    void test4DeleteBatchByUserId() {
        SysUserRole sysUserRole = new SysUserRole();

        sysUserRole.setUserId("u1");

        boolean result = sysUserRoleService.deleteBatchByUserId(sysUserRole);

        System.out.println(result);
    }

    @Test
    void test4DeleteBatchByRoleId() {
        SysUserRole sysUserRole = new SysUserRole();

        sysUserRole.setRoleId("r1");

        boolean result = sysUserRoleService.deleteBatchByRoleId(sysUserRole);

        System.out.println(result);
    }
}
