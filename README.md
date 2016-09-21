# jOOQ batch insert with binding

Set up a database with a table according to schema.sql, then:

```
$ gradle run
```

All being well you should see something like...

```
Exception in thread "main" org.jooq.exception.DataAccessException: SQL [insert into "public"."test_table" ("json_column") values (cast(? as varchar))]; Batch entry 0 insert into "public"."test_table" ("json_column") values (cast('{"hello":"world"}' as varchar)) was aborted: ERROR: column "json_column" is of type jsonb but expression is of type character varying
  Hint: You will need to rewrite or cast the expression.
  Position: 64  Call getNextException to see the cause.
        at org.jooq.impl.Tools.translate(Tools.java:1941)
        at org.jooq.impl.DefaultExecuteContext.sqlException(DefaultExecuteContext.java:659)
        at org.jooq.impl.BatchSingle.executePrepared(BatchSingle.java:259)
        at org.jooq.impl.BatchSingle.execute(BatchSingle.java:182)
        at org.jooq.impl.BatchCRUD.executePrepared(BatchCRUD.java:159)
        at org.jooq.impl.BatchCRUD.execute(BatchCRUD.java:100)
        at thing.Main.main(Main.java:31)
Caused by: java.sql.BatchUpdateException: Batch entry 0 insert into "public"."test_table" ("json_column") values (cast('{"hello":"world"}' as varchar)) was aborted: ERROR: column "json_column" is of type jsonb but expression is of type character varying
  Hint: You will need to rewrite or cast the expression.
  Position: 64  Call getNextException to see the cause.
        at org.postgresql.jdbc.BatchResultHandler.handleCompletion(BatchResultHandler.java:164)
        at org.postgresql.core.v3.QueryExecutorImpl.execute(QueryExecutorImpl.java:469)
        at org.postgresql.jdbc.PgStatement.executeBatch(PgStatement.java:794)
        at org.postgresql.jdbc.PgPreparedStatement.executeBatch(PgPreparedStatement.java:1662)
        at org.jooq.tools.jdbc.DefaultStatement.executeBatch(DefaultStatement.java:93)
        at org.jooq.impl.BatchSingle.executePrepared(BatchSingle.java:239)
        ... 4 more
```

You can also regenerate the jOOQ code with:

```
$ gradle jooq
```
