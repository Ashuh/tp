package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.ViewImageCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

public class ViewImageCommandParser implements Parser<ViewImageCommand> {

    @Override
    public ViewImageCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new ViewImageCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
              String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewImageCommand.MESSAGE_USAGE), pe);
        }
    }
}
