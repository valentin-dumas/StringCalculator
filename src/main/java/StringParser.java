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

    private List<String> getCustomDelimiters(String input) {
        final Pattern p = Pattern.compile(FIND_DELIMITER_PATTERN);
        final Matcher m = p.matcher(input);

        List<String> customDelimiters = new ArrayList<>();
        customDelimiters.add(NEWLINE_DELIMITER);

        if (m.find()) {
            customDelimiters.add(m.group(1)); // extracted delimiter
        }

        return customDelimiters;
    }

    private String formatDelimiters(List<String> delimiters) {
        return delimiters.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining("|", "[", "]"));
    }

    private String removeCustomDelimiters(String input) {
        return input.replaceFirst(FIND_DELIMITER_PATTERN, "");
    }

    public List<Integer> parse(String input) {
        List<String> delimiters = new ArrayList<>();
        delimiters.add(NEWLINE_DELIMITER);
        if (hasCustomDelimiter(input)) {
            delimiters = getCustomDelimiters(input);
            input = removeCustomDelimiters(input);
        } else {
            delimiters.add(DEFAULT_DELIMITER);
        }

        var delimitersFormatted = formatDelimiters(delimiters);

        //System.out.println(delimitersFormatted);

        return List.of(input.split(delimitersFormatted))
                .stream()
                .filter(s -> !s.isEmpty())
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

}