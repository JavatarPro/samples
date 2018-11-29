/*
 * Copyright (c) 2018 Javatar LLC
 * All rights reserved.
 */

package pro.javatar.core.repository;


import pro.javatar.core.repository.domain.UserPO;
import pro.javatar.core.repository.exception.UserNotFoundDBException;

import java.util.List;

public interface UserRepository {
    UserPO findById(Long id) throws UserNotFoundDBException;
    UserPO findByLogin(String login) throws UserNotFoundDBException;
    UserPO findByEmail(String email) throws UserNotFoundDBException;
    UserPO save(UserPO user);
    List<UserPO> findAll();
    void delete(Long userId);
}