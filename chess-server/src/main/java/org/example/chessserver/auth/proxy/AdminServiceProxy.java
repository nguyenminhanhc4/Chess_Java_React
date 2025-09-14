package org.example.chessserver.auth.proxy;

import org.example.chessserver.service.AdminService;
import org.example.chessserver.user.Admin;

public class AdminServiceProxy {

    private final AdminService adminService;
    private final Admin admin;

    public AdminServiceProxy(AdminService adminService, Admin admin) {
        this.adminService = adminService;
        this.admin = admin;
    }

    public void lockUser(String username) {
        if(admin.getUserEntity().getRole().name().equals("ADMIN")) {
            adminService.lockUser(username);
        } else {
            throw new RuntimeException("Access denied. Not admin.");
        }
    }

    public void unlockUser(String username) {
        if(admin.getUserEntity().getRole().name().equals("ADMIN")) {
            adminService.unlockUser(username);
        } else {
            throw new RuntimeException("Access denied. Not admin.");
        }
    }
}
