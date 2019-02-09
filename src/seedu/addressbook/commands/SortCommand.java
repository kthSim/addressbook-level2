package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;

import java.util.Collections;
import java.util.Comparator;


public class SortCommand extends Command{

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts address book via the selected parameter.\n"
        + "Parameters: [name] OR [phone] OR [email]\n"
        + "Example: " + COMMAND_WORD + " name";

    public static final String MESSAGE_SUCCESS = "List has been sorted by %1$s";

    private String sortOption;
    private Comparator<Person> sortComparator;
//    private int[] test = new int[4];

    public SortCommand(String sortParameter) {
        System.out.println("testing\n");
        sortOption = sortParameter;


    }

    @Override
    public CommandResult execute() {

        return new CommandResult(String.format(MESSAGE_SUCCESS, sortOption));
    }
}
