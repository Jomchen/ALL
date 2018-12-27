package com.jomchen.test.services;

import com.jomchen.test.model.Test;
import com.jomchen.test.utils.TestAnnotation;
import com.jomchen.test.utils.TypeEnum;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * create by Jomchen on 2018/11/21
 */
@Service
public class TestServiceImpl {

    @TestAnnotation(value = TypeEnum.ARRAY, color = "数组")
    public int handleArray(Test[] array) {
        System.out.println("执行了数组");
        return array.length;
    }

    @TestAnnotation(value = TypeEnum.LIST, color = "集合")
    public int handleList(List<Test> list) {
        System.out.println("执行了集合");
        return list.size();
    }

    @TestAnnotation(value = TypeEnum.OBJECT, color = "对象")
    public void handleBean(Test t) {
        System.out.println("执行了对象");
    }

}
