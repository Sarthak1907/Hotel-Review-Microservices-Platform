package com.sar.user.service.UserService.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {

    private String hotelId;
    private String name;
    private String location;
    private String about;

}
