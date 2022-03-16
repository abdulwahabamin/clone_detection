    /**
     * Method that request to the syntax highlight processor if it is able to parse
     * the file
     *
     * @param file The file to check
     * @return boolean If the syntax highlight processor accepts process the file
     */
    protected abstract boolean accept(File file);

