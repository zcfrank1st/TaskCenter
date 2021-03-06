/*
 * This file is generated by jOOQ.
*/
package com.chaos.taskcenter.jooq.generated.tables.records;


import com.chaos.taskcenter.jooq.generated.tables.TaskLock;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Row1;
import org.jooq.impl.UpdatableRecordImpl;


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
public class TaskLockRecord extends UpdatableRecordImpl<TaskLockRecord> implements Record1<String> {

    private static final long serialVersionUID = -2117424845;

    /**
     * Setter for <code>task_center.task_lock.lock_name</code>.
     */
    public void setLockName(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>task_center.task_lock.lock_name</code>.
     */
    public String getLockName() {
        return (String) get(0);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record1 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row1<String> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row1<String> valuesRow() {
        return (Row1) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return TaskLock.TASK_LOCK.LOCK_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getLockName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskLockRecord value1(String value) {
        setLockName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskLockRecord values(String value1) {
        value1(value1);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TaskLockRecord
     */
    public TaskLockRecord() {
        super(TaskLock.TASK_LOCK);
    }

    /**
     * Create a detached, initialised TaskLockRecord
     */
    public TaskLockRecord(String lockName) {
        super(TaskLock.TASK_LOCK);

        set(0, lockName);
    }
}
