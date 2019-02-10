package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Comparator;
import java.util.List;


public class SortCommand extends Command{

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts address book via the selected parameter.\n"
        + "Parameters: [name] OR [phone] OR [email] OR [address]\n"
        + "Example: " + COMMAND_WORD + " name";

    public static final String MESSAGE_SUCCESS = "List has been sorted by %1$s";

    private String sortOption;
    private Comparator<Person> sortComparator;
//    private int[] test = new int[4];

    public SortCommand(String sortParameter) {
        sortOption = sortParameter;

        switch (sortParameter) {
            case ("name"):
                sortComparator = Person.compPersonName;
                break;
            case ("phone"):
                sortComparator = Person.compPersonPhone;
                break;
            case ("email"):
                sortComparator = Person.compPersonEmail;
                break;
            case ("address"):
                sortComparator = Person.compPersonAddress;
                break;
            default:
                break;
        }
    }

    @Override
    public CommandResult execute() {
        addressBook.sortPersons(sortComparator);
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();

        return new CommandResult(String.format(MESSAGE_SUCCESS, sortOption), allPersons);
    }
}
