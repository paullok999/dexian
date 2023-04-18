package com.kalok.dexian.chat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kalok.dexian.chat.api.entity.Admin;
import com.kalok.dexian.chat.service.AdminService;

import javax.annotation.Resource;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2020-06-16 11:35:59
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Admin selectOne(Integer id) {
        return this.adminService.queryById(id);
    }

}
