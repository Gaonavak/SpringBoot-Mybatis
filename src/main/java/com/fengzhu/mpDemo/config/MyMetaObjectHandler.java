package com.fengzhu.mpDemo.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * 自定义 MetaObjectHandler 实现，用于自动填充字段。
 * 该类在插入和更新操作时自动填充创建时间和更新时间。
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 在插入时填充字段。
     *
     * @param metaObject MyBatis-Plus 的 MetaObject 对象，表示当前的元数据。
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("开始插入填充...");
        long now = Instant.now().toEpochMilli(); // 获取当前时间的毫秒表示
        // 填充 createTime 和 updateTime 字段
        this.strictInsertFill(metaObject, "createTime", Long.class, now);
        this.strictInsertFill(metaObject, "updateTime", Long.class, now);
    }

    /**
     * 在更新时填充字段。
     *
     * @param metaObject MyBatis-Plus 的 MetaObject 对象，表示当前的元数据。
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("开始更新填充...");
        long now = Instant.now().toEpochMilli(); // 获取当前时间的毫秒表示
        // 填充 updateTime 字段
        this.strictUpdateFill(metaObject, "updateTime", Long.class, now);
    }
}