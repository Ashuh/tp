package seedu.address.model.property;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class Price {

    public static final String MESSAGE_CONSTRAINTS = "Price must have the format $#####";
    public static final String VALIDATION_REGEX = "^\\$\\d*";

    private static final double THOUSAND = 1E3;
    private static final double MILLION = 1E6;

    public final String value;

    /**
     * Constructs a {@code Price}.
     *
     * @param price A valid price.
     */
    public Price(String price) {
        requireNonNull(price);
        checkArgument(isValidPrice(price), MESSAGE_CONSTRAINTS);
        value = price;
    }

    public static boolean isValidPrice(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public int getAsInt() {
        return Integer.parseInt(value.substring(1));
    }

    @Override
    public String toString() {
        int intValue = getAsInt();

        if (intValue >= MILLION) {
            return String.format("$%.1fM", intValue / MILLION);
        } else if (intValue >= THOUSAND) {
            return String.format("$%.1fK", intValue / THOUSAND);
        } else {
            return value;
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Price // instanceof handles nulls
                && value.equals(((Price) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}