    /**
     * Method that read the file
     *
     * @param file The file to read
     */
    private void read(File file) {
        // Read the file
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(file), getBufferSize());
            int read = 0;
            byte[] data = new byte[getBufferSize()];
            while ((read = bis.read(data, 0, getBufferSize())) != -1) {
                if (this.mAsyncResultListener != null) {
                    byte[] readData = new byte[read];
                    System.arraycopy(data, 0, readData, 0, read);
                    this.mAsyncResultListener.onPartialResult(readData);

                    // Check if the process was cancelled
                    try {
                        synchronized (this.mSync) {
                            if (this.mCancelled  || this.mEnded) {
                                this.mSync.notify();
                                break;
                            }
                        }
                    } catch (Exception e) {/**NON BLOCK**/}
                }
            }

        } catch (Exception e) {
            if (isTrace()) {
                Log.v(TAG, "Result: FAIL. InsufficientPermissionsException"); //$NON-NLS-1$
            }
            if (this.mAsyncResultListener != null) {
                this.mAsyncResultListener.onException(new InsufficientPermissionsException());
            }

        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (Throwable _throw) {/**NON BLOCK**/}
        }
    }

