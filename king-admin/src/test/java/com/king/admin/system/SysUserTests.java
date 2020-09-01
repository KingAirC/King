package com.king.admin.system;

import com.king.system.pojo.SysUser;
import com.king.system.service.SysUserServiceI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class SysUserTests {
    @Autowired
    private SysUserServiceI sysUserService;

    @Test
    void test4Create() {
        SysUser sysUser = new SysUser();

        sysUser.setLoginName("loginName1");
//        sysUser.setRealName("realName1");
//        sysUser.setPasswordText("pt1");
//        sysUser.setPasswordEncrypt("pe1");
//        sysUser.setSalt("salt1");
        sysUser.setTel("tel1");
        sysUser.setBirthday("b1");
        sysUser.setGender(0);
        sysUser.setSignature("sig1");
        sysUser.setQq("qq1");
        sysUser.setCreateUserId("cui1");
        sysUser.setUpdateUserId("uui1");
        sysUser.setDeleteFlag(0);

        boolean result = sysUserService.create(sysUser);

        System.out.println(result);
    }

    @Test
    void test4CreateBatch() {
        List<SysUser> sysUsers = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            SysUser sysUser = new SysUser();

            sysUser.setLoginName("loginName" + i);
            sysUser.setRealName("realName" + i);
            sysUser.setPasswordText("pt" + i);
//            sysUser.setPasswordEncrypt("pe" + i);
//            sysUser.setSalt("salt" + i);
//            sysUser.setTel("tel" + i);
//            sysUser.setBirthday("b" + i);
            sysUser.setGender(i < 5 ? 0 : 1);
            sysUser.setSignature("sig" + i);
            sysUser.setQq("qq" + i);
            sysUser.setCreateUserId("cui" + i);
            sysUser.setUpdateUserId("uui" + i);
            sysUser.setDeleteFlag(0);

            sysUsers.add(sysUser);
        }

        boolean result = sysUserService.createBatch(sysUsers);

        System.out.println(result);
    }

    @Test
    void test4DeleteByPk() {
        SysUser sysUser = new SysUser();

        sysUser.setId("0b097f5c-7eb2-4707-8ead-cf310cf3e873");

        boolean result = sysUserService.deleteByPk(sysUser);

        System.out.println(result);
    }

    @Test
    void test4deleteBatch() {
        List<SysUser> sysUsers = new LinkedList<>();

        SysUser sysUser1 = new SysUser();
        sysUser1.setId("01e3da0e-3ac5-4083-9cc4-f7ec60012c49");

        SysUser sysUser2 = new SysUser();
        sysUser2.setId("124ce9d0-d0d3-4d1a-ac88-c07490846321");

        sysUsers.add(sysUser1);
        sysUsers.add(sysUser2);

        boolean result = sysUserService.deleteBatch(sysUsers);

        System.out.println(result);
    }

    @Test
    void test4UpdateByPk() {
        SysUser sysUser = new SysUser();

        sysUser.setId("28cacb63-7494-4749-87a1-7116cda9026c");
        sysUser.setLoginName("aaaaaaaaaaaaaa");
        sysUser.setRealName("aaaaaaaaaaaaaaa");
        sysUser.setPasswordText("aaaaaaaaaaaaaaaaaaa");
        sysUser.setPasswordEncrypt("aaaaaaaaaaaaaaa");
//        sysUser.setSalt("salt");
//        sysUser.setTel("tel");
//        sysUser.setBirthday("b");
//        sysUser.setGender(1);
//        sysUser.setSignature("sig");
//        sysUser.setQq("qq");
//        sysUser.setCreateUserId("cui");
        sysUser.setUpdateUserId("king");
//        sysUser.setDeleteFlag(0);

        boolean result = sysUserService.updateByPk(sysUser);

        System.out.println(result);
    }

    @Test
    void test4UpdateDeleteFlag() {
        SysUser sysUser = new SysUser();

        sysUser.setId("48239f40-bcad-4664-a5fa-05dbeea78460");
        sysUser.setDeleteFlag(1);

        boolean result = sysUserService.updateDeleteFlag(sysUser);

        System.out.println(result);
    }

    @Test
    void test4Read4DetailByPk() {
        SysUser sysUser = new SysUser();

        sysUser.setId("48239f40-bcad-4664-a5fa-05dbeea78460");

        SysUser result = sysUserService.read4DetailByPk(sysUser);

        System.out.println(result);
    }

    @Test
    void test4Read4List() {
        SysUser sysUser = new SysUser();

//        sysUser.setLoginName("loginName1");
//        sysUser.setRealName("realName1");
//        sysUser.setPasswordText("pt1");
//        sysUser.setPasswordEncrypt("pe1");
//        sysUser.setSalt("salt1");
//        sysUser.setTel("tel1");
//        sysUser.setBirthday("b1");
        sysUser.setGender(0);
//        sysUser.setSignature("sig1");
//        sysUser.setQq("qq1");
//        sysUser.setCreateUserId("cui1");
//        sysUser.setUpdateUserId("uui1");
//        sysUser.setDeleteFlag(0);

        List<SysUser> result = sysUserService.read4List(sysUser);

        System.out.println(result);
    }

    @Test
    void test4Read4Count() {
        SysUser sysUser = new SysUser();

//        sysUser.setLoginName("loginName1");
//        sysUser.setRealName("realName1");
//        sysUser.setPasswordText("pt1");
//        sysUser.setPasswordEncrypt("pe1");
//        sysUser.setSalt("salt1");
//        sysUser.setTel("tel1");
//        sysUser.setBirthday("b1");
        sysUser.setGender(1);
//        sysUser.setSignature("sig1");
//        sysUser.setQq("qq1");
//        sysUser.setCreateUserId("cui1");
//        sysUser.setUpdateUserId("uui1");
//        sysUser.setDeleteFlag(0);

        int result = sysUserService.read4Count(sysUser);

        System.out.println(result);
    }

}
