package console_application.work_with_route;

import java.util.regex.*;

/**
 * The class contains a single method that checks the validity of the entered data
 */
public class ValuesChecking {
    private ValuesChecking() {
    }

    public static String checkCondition(String input, RouteFields field) throws IllegalArgumentException {
        Matcher matcher = Pattern.compile("\\s*([a-z0-9A-Z.-]+)").matcher(input);
        Pattern numberPattern = Pattern.compile("^\\s*(-?[0-9]+(\\.[0-9]+)*)");
        boolean isInputNull = !matcher.find();
        switch (field) {
            case R_NAME:
            case FL_NAME:
                if (isInputNull)
                    throw new IllegalArgumentException("Значение не может быть null");
                return matcher.group(1);
            case R_DISTANCE:
                matcher = numberPattern.matcher(input);
                if (matcher.find()) {
                    if (Double.parseDouble(matcher.group(1)) >= 1D)
                        return matcher.group(1);
                    else
                        throw new IllegalArgumentException("Значение должно превышать 1");
                } else if (isInputNull)
                    throw new IllegalArgumentException("Значение не может быть null");
                else
                    throw new NumberFormatException();
            case C_X:
                matcher = numberPattern.matcher(input);
                if (isInputNull)
                    throw new IllegalArgumentException("Значение не может быть null");
                else if (matcher.find()) {
                    if (Double.parseDouble(matcher.group(1)) >= -140D)
                        return matcher.group(1);
                    else
                        throw new IllegalArgumentException("Значение должно превышать -140");
                } else
                    throw new NumberFormatException();
            case C_Y:
            case FL_Y:
            case SL_X:
            case FL_X:
            case FL_Z:
            case SL_Y:
            case SL_Z:
                matcher = numberPattern.matcher(input);
                if (isInputNull)
                    throw new IllegalArgumentException("Значение не может быть null");
                else if (matcher.find())
                    return matcher.group(1);
                else
                    throw new NumberFormatException();
            default:
                break;
        }
        return input;
    }
}
