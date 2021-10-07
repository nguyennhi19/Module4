package com.map.service;


import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class Dictionary implements IDictionary {
    public Dictionary() {
    }

    @Override
    public String search(String name) {
        String english[] = {"hello","hi","believe","lover","family"};
        String vienamese[] = {"Xin chào","Chào","Tin","Người yêu","Gia Đình"};
        int check = -1;
        String result = null;
        for(int i = 0; i < english.length; i++){
            if(english[i].equalsIgnoreCase(name)){
                check = i;
            }
        }
        if(check == -1){
            result = "Not found!";
        }else{
            result = vienamese[check];
        }
        return result;
    }
}