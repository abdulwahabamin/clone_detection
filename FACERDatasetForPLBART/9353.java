    /**
     * {@inheritDoc}
     */
    @Override
    public final void dealloc() {
        synchronized (this.mSync) {
            if (this.mActive) {
                this.mActive = false;
                this.mFinished = true;

                //Close buffers
                try {
                    if (this.mIn != null) {
                        this.mIn.close();
                    }
                } catch (Throwable ex) {
                    /**NON BLOCK**/
                }
                try {
                    if (this.mErr != null) {
                        this.mErr.close();
                    }
                } catch (Throwable ex) {
                    /**NON BLOCK**/
                }
                try {
                    if (this.mOut != null) {
                        this.mOut.close();
                    }
                } catch (Throwable ex) {
                    /**NON BLOCK**/
                }
                try {
                    this.mProc.destroy();
                } catch (Throwable e) {/**NON BLOCK**/}
                this.mIn = null;
                this.mErr = null;
                this.mOut = null;
                this.mSbIn = null;
                this.mSbErr = null;
            }
        }
    }

