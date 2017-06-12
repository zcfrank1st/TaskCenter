/*
 * This file is generated by jOOQ.
*/
package com.chaos.taskcenter.dispatcher.jooq.generated.tables;


import com.chaos.taskcenter.dispatcher.jooq.generated.Keys;
import com.chaos.taskcenter.dispatcher.jooq.generated.TaskCenter;
import com.chaos.taskcenter.dispatcher.jooq.generated.tables.records.TaskLockRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TaskLock extends TableImpl<TaskLockRecord> {

    private static final long serialVersionUID = 840062861;

    /**
     * The reference instance of <code>task_center.task_lock</code>
     */
    public static final TaskLock TASK_LOCK = new TaskLock();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TaskLockRecord> getRecordType() {
        return TaskLockRecord.class;
    }

    /**
     * The column <code>task_center.task_lock.lock_name</code>.
     */
    public final TableField<TaskLockRecord, String> LOCK_NAME = createField("lock_name", org.jooq.impl.SQLDataType.VARCHAR.length(32).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>task_center.task_lock</code> table reference
     */
    public TaskLock() {
        this("task_lock", null);
    }

    /**
     * Create an aliased <code>task_center.task_lock</code> table reference
     */
    public TaskLock(String alias) {
        this(alias, TASK_LOCK);
    }

    private TaskLock(String alias, Table<TaskLockRecord> aliased) {
        this(alias, aliased, null);
    }

    private TaskLock(String alias, Table<TaskLockRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return TaskCenter.TASK_CENTER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TaskLockRecord> getPrimaryKey() {
        return Keys.KEY_TASK_LOCK_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TaskLockRecord>> getKeys() {
        return Arrays.<UniqueKey<TaskLockRecord>>asList(Keys.KEY_TASK_LOCK_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskLock as(String alias) {
        return new TaskLock(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TaskLock rename(String name) {
        return new TaskLock(name, null);
    }
}