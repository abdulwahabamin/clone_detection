    /**
     * Method that returns the exit code of the last executed command.
     *
     * @param stdin The standard in buffer
     * @return int The exit code of the last executed command
     */
    private int getExitCode(ByteArrayOutputStream stdin, boolean async) {
        // If process was cancelled, don't expect a exit code.
        // Returns always 143 code
        if (this.mCancelled) {
            return 143;
        }

        byte[] bytes = stdin.toByteArray();
        int[] match = mControlPattern.getEndControlMatch(bytes);

        if (match != null) {
            if (!async) {
                mSbIn.reset();
                mSbIn.write(bytes, 0, match[0]);
            }
            // find the indices of the exit code and extract it
            match = mControlPattern.getEndControlMatch(bytes, true);
            return Integer.parseInt(new String(bytes, match[0], match[1] - match[0]));
        }
        return 255;
    }

