    /**
     * Method that parse the error result of a program invocation.
     *
     * @param partialErr A partial standard err buffer (incremental buffer)
     * @hide
     */
    public final void parsePartialErrResult(String partialErr) {
        synchronized (this.mSync) {
            String data = partialErr;
            String rest = ""; //$NON-NLS-1$
            if (parseOnlyCompleteLines()) {
                int pos = partialErr.lastIndexOf(FileHelper.NEWLINE);
                if (pos == -1) {
                    //Save partial data
                    this.mTempBuffer.append(partialErr);
                    return;
                }

                //Retrieve the data
                data = this.mTempBuffer.append(partialErr.substring(0, pos + 1)).toString();
                rest = partialErr.substring(pos + 1);
            }

            this.mPartialDataType.add(STDERR);
            this.mPartialData.add(data.getBytes());
            this.mTempBuffer = new StringBuffer(rest);
            this.mSync.notify();
        }
    }

