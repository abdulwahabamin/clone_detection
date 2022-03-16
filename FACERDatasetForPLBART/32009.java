    private int mapBooleanToInt(Boolean booleanValue) {
        if (booleanValue == null) {
            return 0;
        } else if (booleanValue) {
            return 1;
        } else {
            return 2;
        }
    }

