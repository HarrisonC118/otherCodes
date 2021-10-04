import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author: HatcherCheung
 * Date:  2021/10/4
 */
public class MyAutoGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/hatcher_shop?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false", "root", "root")
                .globalConfig(builder -> {
                    builder.author("HatcherCheung") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir()
                            .outputDir("./src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.hatcher.mappers") // 设置父包名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "./src/main/resources/mappers")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("carousel","category","users","user_address","items","items_img",
                                    "items_spec","items_param","items_comments","orders","order_items","order_status"); // 设置需要生成的表名
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
