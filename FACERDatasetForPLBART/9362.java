    /**
     * Method that checks the console status and restart the console
     * if this is unusable.
     *
     * @throws ConsoleAllocException If the console can't be reallocated
     */
    private void checkConsole() throws ConsoleAllocException {
        try {
            //Test write something to the buffer
            this.mOut.write(FileHelper.NEWLINE.getBytes());
            this.mOut.write(FileHelper.NEWLINE.getBytes());
        } catch (IOException ioex) {
            //Something is wrong with the buffers. Reallocate console.
            Log.w(TAG,
                "Something is wrong with the console buffers. Reallocate console.", //$NON-NLS-1$
                ioex);

            //Reallocate the damage console
            realloc();
        }
    }

