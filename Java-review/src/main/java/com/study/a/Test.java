package com.study.a;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class Test {
    public static void main(String[] args) {
       /* Clock clock = Clock.systemUTC();
        System.out.println(clock.millis());
        long millis = clock.millis();
        System.out.println(String.valueOf(millis));
        LocalDate now = LocalDate.now(clock);
        System.out.println(now.toString().replaceAll("\\-", ""));

        BigDecimal value = BigDecimal.valueOf(Double.parseDouble("0.01"));
        System.out.println(value.multiply(BigDecimal.valueOf(3)));
        Integer aa = 3;
        System.out.println(aa.byteValue());*/

        String s = "{\"price_value\":\"\",\"price\":\"1\",\"memberBand\":\"\",\"app_case\":\"洲际集团   深圳华侨城洲际酒店\\r\\n万豪集团 \"}";
        String ss = "[{\"sepc\":\"1.5m米\",\"color\":\"黑色\",\"product_spec\":[{\"fileid\":\"WU_FILE_2\",\"type\":\"ProductPricePath\",\"name\":\"64126677_p0.png\",\"url\":\"/upload/product/main/efe743feba994e18acd2fbfc9d7f4a2c.png\"}],\"price_value\":\"21\",\"project_price\":\"0.01\",\"min_num\":\"3\",\"memberBand\":\"3376\"},{\"sepc\":\"1.5m米\",\"color\":\"白色\",\"product_spec\":[{\"fileid\":\"WU_FILE_3\",\"type\":\"ProductPricePath\",\"name\":\"64126677_p0.png\",\"url\":\"/upload/product/main/6eb0e14589af4beb8afc826e6e4fbccb.png\"}],\"price_value\":\"212\",\"project_price\":\"0.01\",\"min_num\":\"3\",\"memberBand\":\"3376\"},{\"sepc\":\"1.8米\",\"color\":\"黑色\",\"product_spec\":[{\"fileid\":\"WU_FILE_4\",\"type\":\"ProductPricePath\",\"name\":\"64126677_p0.png\",\"url\":\"/upload/product/main/e3b9efc0e7074916955e17d4ba5d1108.png\"}],\"price_value\":\"212\",\"project_price\":\"0.01\",\"min_num\":\"3\",\"memberBand\":\"3376\"},{\"sepc\":\"1.8米\",\"color\":\"白色\",\"product_spec\":[{\"fileid\":\"WU_FILE_5\",\"type\":\"ProductPricePath\",\"name\":\"64126677_p0.png\",\"url\":\"/upload/product/main/a8aa41bbc0534b40b0e4bc8c036b5aed.png\"}],\"price_value\":\"212\",\"project_price\":\"0.01\",\"min_num\":\"3\",\"memberBand\":\"3376\"}]";
        System.out.println(ss.indexOf('['));
        JSONArray objects = JSON.parseArray(ss);
        objects.stream().forEach(o -> {
            JSONObject object = JSON.parseObject(o.toString());
            System.out.println(object);
        });
    }
}
