    public static int getInt(String value) {
        try {
            int i = Integer.parseInt(value);
            return i;
        } catch (Exception e) {
            return 0;
        }
    }

