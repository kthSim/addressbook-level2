package seedu.addressbook.data.person;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.addressbook.data.tag.Tag;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Person implements ReadOnlyPerson {

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;

    private final Set<Tag> tags = new HashSet<>();

    /**
     * Assumption: Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Address address, Set<Tag> tags) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.tags.addAll(tags);
    }

    /**
     * Copy constructor.
     */
    public Person(ReadOnlyPerson source) {
        this(source.getName(), source.getPhone(), source.getEmail(), source.getAddress(), source.getTags());
    }

    @Override
    public Name getName() {
        return name;
    }

    @Override
    public Phone getPhone() {
        return phone;
    }

    @Override
    public Email getEmail() {
        return email;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public Set<Tag> getTags() {
        return new HashSet<>(tags);
    }

    /**
     * Replaces this person's tags with the tags in the argument tag set.
     */
    public void setTags(Set<Tag> replacement) {
        tags.clear();
        tags.addAll(replacement);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ReadOnlyPerson // instanceof handles nulls
                && this.hasSameData((ReadOnlyPerson) other));
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, tags);
    }

    @Override
    public String toString() {
        return getAsTextShowAll();
    }

    /**
     * Comparator to sort via name.
     */
    public static Comparator<Person> compPersonName = new Comparator<Person>() {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.getName().toString().compareTo(p2.getName().toString());
        }
    };

    /**
     * Comparator to sort via Phone.
     */
    public static Comparator<Person> compPersonPhone = new Comparator<Person>() {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.getPhone().toString().compareTo(p2.getPhone().toString());
        }
    };

    /**
     * Comparator to sort via Email.
     */
    public static Comparator<Person> compPersonEmail = new Comparator<Person>() {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.getEmail().toString().compareTo(p2.getEmail().toString());
        }
    };

    /**
     * Comparator to sort via Address.
     */
    public static Comparator<Person> compPersonAddress = new Comparator<Person>() {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.getAddress().toString().compareTo(p2.getAddress().toString());
        }
    };
}
