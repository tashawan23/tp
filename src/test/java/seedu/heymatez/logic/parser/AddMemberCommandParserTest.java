package seedu.heymatez.logic.parser;

import static seedu.heymatez.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.heymatez.commons.core.Messages.MESSAGE_INVALID_PERSON_DISPLAYED_NAME;
import static seedu.heymatez.commons.core.Messages.MESSAGE_INVALID_PERSON_EMAIL;
import static seedu.heymatez.commons.core.Messages.MESSAGE_INVALID_PERSON_PHONE;
import static seedu.heymatez.logic.commands.CommandTestUtil.EMAIL_DESC_AMY;
import static seedu.heymatez.logic.commands.CommandTestUtil.EMAIL_DESC_BOB;
import static seedu.heymatez.logic.commands.CommandTestUtil.INVALID_EMAIL_DESC;
import static seedu.heymatez.logic.commands.CommandTestUtil.INVALID_NAME_DESC;
import static seedu.heymatez.logic.commands.CommandTestUtil.INVALID_PHONE_DESC;
import static seedu.heymatez.logic.commands.CommandTestUtil.NAME_DESC_BOB;
import static seedu.heymatez.logic.commands.CommandTestUtil.PHONE_DESC_AMY;
import static seedu.heymatez.logic.commands.CommandTestUtil.PHONE_DESC_BOB;
import static seedu.heymatez.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.heymatez.logic.commands.CommandTestUtil.ROLE_DESC_BOB;
import static seedu.heymatez.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.heymatez.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.heymatez.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.heymatez.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.heymatez.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.heymatez.testutil.TypicalPersons.BOB;

import org.junit.jupiter.api.Test;

import seedu.heymatez.logic.commands.AddMemberCommand;
import seedu.heymatez.model.person.Email;
import seedu.heymatez.model.person.Name;
import seedu.heymatez.model.person.Person;
import seedu.heymatez.model.person.Phone;
import seedu.heymatez.testutil.PersonBuilder;

/**
 * Contains unit tests for {@code AddMemberCommandParser}.
 */
public class AddMemberCommandParserTest {
    private AddMemberCommandParser parser = new AddMemberCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        Person expectedPerson = new PersonBuilder(BOB).build();

        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + VALID_NAME_BOB + PHONE_DESC_BOB + EMAIL_DESC_BOB
                        + ROLE_DESC_BOB, new AddMemberCommand(expectedPerson));

        // multiple phones - last phone accepted
        assertParseSuccess(parser, NAME_DESC_BOB + PHONE_DESC_AMY + PHONE_DESC_BOB + EMAIL_DESC_BOB
                + ROLE_DESC_BOB, new AddMemberCommand(expectedPerson));

        // multiple emails - last email accepted
        assertParseSuccess(parser, NAME_DESC_BOB + PHONE_DESC_BOB + EMAIL_DESC_AMY + EMAIL_DESC_BOB
                        + ROLE_DESC_BOB, new AddMemberCommand(expectedPerson));

    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddMemberCommand.MESSAGE_USAGE);

        // missing phone prefix
        assertParseFailure(parser, NAME_DESC_BOB + VALID_PHONE_BOB + EMAIL_DESC_BOB, expectedMessage);

        // missing email prefix
        assertParseFailure(parser, NAME_DESC_BOB + PHONE_DESC_BOB + VALID_EMAIL_BOB, expectedMessage);

        // all prefixes missing
        assertParseFailure(parser, VALID_NAME_BOB + VALID_PHONE_BOB + VALID_EMAIL_BOB, expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid name
        assertParseFailure(parser, INVALID_NAME_DESC + PHONE_DESC_BOB + EMAIL_DESC_BOB,
                MESSAGE_INVALID_PERSON_DISPLAYED_NAME + Name.MESSAGE_CONSTRAINTS);

        // invalid phone
        assertParseFailure(parser, NAME_DESC_BOB + INVALID_PHONE_DESC + EMAIL_DESC_BOB ,
                MESSAGE_INVALID_PERSON_PHONE + Phone.MESSAGE_CONSTRAINTS);

        // invalid email
        assertParseFailure(parser, NAME_DESC_BOB + PHONE_DESC_BOB + INVALID_EMAIL_DESC ,
                MESSAGE_INVALID_PERSON_EMAIL + Email.MESSAGE_CONSTRAINTS);

        // two invalid values, only first invalid value reported
        assertParseFailure(parser, INVALID_NAME_DESC + PHONE_DESC_BOB + EMAIL_DESC_BOB,
                MESSAGE_INVALID_PERSON_DISPLAYED_NAME + Name.MESSAGE_CONSTRAINTS);

    }
}
