package com.wl.demo1;

import java.lang.reflect.Array;
import java.net.SocketTimeoutException;
import java.util.*;

public class Test1 {
    //因为只有一个集合存放罪犯，为了下面的各个方法调用时不用传入list参数，直接用static
    public static List<Prisoner> prisoners = new ArrayList<>();

    public static void main(String[] args) {
        //int randNumber = rand.nextInt(MAX - MIN + 1) + MIN;
        Random random = new Random();
//        List<Prisoner> prisoners = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            int id = random.nextInt(200) + 1;
            //判断id是否唯一
            if (exist(id)) {
                i--;
                continue;
            }
            Prisoner prisoner = new Prisoner(id, i);
            prisoners.add(prisoner);
        }
        System.out.println("囚犯"+prisoners);
        //干掉奇数位置的人=留下偶数位置的人(不能更改位置变量，否则会输出不了）
        while (prisoners.size() > 1){
            List<Prisoner> tempPrisoners = new ArrayList<>();
            for (int i = 1; i < prisoners.size(); i+=2) {
                tempPrisoners.add(prisoners.get(i));
            }
            prisoners = tempPrisoners;
        }
        System.out.println("留下的"+prisoners);
    }

    public static boolean exist(int id) {
        for (Prisoner prisoner : prisoners) {
            if (prisoner.getId() == id) {
//                System.out.println("有重复"+id);
                return true;
            }
        }
        return false;
    }
}
