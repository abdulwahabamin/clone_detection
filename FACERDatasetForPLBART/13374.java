    /**
     * Method that copies recursively to the destination
     *
     * @param src The source file or folder
     * @param dst The destination file or folder
     * @return boolean If the operation complete successfully
     * @throws ExecutionException If a problem was detected in the operation
     */
    public static boolean copyRecursive(
            final File src, final File dst, Program program)
                throws ExecutionException, CancelledOperationException {
        if (src.isDirectory()) {
            // Create the directory
            if (dst.exists() && !dst.isDirectory()) {
                Log.e(TAG,
                        String.format("Failed to check destionation dir: %s", dst)); //$NON-NLS-1$
                throw new ExecutionException("the path exists but is not a folder"); //$NON-NLS-1$
            }
            if (!dst.exists()) {
                if (!dst.mkdir()) {
                    Log.e(TAG, String.format("Failed to create directory: %s", dst)); //$NON-NLS-1$
                    return false;
                }
            }
            File[] files = src.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    // Short circuit if we've been cancelled. Show's over :(
                    if (program.isCancelled()) {
                        throw new CancelledOperationException();
                    }

                    if (!copyRecursive(files[i], new File(dst, files[i].getName()),
                                       program)) {
                        return false;
                    }
                }
            }
        } else {
            // Copy the directory
            if (!copyFileWithNio(src, dst, program)) {
                return false;
            }
        }
        return true;
    }

