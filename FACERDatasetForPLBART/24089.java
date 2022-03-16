    public static boolean isLong(String s) {
        if (s == null) return false;
        try {
            //noinspection ResultOfMethodCallIgnored
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

