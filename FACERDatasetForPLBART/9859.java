    /**
     * {@inheritDoc}
     */
    @Override
    public void onAsyncExitCode(int exitCode) {
        if (exitCode != 0) {
            this.mHandler.post(new Runnable() {
                @Override
                public void run() {
                    int cc = ComputeChecksumDialog.this.mChecksums.length;
                    for (int i = ComputeChecksumDialog.this.mComputeStatus; i < cc; i++) {
                        ComputeChecksumDialog.this.mChecksums[i].setText(R.string.error_message);
                    }
                }
            });
        }
    }

