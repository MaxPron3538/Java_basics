package com.skillbox.redisdemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static java.lang.System.in;
import static java.lang.System.out;

public class RedisTest {

    // Запуск докер-контейнера:
    // docker run --rm --name skill-redis -p 127.0.0.1:6379:6379/tcp -d redis

    // Для теста будем считать неактивными пользователей, которые не заходили 2 секунды
    private static final int DELETE_SECONDS_AGO = 2;

    // Допустим пользователи делают 500 запросов к сайту в секунду
    private static final int USERS = 20;

    // И всего на сайт заходило 1000 различных пользователей
    private static final int USER_CASE = 10;

    // Также мы добавим задержку между посещениями
    private static final int SLEEP = 1000;

    private static final SimpleDateFormat DF = new SimpleDateFormat("HH:mm:ss");

    private static void log(int userId) {
        String log = String.format("- Показываем пользователя: %d", userId);
        out.println(log);
    }

    private static void logPaidUser(int userId) {
        String log = String.format("> Пользователь: %d оплатил услугу", userId);
        out.println(log);
    }


    public static void main(String[] args) throws InterruptedException {

        RedisStorage redis = new RedisStorage();
        redis.init();

        while(true){
            int paid_user = (int)(1 + Math.random()*USER_CASE);

            for(int user = 1; user <= USERS; user++) {
                int user_id;

                if(user == paid_user){
                    user_id = (int)(1 + Math.random() * USER_CASE);
                    redis.logPageVisit(user_id);
                    logPaidUser(user_id);
                    log(user_id);
                    Thread.sleep(SLEEP);
                }
                if (!redis.getPageUser(user)) {
                    user_id = user;
                    redis.logPageVisit(user_id);
                    log(user_id);
                    Thread.sleep(SLEEP);
                }
            }
            redis.deleteOldEntries(DELETE_SECONDS_AGO);
        }
        //redis.shutdown();
    }
}
