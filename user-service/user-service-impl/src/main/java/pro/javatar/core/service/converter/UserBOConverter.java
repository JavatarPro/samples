/*
 * Copyright (c) 2018 Javatar LLC
 * All rights reserved.
 */

package pro.javatar.core.service.converter;

import org.mapstruct.Mapper;
import pro.javatar.core.repository.domain.UserPO;
import pro.javatar.core.service.domain.UserBO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserBOConverter {
    UserBO toUserBO(UserPO po);

    UserPO toUserPO(UserBO bo);

    List<UserBO> toUserBOList(List<UserPO> list);
}
