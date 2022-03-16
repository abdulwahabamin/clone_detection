    /**
     * {@inheritDoc}
     */
    @Override
    public void onParsePartialResult(final byte[] in) {
        String partialIn = new String(in);
        if (partialIn == null || partialIn.length() == 0) return;
        boolean endsWithNewLine = partialIn.endsWith("\n"); //$NON-NLS-1$
        String[] lines = partialIn.split("\n"); //$NON-NLS-1$

        // Append the pending data to the first line
        lines[0] = this.mPartial + lines[0];

        // Return all the lines, except the last
        for (int i = 0; i < lines.length - 1; i++) {
            if (getAsyncResultListener() != null) {
                String data = processPartialResult(lines[i]);
                if (data != null) {
                    getAsyncResultListener().onPartialResult(data);
                }
            }
        }

        // Return the last line?
        if (endsWithNewLine) {
            if (getAsyncResultListener() != null) {
                String data = processPartialResult(lines[lines.length - 1]);
                if (data != null) {
                    getAsyncResultListener().onPartialResult(data);
                }
            }
            this.mPartial = ""; //$NON-NLS-1$
        } else {
            // Save the partial for next calls
            this.mPartial = lines[lines.length - 1];
        }
    }

