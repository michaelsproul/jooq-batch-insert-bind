/**
 * This class is generated by jOOQ
 */
package thing.jooq.tables;


import com.google.gson.JsonElement;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;

import thing.JSONBinding;
import thing.jooq.Public;
import thing.jooq.tables.records.TestTableRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TestTable extends TableImpl<TestTableRecord> {

    private static final long serialVersionUID = 2121954579;

    /**
     * The reference instance of <code>public.test_table</code>
     */
    public static final TestTable TEST_TABLE = new TestTable();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TestTableRecord> getRecordType() {
        return TestTableRecord.class;
    }

    /**
     * The column <code>public.test_table.json_column</code>.
     */
    public final TableField<TestTableRecord, JsonElement> JSON_COLUMN = createField("json_column", org.jooq.impl.DefaultDataType.getDefaultDataType("jsonb"), this, "", new JSONBinding());

    /**
     * Create a <code>public.test_table</code> table reference
     */
    public TestTable() {
        this("test_table", null);
    }

    /**
     * Create an aliased <code>public.test_table</code> table reference
     */
    public TestTable(String alias) {
        this(alias, TEST_TABLE);
    }

    private TestTable(String alias, Table<TestTableRecord> aliased) {
        this(alias, aliased, null);
    }

    private TestTable(String alias, Table<TestTableRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TestTable as(String alias) {
        return new TestTable(alias, this);
    }

    /**
     * Rename this table
     */
    public TestTable rename(String name) {
        return new TestTable(name, null);
    }
}
