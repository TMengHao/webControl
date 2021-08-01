package org.blue.controller;

import org.blue.entity.City;
import org.blue.entity.User;
import org.blue.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @author Blue
 * @date 2021/7/31
 */
@Controller
public class TableController {

    @Autowired
    private CityService cityService;

    @GetMapping("/basic_table")
    public String basic_table(){
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        List<User> userList = Arrays.asList(new User("张三", "123456"), new User("李四", "11111"),
                new User("王五", "22222"), new User("麻子", "333333"));
        model.addAttribute("userList",userList);
        return "table/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @ResponseBody
    @GetMapping("/city")
    public City getCity(@RequestParam("id") Integer id){
        City city = cityService.selectCityById(id);
        return city;
    }
}
