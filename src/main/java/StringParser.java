import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringParser {
    private static final String NEWLINE_DELIMITER = "\n";
    private static final String DEFAULT_DELIMITER = ",";
    private static final String FIND_DELIMITER_PATTERN = "^[/]{2}\\[(.*)\\]+\\n";

    private Boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private String getCustomDelimiter(String input) {
        final Pattern p = Pattern.compile(FIND_DELIMITER_PATTERN);
        final Matcher m = p.matcher(input);

        if (m.find()) {
            return m.group(1);
        }

        throw new IllegalStateException("Couldn't find custom delimiter");
    }

    private String formatDelimiters(List<String> delimiters) {
        return delimiters.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining("|", "[", "]"));
    }

    private String stripHeadline(String input) {
        return input.replaceFirst(FIND_DELIMITER_PATTERN, "");
    }

    public List<Integer> parse(String input) {
        List<String> delimiters = new ArrayList<>();
        delimiters.add(NEWLINE_DELIMITER);
        if (hasCustomDelimiter(input)) {
            delimiters.add(getCustomDelimiter(input));
            input = stripHeadline(input);
        } else {
            delimiters.add(DEFAULT_DELIMITER);
        }

        var delimitersFormatted = formatDelimiters(delimiters);

        return List.of(input.split(delimitersFormatted))
                .stream()
                .filter(s -> !s.isEmpty())
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }
}