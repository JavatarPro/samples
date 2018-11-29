/*
 * Copyright (c) 2018 Javatar LLC
 * All rights reserved.
 */

package pro.javatar.core.converter;

import org.mapstruct.Mapper;
import pro.javatar.core.domain.UserTO;
import pro.javatar.core.service.domain.UserBO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserTOConverter {

    UserTO toUserTO(UserBO bo);

    List<UserTO> toUserTOList(List<UserBO> list);

    UserBO toUserBO(UserTO user);
}
