package org.example.chessserver.auth.proxy;

import org.example.chessserver.entity.User;
import org.example.chessserver.service.AdminService;
import org.example.chessserver.user.Admin;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AdminServiceProxyTest {

    @Test
    void testLockUnlockWithAdmin() {
        User userEntity = new User();
        userEntity.setUsername("admin1");
        userEntity.setRole(org.example.chessserver.entity.Role.ADMIN);
        Admin admin = new Admin(userEntity);

        AdminService mockService = Mockito.mock(AdminService.class);
        AdminServiceProxy proxy = new AdminServiceProxy(mockService, admin);

        proxy.lockUser("player1");
        proxy.unlockUser("player1");

        Mockito.verify(mockService).lockUser("player1");
        Mockito.verify(mockService).unlockUser("player1");
    }

    @Test
    void testAccessDenied() {
        User userEntity = new User();
        userEntity.setUsername("player1");
        userEntity.setRole(org.example.chessserver.entity.Role.PLAYER);
        Admin admin = new Admin(userEntity);

        AdminService mockService = Mockito.mock(AdminService.class);
        AdminServiceProxy proxy = new AdminServiceProxy(mockService, admin);

        assertThrows(RuntimeException.class, () -> proxy.lockUser("player2"));
        assertThrows(RuntimeException.class, () -> proxy.unlockUser("player2"));
    }
}
