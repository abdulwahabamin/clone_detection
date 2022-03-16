    /**
     * Method that return all the available syntax highlight processors.
     *
     * @return List<SyntaxHighlightProcessor> the list available syntax highlight processors.
     */
    public List<SyntaxHighlightProcessor> getAvailableSyntaxHighlightProcessors() {
        return new ArrayList<SyntaxHighlightProcessor>(this.mProcessors);
    }

