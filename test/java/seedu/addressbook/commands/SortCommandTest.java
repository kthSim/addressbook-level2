package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;
import seedu.addressbook.util.TestUtil;

public class SortCommandTest {

    private AddressBook testBook;
    private AddressBook emptyTestBook;

    private List<ReadOnlyPerson> populatedList;

    @Before
    public void setUp() throws Exception {
        Person johnDoe = new Person(new Name("John Doe"), new Phone("61034567", false),
            new Email("doeJohn@doe.com", false), new Address("395C Ben Road", false), Collections.emptySet());
        Person janeDoe = new Person(new Name("Jane Doe"), new Phone("91234567", false),
            new Email("bestJane@doe.com", false), new Address("43G Hom Road", false), Collections.emptySet());
        Person samDoe = new Person(new Name("Sam Doe"), new Phone("63345566", false),
            new Email("sam@doe.com", false), new Address("55G Abc Road", false), Collections.emptySet());
        Person davidGrant = new Person(new Name("David Grant"), new Phone("61121122", false),
            new Email("david@grant.com", false), new Address("44H Define Road", false),
            Collections.emptySet());

        testBook = TestUtil.createAddressBook(johnDoe, janeDoe, davidGrant, samDoe);
        emptyTestBook = TestUtil.createAddressBook();

//        emptyDisplayList = TestUtil.createList();
//
        populatedList = TestUtil.createList(johnDoe, janeDoe, davidGrant, samDoe);
//        listWithSurnameDoe = TestUtil.createList(johnDoe, janeDoe, samDoe);
    }

    @Test
    public void execute_sortAddressBookByName_returnsNameSorted() {
        assetSortCommandOutput("name");
    }

    @Test
    public void execute_sortAddressBookByPhone_returnsPhoneSorted() {
        assetSortCommandOutput("phone");
    }

    @Test
    public void execute_sortAddressBookByEmail_returnsEmailSorted() {
        assetSortCommandOutput("email");
    }

    @Test
    public void execute_sortAddressBookByAddress_returnsAddressSorted() {
        assetSortCommandOutput("address");
    }

    private void assetSortCommandOutput(String sortParameter) {
        Command testCmd = new SortCommand(sortParameter);
        testCmd.setData(testBook, populatedList);
        CommandResult expectedSortResult = new CommandResult(String.format(SortCommand.MESSAGE_SUCCESS, sortParameter));
        CommandResult testResult = testCmd.execute();
        assertEquals(expectedSortResult.feedbackToUser, testResult.feedbackToUser);
    }
}
