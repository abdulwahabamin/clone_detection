    /**
     * Method that append data to the console output
     *
     * @param msg The message to append
     */
    public void onAppendData(final String msg) {
        if (msg != null && msg.length() > 0) {
            // Split the messages in lines
            String[] lines = msg.split("\n"); //$NON-NLS-1$
            for (String line : lines) {
                // Don't allow lines with more that x characters
                if (line.length() > this.maxChars) {
                    while (line.length() > this.maxChars) {
                        String partial = line.substring(0, Math.min(line.length(), this.maxChars));
                        line = line.substring(Math.min(line.length(), this.maxChars));
                        // The partial
                        this.mQueue.insert(partial);
                    }
                    if (line.length() > 0) {
                        // Insert the rest of the line
                        this.mQueue.insert(line);
                    }
                } else {
                    // Insert the line
                    this.mQueue.insert(line);
                }
            }

        }
    }

