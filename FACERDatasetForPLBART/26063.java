    private static String tag(Object tag) {
        final LogOptions options = sOptions;
        return (options.uniformTag == null ? (tag instanceof String ? (String) tag
                : tag.getClass().getSimpleName())
                : options.uniformTag);
    }

