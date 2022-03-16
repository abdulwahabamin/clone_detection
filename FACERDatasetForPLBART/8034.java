    /**
     * Method that returns the default highlight factory instance
     *
     * @param resolver A class for allow the processor to obtain resources
     * @return SyntaxHighlightFactory The default syntax highlight factory
     */
    public static final synchronized SyntaxHighlightFactory getDefaultFactory(
            ISyntaxHighlightResourcesResolver resolver) {
        if (sFactory == null) {
            sFactory = createDefaultFactory(resolver);
        }
        return sFactory;
    }

