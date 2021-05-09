package com.leiduoduo.abss.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Accessors
public class Sort {
    private int id;
    private String sortCode;
    private String sortName;
    private String createAt;
    private String updateAt;
    private int exist;
}
