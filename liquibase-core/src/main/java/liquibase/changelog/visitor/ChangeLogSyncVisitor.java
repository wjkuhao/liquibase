package liquibase.changelog.visitor;

import liquibase.changelog.ChangeSet;
import liquibase.changelog.DatabaseChangeLog;
import liquibase.changelog.filter.ChangeSetFilterResult;
import liquibase.database.Database;
import liquibase.exception.LiquibaseException;

import java.util.Set;

public class ChangeLogSyncVisitor implements ChangeSetVisitor {

    private Database database;

    public ChangeLogSyncVisitor(Database database) {
        this.database = database;
    }

    @Override
    public Direction getDirection() {
        return ChangeSetVisitor.Direction.FORWARD;
    }

    @Override
    public void visit(ChangeSet changeSet, DatabaseChangeLog databaseChangeLog, Database database, Set<ChangeSetFilterResult> filterResults) throws LiquibaseException {
        this.database.markChangeSetExecStatus(changeSet, ChangeSet.ExecType.EXECUTED);
    }
}
