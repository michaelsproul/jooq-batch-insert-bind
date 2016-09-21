package thing;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.List;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import thing.jooq.tables.records.TestTableRecord;

public class Main {

    public static String URL = "jdbc:postgresql://localhost:5432/test_user";
    public static String USERNAME = "test_user";
    public static String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        JsonObject obj = new JsonObject();
        obj.add("hello", new JsonPrimitive("world"));

        List<TestTableRecord> records = Arrays.asList(
            new TestTableRecord().setJsonColumn(obj)
        );

        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        DSLContext dsl = DSL.using(conn, SQLDialect.POSTGRES_9_4);

        dsl.batchInsert(records).execute();
    }
}
