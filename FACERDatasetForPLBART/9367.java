    /**
     * Method that returns if the command has finished by checking the
     * standard input buffer.
     *
     * @param stdin The standard in buffer
     * @return boolean If the command has finished
     * @hide
     */
    boolean isCommandFinished(ByteArrayOutputStream stdin, ByteArrayOutputStream partial) {
        if (stdin == null) return false;

        int[] match = mControlPattern.getEndControlMatch(stdin.toByteArray());
        boolean ret = match != null;
        // Remove partial
        if (ret && partial != null) {

            byte[] bytes = partial.toByteArray();
            match = mControlPattern.getEndControlMatch(bytes);

            if (match != null) {
                partial.reset();
                partial.write(bytes, 0, match[0]);
            }
        }
        return ret;
    }

