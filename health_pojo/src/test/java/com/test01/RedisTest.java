package com.test01;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.User;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * list集合传送到redis中
 */
public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        User user1 = new User("日不落","18");
        User user2 = new User("发如雪","18");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        jedis.set("userList", JSON.toJSONString(list));
        String userListStr = jedis.get("userList");
        JSONArray userList = JSONObject.parseArray(userListStr);
        List<User> userList1 = (List<User>) JSON.toJSON(userList);
        System.out.println(userList);
        jedis.close();
    }
}
