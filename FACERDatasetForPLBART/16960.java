    public static void preventDoubleClick() {
        if (System.currentTimeMillis() - timestamp < 500) {
            return;
        }
        timestamp = System.currentTimeMillis();
    }

