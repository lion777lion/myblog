package com.blog.myblog;


import com.blog.myblog.DataFiles.DataClass;
import com.blog.myblog.DataFiles.DataSources;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/")
public class StartPageController {
    DataClass dataClass;
    DataSources dataSources;

    public StartPageController(DataSources dataSources) {
        this.dataSources = dataSources;
    }




    @GetMapping
    public String ShowAll (Model model){
        List<DataClass> dataList = (List<DataClass>) dataSources.findAll();
        model.addAttribute("dataClass", new DataClass());
        model.addAttribute("datalist", dataList);
        return("StartPage");
    }
    @PostMapping
    @RequestMapping("/new")
    public String AddNewData  (@Valid  @RequestParam MultipartFile file) throws IOException {
        byte[] byteFile = file.getBytes();
        LocalDateTime time = LocalDateTime.now();
        dataClass.setFile(byteFile);
        dataClass.setTime(time);
        dataSources.save(dataClass);
        return("redirect:/StartPage");
    }
}
