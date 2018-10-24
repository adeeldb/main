package seedu.address.logic.commands.personcommands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;

/**
 * Clears the address book.
 */
public class ClearUserCommand extends Command {

    public static final String COMMAND_WORD = "clearUser";
    public static final String MESSAGE_SUCCESS = "Address book has been cleared!";


    @Override
    public CommandResult execute(Model model, CommandHistory history) {
        requireNonNull(model);
        AddressBook newAddressBook = new AddressBook();
        newAddressBook.setEvents(model.getFilteredEventList());
        model.resetData(newAddressBook);
        model.commitAddressBook();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
