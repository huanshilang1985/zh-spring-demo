package com.zh.conf;

import com.zh.anno.ZhScan;
import com.zh.imports.MyImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author he.zhang
 * @date 2020/3/3 15:03
 */
@Configuration
@ComponentScan("com.zh")
@ZhScan()
@Import(MyImportSelector.class)
public class AppConfig {


}
