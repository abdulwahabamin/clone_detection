    /**
     * Method that returns the syntax highlight processor that can handle the file
     *
     * @param file The file to process
     * @return SyntaxHighlightProcessor The syntax highlight processor
     */
    public SyntaxHighlightProcessor getSyntaxHighlightProcessor(File file) {
        int cc = this.mProcessors.size();
        for (int i = 0; i < cc; i++) {
            SyntaxHighlightProcessor processor = this.mProcessors.get(i);
            if (processor.accept(file)) {
                return processor;
            }
        }
        return null;
    }

