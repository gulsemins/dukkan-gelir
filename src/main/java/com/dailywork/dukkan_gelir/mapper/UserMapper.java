package com.dailywork.dukkan_gelir.mapper;


import com.dailywork.dukkan_gelir.dtos.RegisterRequestDto;
import com.dailywork.dukkan_gelir.dtos.UserResponseDto;
import com.dailywork.dukkan_gelir.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(RegisterRequestDto registerRequestDto);

    UserResponseDto toRegisterResponseDto(UserEntity user);


}
