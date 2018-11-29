/*
 * Copyright (c) 2018 Javatar LLC
 * All rights reserved.
 */

package pro.javatar.core.repository.converter;

import org.mapstruct.Mapper;
import pro.javatar.core.repository.domain.UserEntity;
import pro.javatar.core.repository.domain.UserPO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserEntityConverter {

    UserPO toUserPO(UserEntity entity);

    UserEntity toUserEntity(UserPO po);

    List<UserPO> toUserPOList(List<UserEntity> list);
}
