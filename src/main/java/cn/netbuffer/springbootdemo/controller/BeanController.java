package cn.netbuffer.springbootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/bean")
public class BeanController {

    @Resource
    private ApplicationContext applicationContext;
    @Resource
    private ResourceLoader resourceLoader;

    @GetMapping(value = {"count"})
    public Integer getBeanDefinitionCount() {
        Integer count = applicationContext.getBeanDefinitionCount();
        log.info("getBeanDefinitionCount:{}", count);
        return count;
    }

    @GetMapping(value = {"names"})
    public String[] getBeanDefinitionNames() {
        return applicationContext.getBeanDefinitionNames();
    }

    /**
     * get beans in package
     *
     * @param path
     * @return
     * @throws IOException
     */
    @GetMapping(value = {"names/path"})
    public List getBeanDefinitionNames(@RequestParam("path") String path) throws IOException {
        List beanNames = new ArrayList<>();
        ResourcePatternResolver resolver = ResourcePatternUtils.getResourcePatternResolver(resourceLoader);
        MetadataReaderFactory metaReader = new CachingMetadataReaderFactory(resourceLoader);
        org.springframework.core.io.Resource[] resources = resolver.getResources("classpath*:" + path + "/**/*.class");
        for (org.springframework.core.io.Resource r : resources) {
            MetadataReader reader = metaReader.getMetadataReader(r);
            beanNames.add(reader.getClassMetadata().getClassName());
        }
        return beanNames;
    }

    @GetMapping(value = {"map"})
    public Map getMap() {
        Map data = new HashMap();
        data.put("name", "test");
        data.put("age", "30");
        return data;
    }

}
