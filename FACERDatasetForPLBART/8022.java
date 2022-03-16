    /**
     * Constructor of <code>Scanner</code>
     *
     * @param input The input
     * @param listener The listener where return every new line
     */
    public NewLineScanner(CharSequence input, NewLineScannerListener listener) {
        super(input);
        this.mListener = listener;
    }

