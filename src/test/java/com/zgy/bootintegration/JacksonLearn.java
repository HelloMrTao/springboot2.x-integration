package com.zgy.bootintegration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;

/**
 * @Author renjiaxin
 * @Date 2020/7/6
 * @Description 我们所说的String， 都是符合json格式的string
 */
public class JacksonLearn {
    static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        // str -> obj
        String jsonStr = "{\"name\": \"北京\", \"province\": \"北京\", \"postCode\": \"010\", \"area\": 192345.9}";
        str2Obj(jsonStr);

        // obj -> str
        ChinaBigCity bigCity = ChinaBigCity.builder().name("南京").province("江苏").postCode("331908").area(189345.6f).build();
        obj2Str(bigCity);

        // obj -> 序列化为json file
        objWrite2JSON(bigCity);

        // json file 反序列化 -> obj
        File file = new File("chinabigcity.json");
        readJSON2Obj(file);


    }

    // str -> obj
    public static void str2Obj(String str) throws JsonProcessingException {
        ChinaBigCity city = mapper.readValue(str, ChinaBigCity.class);
        System.out.println(city.toString());
    }

    // obj -> str
    public static void obj2Str(Object obj) throws JsonProcessingException {
        String str = mapper.writeValueAsString(obj);
        System.out.println(str);
    }

    // obj 序列化为json文件
    public static void objWrite2JSON(Object obj) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("chinabigcity.json"), obj);
    }

    // obj 反序列化，从json文件中获取对象
    public static void readJSON2Obj(File file) throws IOException {
        ChinaBigCity city = mapper.readValue(file, ChinaBigCity.class);
        System.out.println(city.toString());
    }
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class ChinaBigCity{
    // 名字
    private String name;
    // 省份
    private String province;
    // 邮编
    private String postCode;
    // 面积
    private Float area;
}
