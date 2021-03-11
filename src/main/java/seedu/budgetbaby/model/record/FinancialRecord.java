package seedu.budgetbaby.model.record;

import static java.util.Objects.requireNonNull;
import static seedu.budgetbaby.model.record.Category.VALIDATION_REGEX;
import static seedu.budgetbaby.commons.util.AppUtil.checkArgument;

import java.util.*;

/**
 * Represents a Financial Record in the budget tracker.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class FinancialRecord {

    private static final String FINANCIAL_RECORD_DETAILS_DELIMITER = " | ";
    private static final String MESSAGE_CONSTRAINTS = "Tag names should be alphanumeric";

    // Data fields
    private final Description description;
    private final Amount amount;
    private final Date timestamp;
    private final Set<Category> categories = new HashSet<>();

    /**
     * Constructs a {@code FinancialRecord}.
     *
     * @param description A valid description.
     * @param amount      A valid amount.
     */
    public FinancialRecord(Description description, Amount amount, Set<Category> categories) {
        //requireNonNull(tagName);
        //checkArgument(isValidTagName(tagName), MESSAGE_CONSTRAINTS);
        this.description = description;
        this.amount = amount;
        this.timestamp = new Date();
        this.categories.addAll(categories);
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidTagName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Constructs a {@code FinancialRecord}.
     *
     * @param description A valid description.
     * @param amount      A valid amount.
     * @param timestamp   A valid timestamp.
     */
    public FinancialRecord(Description description, Amount amount, Date timestamp) {
        //requireNonNull(tagName);
        //checkArgument(isValidTagName(tagName), MESSAGE_CONSTRAINTS);
        this.description = description;
        this.amount = amount;
        this.timestamp = timestamp;
        this.categories.addAll(categories);
    }

    public Description getDescription() {
        return description;
    }

    public Amount getAmount() {
        return amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Category> getTags() {
        return Collections.unmodifiableSet(categories);
    }
    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(description, amount, timestamp);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTimestamp())
            .append(FINANCIAL_RECORD_DETAILS_DELIMITER)
            .append(getDescription())
            .append(FINANCIAL_RECORD_DETAILS_DELIMITER)
            .append(getAmount())
            .append(FINANCIAL_RECORD_DETAILS_DELIMITER)
            .append(getTimestamp());

        Set<Category> categories = getTags();
        if (!categories.isEmpty()) {
            builder.append("; Categories: ");
            categories.forEach(builder::append);
        }
        return builder.toString();
    }

}
