    private static long[] isVibrateEnabled(Context context) {
        if (!AppPreference.isVibrateEnabled(context)) {
            return null;
        }
        return new long[]{0, 500, 500};
    }

