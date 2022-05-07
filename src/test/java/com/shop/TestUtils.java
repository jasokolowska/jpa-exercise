package com.shop;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.function.Consumer;

public class TestUtils {

    static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("training-test");

    static final Statistics STATISTICS = ENTITY_MANAGER_FACTORY.unwrap(SessionFactory.class).getStatistics();

    static void run(Consumer<EntityManager> task) {
        var entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        var transaction = entityManager.getTransaction();
        transaction.begin();
        task.accept(entityManager);
        transaction.commit();
        entityManager.close();
    }

    static void runAsync(Consumer<EntityManager> task){
        new Thread(() -> run(task)).start();
    }

    static void sleep(long millisecond){
        try{
            Thread.sleep(millisecond);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    static void measure(Runnable runnable){
        var startTime = System.currentTimeMillis();
        runnable.run();
        System.out.printf("Total time: %d ms\n", System.currentTimeMillis() - startTime);
    }
}
