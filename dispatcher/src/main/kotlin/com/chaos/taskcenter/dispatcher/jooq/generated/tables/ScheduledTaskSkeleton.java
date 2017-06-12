/*
 * This file is generated by jOOQ.
*/
package com.chaos.taskcenter.dispatcher.jooq.generated.tables;


import com.chaos.taskcenter.dispatcher.jooq.generated.Keys;
import com.chaos.taskcenter.dispatcher.jooq.generated.TaskCenter;
import com.chaos.taskcenter.dispatcher.jooq.generated.tables.records.ScheduledTaskSkeletonRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
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
public class ScheduledTaskSkeleton extends TableImpl<ScheduledTaskSkeletonRecord> {

    private static final long serialVersionUID = -926593034;

    /**
     * The reference instance of <code>task_center.scheduled_task_skeleton</code>
     */
    public static final ScheduledTaskSkeleton SCHEDULED_TASK_SKELETON = new ScheduledTaskSkeleton();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ScheduledTaskSkeletonRecord> getRecordType() {
        return ScheduledTaskSkeletonRecord.class;
    }

    /**
     * The column <code>task_center.scheduled_task_skeleton.task_id</code>.
     */
    public final TableField<ScheduledTaskSkeletonRecord, UInteger> TASK_ID = createField("task_id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>task_center.scheduled_task_skeleton.task_name</code>.
     */
    public final TableField<ScheduledTaskSkeletonRecord, String> TASK_NAME = createField("task_name", org.jooq.impl.SQLDataType.VARCHAR.length(256).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>task_center.scheduled_task_skeleton.quartz_expression</code>.
     */
    public final TableField<ScheduledTaskSkeletonRecord, String> QUARTZ_EXPRESSION = createField("quartz_expression", org.jooq.impl.SQLDataType.VARCHAR.length(24).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>task_center.scheduled_task_skeleton.task_content</code>.
     */
    public final TableField<ScheduledTaskSkeletonRecord, String> TASK_CONTENT = createField("task_content", org.jooq.impl.SQLDataType.VARCHAR.length(512).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>task_center.scheduled_task_skeleton.param</code>.
     */
    public final TableField<ScheduledTaskSkeletonRecord, String> PARAM = createField("param", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>task_center.scheduled_task_skeleton.task_type</code>.
     */
    public final TableField<ScheduledTaskSkeletonRecord, Byte> TASK_TYPE = createField("task_type", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>task_center.scheduled_task_skeleton.retry_time_threshold</code>.
     */
    public final TableField<ScheduledTaskSkeletonRecord, UInteger> RETRY_TIME_THRESHOLD = createField("retry_time_threshold", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>task_center.scheduled_task_skeleton.last_execute_time</code>.
     */
    public final TableField<ScheduledTaskSkeletonRecord, Timestamp> LAST_EXECUTE_TIME = createField("last_execute_time", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>task_center.scheduled_task_skeleton.create_time</code>.
     */
    public final TableField<ScheduledTaskSkeletonRecord, Timestamp> CREATE_TIME = createField("create_time", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>task_center.scheduled_task_skeleton.update_time</code>.
     */
    public final TableField<ScheduledTaskSkeletonRecord, Timestamp> UPDATE_TIME = createField("update_time", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>task_center.scheduled_task_skeleton.create_user</code>.
     */
    public final TableField<ScheduledTaskSkeletonRecord, String> CREATE_USER = createField("create_user", org.jooq.impl.SQLDataType.VARCHAR.length(32), this, "");

    /**
     * The column <code>task_center.scheduled_task_skeleton.update_user</code>.
     */
    public final TableField<ScheduledTaskSkeletonRecord, String> UPDATE_USER = createField("update_user", org.jooq.impl.SQLDataType.VARCHAR.length(32), this, "");

    /**
     * The column <code>task_center.scheduled_task_skeleton.refer_task_ids</code>.
     */
    public final TableField<ScheduledTaskSkeletonRecord, String> REFER_TASK_IDS = createField("refer_task_ids", org.jooq.impl.SQLDataType.VARCHAR.length(1024), this, "");

    /**
     * Create a <code>task_center.scheduled_task_skeleton</code> table reference
     */
    public ScheduledTaskSkeleton() {
        this("scheduled_task_skeleton", null);
    }

    /**
     * Create an aliased <code>task_center.scheduled_task_skeleton</code> table reference
     */
    public ScheduledTaskSkeleton(String alias) {
        this(alias, SCHEDULED_TASK_SKELETON);
    }

    private ScheduledTaskSkeleton(String alias, Table<ScheduledTaskSkeletonRecord> aliased) {
        this(alias, aliased, null);
    }

    private ScheduledTaskSkeleton(String alias, Table<ScheduledTaskSkeletonRecord> aliased, Field<?>[] parameters) {
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
    public Identity<ScheduledTaskSkeletonRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_SCHEDULED_TASK_SKELETON;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ScheduledTaskSkeletonRecord> getPrimaryKey() {
        return Keys.KEY_SCHEDULED_TASK_SKELETON_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ScheduledTaskSkeletonRecord>> getKeys() {
        return Arrays.<UniqueKey<ScheduledTaskSkeletonRecord>>asList(Keys.KEY_SCHEDULED_TASK_SKELETON_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScheduledTaskSkeleton as(String alias) {
        return new ScheduledTaskSkeleton(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ScheduledTaskSkeleton rename(String name) {
        return new ScheduledTaskSkeleton(name, null);
    }
}
