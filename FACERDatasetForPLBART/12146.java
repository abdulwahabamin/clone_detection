    /**
     * Method that returns if the command has started by checking the
     * standard input buffer. This method also removes the control start command
     * from the buffer, if it's present, leaving in the buffer the new data bytes.
     *
     * @param stdin The standard in buffer
     * @return boolean If the command has started
     * @hide
     */
    boolean isCommandStarted(ByteArrayOutputStream stdin) {
        if (stdin == null) return false;
        byte[] data = stdin.toByteArray();
        final int[] match = mControlPattern.getStartControlMatch(data);
        if (match != null) {
            stdin.reset();
            stdin.write(data, match[1], data.length - match[1]);
            return true;
        }
        return false;
    }

