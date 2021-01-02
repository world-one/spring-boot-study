package com.example.study.demo.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties("fruit")
public class FruitProperty {
//    private List<Map> list;

    //POJO를 이용한 매핑
    private List<Fruit> list;

    private String colorName;
    // fruit.color-name
    // fruit.color_name
    // fruit.colorName
    // fruit.colorname
}
