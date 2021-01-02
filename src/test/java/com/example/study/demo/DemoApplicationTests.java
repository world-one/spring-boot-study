package com.example.study.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
    value = "value=test",
//    properties = {
//    "property.value=propertyTest"
//    },
    classes = {
        DemoApplication.class
    },
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class DemoApplicationTests {
// application.yml의 property
//    @Value("${property.test.name}")
//    private String propertyTestName;
//
//    @Value("${propertyTest}")
//    private String propertyTest;
//
//    @Value("${noKey:default value}")
//    private String defaultValue;
//
//    @Value("${propertyTestList}")
//    private String[] propertyTestArray;
//
//    @Value("#{'${propertyTestList}'.split(',')}")
//    private List<String> propertyTestList;
//
//    @Test
//    public void testValue() {
//        assertThat(propertyTestName, is("property depth test"));
//        assertThat(propertyTest, is("test"));
//        assertThat(defaultValue, is("default value"));
//
//        assertThat(propertyTestArray[0], is("a"));
//
//        assertThat(propertyTestList.get(0), is("a"));
//
//    }

    @Value("${value}")
    private String value;

//    @Value("${property.value}")
//    private String propertyValue;

    @Test
    void contextLoads() {
        assertThat(value, is("test"));
//        assertThat(propertyValue, is("propertyTest"));
    }

}
