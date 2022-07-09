package command.executor;

import command.CommandType;

public interface Executor {
    int execute(String command);

    CommandType getCommandType();
}
