    /**
     * Method that request to the syntax highlight processor to process and highlight a
     * document. This method request a partial process.
     *
     * @param spanable The spannable source to highlight
     * @param start The start of spannable to process
     * @param end The end of spannable to process
     */
    public abstract void process(Spannable spanable, int start, int end);

