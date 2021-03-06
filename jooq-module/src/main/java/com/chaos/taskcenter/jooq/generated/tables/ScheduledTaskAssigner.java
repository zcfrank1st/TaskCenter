/*
 * This file is generated by jOOQ.
*/
package com.chaos.taskcenter.jooq.generated.tables;


import com.chaos.taskcenter.jooq.generated.Keys;
import com.chaos.taskcenter.jooq.generated.TaskCenter;
import com.chaos.taskcenter.jooq.generated.tables.records.ScheduledTaskAssignerRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;


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
public class ScheduledTaskAssigner extends TableImpl<ScheduledTaskAssignerRecord> {

    private static final long serialVersionUID = -562362621;

    /**
     * The reference instance of <code>task_center.scheduled_task_assigner</code>
     */
    public static final ScheduledTaskAssigner SCHEDULED_TASK_ASSIGNER = new ScheduledTaskAssigner();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ScheduledTaskAssignerRecord> getRecordType() {
        return ScheduledTaskAssignerRecord.class;
    }

    /**
     * The column <code>task_center.scheduled_task_assigner.task_id</code>.
     */
    public final TableField<ScheduledTaskAssignerRecord, UInteger> TASK_ID = createField("task_id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>task_center.scheduled_task_assigner.tag</code>.
     */
    public final TableField<ScheduledTaskAssignerRecord, UInteger> TAG = createField("tag", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGERUNSIGNED)), this, "");

    /**
     * Create a <code>task_center.scheduled_task_assigner</code> table reference
     */
    public ScheduledTaskAssigner() {
        this("scheduled_task_assigner", null);
    }

    /**
     * Create an aliased <code>task_center.scheduled_task_assigner</code> table reference
     */
    public ScheduledTaskAssigner(String alias) {
        this(alias, SCHEDULED_TASK_ASSIGNER);
    }

    private ScheduledTaskAssigner(String alias, Table<ScheduledTaskAssignerRecord> aliased) {
        this(alias, aliased, null);
    }

    private ScheduledTaskAssigner(String alias, Table<ScheduledTaskAssignerRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<ScheduledTaskAssignerRecord> getPrimaryKey() {
        return Keys.KEY_SCHEDULED_TASK_ASSIGNER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ScheduledTaskAssignerRecord>> getKeys() {
        return Arrays.<UniqueKey<ScheduledTaskAssignerRecord>>asList(Keys.KEY_SCHEDULED_TASK_ASSIGNER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScheduledTaskAssigner as(String alias) {
        return new ScheduledTaskAssigner(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ScheduledTaskAssigner rename(String name) {
        return new ScheduledTaskAssigner(name, null);
    }
}
