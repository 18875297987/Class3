package com.wei.web.controller;

import com.wei.web.entity.User2;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BMIController {
    @RequestMapping("/bmi")
    public String bmi(@RequestBody User2 user){
        // 计算bmi值的公式：bmi = 体重kg/ (身高m * 身高)
        // bmi值若是，小于18.5偏瘦，18.5-24之间正常,24-27微胖，大于27肥胖
        double bmi = user.getWeight() / (user.getHight() * user.getHight());
        if (bmi < 18.5){
            return "细狗，多吃点嘎嘎吧！";
        }else if (bmi >= 18.5 && bmi < 24){
            return "一切正常，请继续保持！";
        }else if (bmi >= 24 && bmi <27){
            return "稍微有一点胖，但是影响不大";
        }else {
            return "太胖了，赶紧运动起来吧！";
        }
    }
}
