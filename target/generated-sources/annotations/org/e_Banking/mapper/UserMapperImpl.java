package org.e_Banking.mapper;

import javax.annotation.processing.Generated;

import org.e_Banking.dto.BankingRole;
import org.e_Banking.dto.UserDto;
import org.e_Banking.entity.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-18T14:23:23+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250526-2018, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl extends UserMapper {

    @Override
    public User toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setDob( dto.getDob() );
        user.setEmail( dto.getEmail() );
        user.setMobile( dto.getMobile() );
        user.setName( dto.getName() );

        user.setPassword( passwordEncoder.encode(dto.getPassword()) );
        user.setRole( BankingRole.valueOf(dto.getRole()) );

        return user;
    }

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setDob( user.getDob() );
        userDto.setEmail( user.getEmail() );
        userDto.setMobile( user.getMobile() );
        userDto.setName( user.getName() );
        if ( user.getRole() != null ) {
            userDto.setRole( user.getRole().name() );
        }

        userDto.setPassword( "***************" );

        return userDto;
    }
}
