package seedu.address.logic.commands.personcommands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.person.PhoneContainsKeywordsPredicate;

/**
 * Finds and lists all persons in address book whose phone number matches the given number.
 */
public class FindByPhoneCommand extends Command {

    public static final String COMMAND_WORD = "findbyphone";
    public static final String COMMAND_WORD_ALIAS = "fbp";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose phone number matches "
            + "the given number and displays them as a list with index numbers.\n"
            + "Parameters: PHONE_NUMBER \n"
            + "Example: " + COMMAND_WORD + " 98765432 ";

    private final PhoneContainsKeywordsPredicate predicate;

    public FindByPhoneCommand(PhoneContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) {
        requireNonNull(model);
        model.updateFilteredPersonList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredPersonList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindByPhoneCommand // instanceof handles nulls
                && predicate.equals(((FindByPhoneCommand) other).predicate)); // state check
    }
}
