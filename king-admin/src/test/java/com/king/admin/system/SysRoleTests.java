package com.king.admin.system;

import com.king.system.pojo.SysRole;
import com.king.system.service.SysRoleServiceI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class SysRoleTests {
    @Autowired
    private SysRoleServiceI sysRoleService;

    @Test
    void test4Create() {
        SysRole sysRole = new SysRole();

        sysRole.setName("sdf");
        sysRole.setCreateUserId("king");
        sysRole.setUpdateUserId("king");

        boolean result = sysRoleService.create(sysRole);

        System.out.println(result);
    }

    @Test
    void test4CreateBatch() {
        List<SysRole> sysRoles = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            SysRole sysRole = new SysRole();

            sysRole.setName("name" + i);

            sysRoles.add(sysRole);
        }

        boolean result = sysRoleService.createBatch(sysRoles);

        System.out.println(result);
    }

    @Test
    void test4DeleteByPk() {
        SysRole sysRole = new SysRole();
        sysRole.setId("a5ce9a4c-5d21-41ec-8772-dee8052f12e1");

        boolean result = sysRoleService.deleteByPk(sysRole);

        System.out.println(result);
    }

    @Test
    void test4DeleteBatch() {
        List<SysRole> sysRoles = new LinkedList<>();

        SysRole sysRole1 = new SysRole();
        sysRole1.setId("0dc9ebf0-7c77-4782-8ecc-4aa302c41da6");

        SysRole sysRole2 = new SysRole();
        sysRole2.setId("ca102a8f-ab14-40d1-af1b-c02c6c02593f");

        sysRoles.add(sysRole1);
        sysRoles.add(sysRole2);

        boolean result = sysRoleService.deleteBatch(sysRoles);

        System.out.println(result);
    }

    @Test
    void test4UpdateByPk() {
        SysRole sysRole = new SysRole();

        sysRole.setId("081a3a52-f286-4602-a4ac-fa589b1aad25");
        sysRole.setName("aaaaaaaaaaaaaaaaaa");

        boolean result = sysRoleService.updateByPk(sysRole);

        System.out.println(result);
    }

    @Test
    void test4UpdateDeleteFlag() {
        SysRole sysRole = new SysRole();

        sysRole.setId("081a3a52-f286-4602-a4ac-fa589b1aad25");
        sysRole.setDeleteFlag(1);

        boolean result = sysRoleService.updateDeleteFlag(sysRole);

        System.out.println(result);
    }

    @Test
    void test4Read4DetailByPk() {
        SysRole sysRole = new SysRole();

        sysRole.setId("081a3a52-f286-4602-a4ac-fa589b1aad25");

        SysRole result = sysRoleService.read4DetailByPk(sysRole);

        System.out.println(result);
    }

    @Test
    void test4Read4List() {
        SysRole sysRole = new SysRole();
//        sysRole.setDeleteFlag(0);
        sysRole.setName("aaaaaaaaaaaaaaaaaa");

        System.out.println(sysRole);

        List<SysRole> sysRoles = sysRoleService.read4List(sysRole);

        System.out.println(sysRoles);
    }

    @Test
    void test4Read4Count() {
        SysRole sysRole = new SysRole();
        sysRole.setDeleteFlag(0);

        int result = sysRoleService.read4Count(sysRole);

        System.out.println(result);
    }

}
