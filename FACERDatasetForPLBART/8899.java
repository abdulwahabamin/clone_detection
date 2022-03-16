    /**
     * Method that parse the result of a program invocation.
     *
     * @param input A partial standard input buffer (incremental buffer)
     * @hide
     */
    public final void onRequestParsePartialResult(byte[] input) {
        String partialIn = new String(input);
        synchronized (this.mSync) {
            String rest = ""; //$NON-NLS-1$
            if (parseOnlyCompleteLines()) {
                int pos = partialIn.lastIndexOf(FileHelper.NEWLINE);
                if (pos == -1) {
                    //Save partial data
                    this.mTempBuffer.append(partialIn);
                    return;
                }

                //Retrieve the data
                rest = partialIn.substring(pos + 1);
            }

            this.mPartialDataType.add(STDIN);
            this.mPartialData.add(input);
            this.mTempBuffer = new StringBuffer(rest);
            this.mSync.notify();
        }
    }

