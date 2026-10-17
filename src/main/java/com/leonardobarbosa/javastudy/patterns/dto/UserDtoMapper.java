package com.leonardobarbosa.javastudy.patterns.dto;

public final class UserDtoMapper {

    private UserDtoMapper() {
    }

    public static UserDto toDto(User user, Address address) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                address.getCity(),
                address.getState());
    }
}
