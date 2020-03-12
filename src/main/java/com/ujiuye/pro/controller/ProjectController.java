package com.ujiuye.pro.controller;

import com.ujiuye.pro.bean.Project;
import com.ujiuye.pro.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pro")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @RequestMapping(value = "/jsonList",method = RequestMethod.GET)
    @ResponseBody
    public List<Project> getProjectJsonList(){
        return projectService.getProjectJsonList();
    }

    @RequestMapping(value = "/saveInfo",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveInfo(Project project,String comnamewithid){
        String cid=comnamewithid.split(",")[1];
        project.setComname(Integer.valueOf(cid));
        projectService.saveInfo(project);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("statusCode",200);
        map.put("message","保存成功");
        return map;
    }
}
