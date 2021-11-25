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
public class CourseDto {
    private String name;
    private int price;
}