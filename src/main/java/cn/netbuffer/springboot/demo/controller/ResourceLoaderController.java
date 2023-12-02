package cn.netbuffer.springboot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/resourceloader")
public class ResourceLoaderController {

    @Resource
    private ResourceLoader resourceLoader;

    @Value("${spring.web.resources.static-locations}")
    private String staticLocations;

    @GetMapping("staticpaths")
    public List<String> staticPaths() {
        String[] locations = staticLocations.split(",");
        return Arrays.asList(locations);
    }

    @GetMapping("staticpaths/physicalpath")
    public List<String> staticPathsPhysicalPath() {
        List list = new ArrayList();
        List<String> locations = staticPaths();
        for (String location : locations) {
            try {
                list.add(resourceLoader.getResource(location.trim()).getFile().getAbsolutePath());
            } catch (Exception e) {
                log.error("getResource[" + location + "] error:", e);
            }
        }
        return list;
    }

}
