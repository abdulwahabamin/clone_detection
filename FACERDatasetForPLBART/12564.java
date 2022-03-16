    /**
     * Constructor
     *
     * @param fso {@link java.io.File}
     * @throws IllegalArgumentException {@link java.lang.IllegalArgumentException}
     */
    public SecureChoiceSelectionListener(File fso) throws IllegalArgumentException {
        if (fso == null) {
            throw new IllegalArgumentException("'fso' cannot be null!");
        }
        mFile = fso;
    }

