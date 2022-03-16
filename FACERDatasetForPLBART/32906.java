    private static String formatLocalityToTwoLines(String inputLocation) {
        if (inputLocation.length() < 30) {
            return inputLocation;
        }
        if (inputLocation.indexOf(",") < 30) {
            inputLocation.replaceFirst(", ", "\n");
        }
        return inputLocation;
    }

