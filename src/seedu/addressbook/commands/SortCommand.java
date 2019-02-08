package seedu.addressbook.commands;

public class SortCommand extends Command{

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts address book via the selected parameter.\n"
        + "Parameters: [name] OR [phone] OR [email]\n"
        + "Example: " + COMMAND_WORD + " name";

    public static final String MESSAGE_SUCCESS = "List has been sorted by %1$s";

    @Override
    public CommandResult execute() {

        return new CommandResult(String.format(MESSAGE_SUCCESS, "temp"));
    }
}
