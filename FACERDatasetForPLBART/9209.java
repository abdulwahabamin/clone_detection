    /**
     * Method that returns the stream where write the data.<br/>
     * <br/>
     * NOTE: Don't close this buffer. It is internally closed.
     *
     * @return OutputStream The stream where write the data
     * @throws IOException If the buffer couldn't be created
     */
    public OutputStream createOutputStream() throws IOException;

