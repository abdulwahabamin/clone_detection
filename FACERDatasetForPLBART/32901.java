    private static String capitalizeFirstLetter(String input) {
        if ((input == null) || (input.length() < 1)) {
            return "";
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

