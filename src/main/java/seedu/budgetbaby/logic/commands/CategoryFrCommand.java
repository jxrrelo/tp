package seedu.budgetbaby.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.budgetbaby.logic.parser.CliSyntax.PREFIX_AMOUNT;
import static seedu.budgetbaby.logic.parser.CliSyntax.PREFIX_CATEGORY;
import static seedu.budgetbaby.logic.parser.CliSyntax.PREFIX_DESCRIPTION;

import seedu.budgetbaby.logic.commands.exceptions.CommandException;
import seedu.budgetbaby.model.BudgetBabyModel;
import seedu.budgetbaby.model.record.FinancialRecordList;

/**
 * Filters financial records by category.
 */
public class CategoryFrCommand extends BudgetBabyCommand { // will extend into accepting multiple categories as input

    public static final String COMMAND_WORD = "category-fr";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Filters financial records by category. "
            + "Parameters: "
            + PREFIX_DESCRIPTION + "FR_CATEGORY\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_DESCRIPTION + "Food ";

    public static final String MESSAGE_SUCCESS = "Financial Records list is now filtered to %1$s";

    private final FinancialRecordList frList;

    /**
     * Creates a CategoryFrCommand to update the FR list
     */
    public CategoryFrCommand(FinancialRecordList frList) {
        requireNonNull(frList);
        this.frList = frList;
    }

    @Override
    public CommandResult execute(BudgetBabyModel model) throws CommandException {
        requireNonNull(model);

        model.updateFinancialRecord(frList);
        return new CommandResult(String.format(MESSAGE_SUCCESS, frList));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddFrCommand // instanceof handles nulls
                && toAdd.equals(((AddFrCommand) other).toAdd));
    }
}
