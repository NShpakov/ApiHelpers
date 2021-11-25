
package ru.nshpakov.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.ParametersAreNonnullByDefault;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
@ParametersAreNonnullByDefault
public class UserDto {
    private Long age;
    private String cource;
    private String email;
    private String name;

}