    /**
     * Method that copies a file, using FileChannel.transferFrom from
     * the nio package.
     *
     * The file is chunked into chunks of size {@link #NIO_COPY_CHUNK_SIZE}
     * and each chunk is transferred until the file is completely copied. This
     * allows us to cancel the file transfer at any time.
     *
     * @param src The source file
     * @param dst The destination file
     * @return boolean Whether the operation completed successfully
     */
    public static boolean copyFileWithNio(final File src, final File dst,
            Program program) throws CancelledOperationException, ExecutionException {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        long currentPosition = 0;
        long count = NIO_COPY_CHUNK_SIZE;
        try {
            inputChannel = new FileInputStream(src).getChannel();
            outputChannel = new FileOutputStream(dst).getChannel();
            while (currentPosition < inputChannel.size()) {
                // Short circuit if we've been cancelled. Show's over :(
                if (program.isCancelled()) {
                    throw new CancelledOperationException();
                }

                if ((currentPosition + count) > inputChannel.size()) {
                    count = (inputChannel.size() - currentPosition);
                }
                outputChannel.transferFrom(inputChannel, currentPosition, count);
                currentPosition = currentPosition + count;
            }
        } catch (Throwable e) {
            Log.e(TAG,
                    String.format(TAG, "Failed to copy from %s to %d", src, dst), e); //$NON-NLS-1$

            try {
                // Delete the destination file upon failure
                if (!dst.delete()) {
                    Log.e(TAG, "Failed to delete the dest file: " + dst);
                }
            } catch (Throwable t) {/**NON BLOCK**/}

            // Check if this error is an out of space exception and throw that specifically.
            // ENOSPC -> Error No Space
            if (e.getCause() instanceof ErrnoException
                        && ((ErrnoException)e.getCause()).errno == OsConstants.ENOSPC) {
                throw new ExecutionException(R.string.msgs_no_disk_space);
            } else if (e instanceof CancelledOperationException) {
                // If the user cancelled this operation, let it through.
                throw (CancelledOperationException)e;
            } else if (e instanceof ClosedByInterruptException) {
                // The thread running this operation was interrupted.
                // This is likely because the user cancelled the operation,
                // which cancelled the AsyncTask.
                throw new CancelledOperationException();
            }
            return false;
        } finally {
            try {
                if (inputChannel != null) {
                    inputChannel.close();
                }
            } catch (IOException e) {
                Log.e(TAG, "Error while closing input channel during copyFileWithNio");
            }
            try {
                if (outputChannel != null) {
                    outputChannel.close();
                }
            } catch (IOException e) {
                Log.e(TAG, "Error while closing output channel during copyFileWithNio");
            }

        }
        return true;
    }

