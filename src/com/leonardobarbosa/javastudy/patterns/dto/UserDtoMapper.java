package com.leonardobarbosa.javastudy.patterns.dto;

public class UserDtoMapper {

    public static UserDto toDto(User user, Adress adress) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                adress.getCity(),
                adress.getState());
    }
}
