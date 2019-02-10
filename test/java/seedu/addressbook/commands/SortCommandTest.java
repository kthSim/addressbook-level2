package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TestUtil;

public class SortCommandTest {

    private AddressBook testBook;
    private AddressBook emptyTestBook;

    private List<ReadOnlyPerson> populatedList;
    private List<ReadOnlyPerson> expectedNameSortedList;
    private List<ReadOnlyPerson> expectedPhoneSortedList;
    private List<ReadOnlyPerson> expectedEmailSortedList;
    private List<ReadOnlyPerson> expectedAddressSortedList;

    /**
     * Sets up a sample addressBook containing four unique Persons that will result in a different list order
     * depending on the selected sort parameter.
     *
     */
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

        populatedList = TestUtil.createList(johnDoe, janeDoe, davidGrant, samDoe);
        expectedNameSortedList = TestUtil.createList(davidGrant, janeDoe, johnDoe, samDoe);
        expectedPhoneSortedList = TestUtil.createList(johnDoe, davidGrant, samDoe, janeDoe);
        expectedEmailSortedList = TestUtil.createList(janeDoe, davidGrant, johnDoe, samDoe);
        expectedAddressSortedList = TestUtil.createList(johnDoe, janeDoe, davidGrant, samDoe);

    }

    /**
     * Tests sorting the address book by name
     */
    @Test
    public void execute_sortAddressBookByName_returnsNameSorted() {
        assetSortCommandOutput("name");
        assertEquals(expectedNameSortedList.toString(), testBook.getAllPersons().immutableListView().toString());
    }

    /**
     * Tests sorting the address book by phone
     */
    @Test
    public void execute_sortAddressBookByPhone_returnsPhoneSorted() {
        assetSortCommandOutput("phone");
        assertEquals(expectedPhoneSortedList.toString(), testBook.getAllPersons().immutableListView().toString());
    }

    /**
     * Tests sorting the address book by email
     */
    @Test
    public void execute_sortAddressBookByEmail_returnsEmailSorted() {
        assetSortCommandOutput("email");
        assertEquals(expectedEmailSortedList.toString(), testBook.getAllPersons().immutableListView().toString());
    }

    /**
     * Tests sorting the address book by address
     */
    @Test
    public void execute_sortAddressBookByAddress_returnsAddressSorted() {
        assetSortCommandOutput("address");
        assertEquals(expectedAddressSortedList.toString(), testBook.getAllPersons().immutableListView().toString());
    }

    /**
     * Utility function to compare expected sort result by actual sort result.
     *
     * @param sortParameter Parameter to sort by
     */
    private void assetSortCommandOutput(String sortParameter) {
        Command testCmd = new SortCommand(sortParameter);
        testCmd.setData(testBook, populatedList);
        CommandResult expectedSortResult = new CommandResult(String.format(SortCommand.MESSAGE_SUCCESS, sortParameter));
        CommandResult testResult = testCmd.execute();
        assertEquals(expectedSortResult.feedbackToUser, testResult.feedbackToUser);
    }
}
