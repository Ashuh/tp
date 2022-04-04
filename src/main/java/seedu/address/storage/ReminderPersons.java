package seedu.address.storage;

import java.util.HashMap;
import java.util.Set;

import seedu.address.model.Reminder;
import seedu.address.model.person.Person;

/**
 * A class to store all clients set for reminders.
 * This class is implemented as a singleton, as there can only be 1 list of Reminders.
 */
public class ReminderPersons {

    private static ReminderPersons reminderPersons;
    private static HashMap<Person, Reminder> personReminderHashMap;

    private ReminderPersons() {
        personReminderHashMap = new HashMap<>();
    }

    public static ReminderPersons getInstance() {
        if (reminderPersons == null) {
            reminderPersons = new ReminderPersons();
        }

        return reminderPersons;
    }

    /**
     * Adds a person to the list of persons to be reminded of,
     * returns a boolean indicating if this person is in this list or not.
     * @param person The person to be reminded of.
     */
    public Reminder add(Person person, Reminder reminder) {
        return personReminderHashMap.put(person, reminder);
    }

    /**
     * Removes a person from the list of persons to be reminded of
     * @param person The person to remove from reminders.
     */
    public Reminder remove(Person person) {
        return personReminderHashMap.remove(person);
    }

    /**
     * Returns a shallow copy of the HashMap.
     */
    public HashMap<Person, Reminder> clone() {
        return new HashMap<>(personReminderHashMap);
    }

    /**
     * Retrieves the {@code Reminder} associated with the person.
     * @param person The person to check for reminders.
     */
    public Reminder get(Person person) {
        return personReminderHashMap.get(person);
    }

    public Reminder put(Person person, Reminder reminder) {
        return personReminderHashMap.put(person, reminder);
    }

    /**
     * Retrieves a {@code Set} view of the {@code Person} in this {@code HashMap}.
     */
    public Set<Person> getKeySet() {
        return personReminderHashMap.keySet();
    }

    /**
     * Checks if the person has a {@code Reminder}.
     */
    public boolean containsKey(Person person) {
        return personReminderHashMap.containsKey(person);
    }

    /**
     * Checks if there are any active {@code Reminder}s.
     */
    public boolean isEmpty() {
        return personReminderHashMap.isEmpty();
    }
}
