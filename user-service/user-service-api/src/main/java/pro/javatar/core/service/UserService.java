/*
 * Copyright (c) 2018 Javatar LLC
 * All rights reserved.
 */

package pro.javatar.core.service;


import pro.javatar.core.service.domain.UserBO;
import pro.javatar.core.service.exception.UserNotFoundServiceException;

import java.util.List;

public interface UserService {
    UserBO findById(Long id) throws UserNotFoundServiceException;
    UserBO findByLogin(String login) throws UserNotFoundServiceException;
    UserBO findByEmail(String email) throws UserNotFoundServiceException;
    UserBO save(UserBO user);
    void delete(Long id);
    List<UserBO> findAll();
}