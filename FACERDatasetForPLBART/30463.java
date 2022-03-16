    public static long getF(String value) {
        try {
            long i = Integer.parseInt(value);
            i = Math.round((i * 1.8 + 32));
            return i;
        } catch (Exception e) {
            return 0;
        }
    }

