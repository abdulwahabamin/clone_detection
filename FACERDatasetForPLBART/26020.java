    /**
     * Make sure initialize is called before calling this.
     */
    public static void setUniformTag(String tag) {
        if (tag != null && tag.length() != 0) {
            sOptions.uniformTag = tag;
        }
    }

