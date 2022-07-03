package command.executor;

import command.CommandType;

public interface Executor {
    int execute(String text);

    CommandType getCommandType();
}
