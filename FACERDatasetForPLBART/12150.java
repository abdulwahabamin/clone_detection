    /**
     * Method that trim a buffer, let in the buffer some
     * text to ensure that the exit code is in there.
     *
     * @param sb The buffer to trim
     * @hide
     */
    @SuppressWarnings("static-method") void trimBuffer(ByteArrayOutputStream sb) {
        final int bufferSize =  mControlPattern
                .getEndControlPatternLength();
        if (sb.size() > bufferSize) {
            byte[] data = sb.toByteArray();
            sb.reset();
            sb.write(data, data.length - bufferSize, bufferSize);
        }
    }

