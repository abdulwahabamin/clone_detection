    /**
     * Construct a JSONTokener from a Reader.
     *
     * @param reader     A reader.
     */
    public JSONTokener(Reader reader) {
        this.reader = reader.markSupported()
            ? reader
            : new BufferedReader(reader);
        this.eof = false;
        this.usePrevious = false;
        this.previous = 0;
        this.index = 0;
        this.character = 1;
        this.line = 1;
    }

