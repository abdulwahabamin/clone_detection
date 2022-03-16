    /**
     * Method that create the default syntax highlight factory.
     *
     * @param resolver A class for allow the processor to obtain resources
     * @return SyntaxHighlightFactory The default factory
     */
    private static SyntaxHighlightFactory createDefaultFactory(
            ISyntaxHighlightResourcesResolver resolver) {
        // TODO Read all processors classes of the SPI package
        // For now we add all known syntax highlight processors
        SyntaxHighlightFactory factory = new SyntaxHighlightFactory();
        factory.mProcessors.add(new PropertiesSyntaxHighlightProcessor(resolver));
        return factory;
    }

