    /**
     * Method invoked when the execution ends
     *
     * @param exitCode The exit code of the execution
     */
    public void onEnd(final int exitCode) {
        // Cancel the drawing task
        try {
            this.mFinished = true;
            this.mConsoleDrawTask.cancel(false);
        } catch (Exception e) {/**NON BLOK**/}

        long endTime = System.currentTimeMillis();
        final String diff = String.valueOf((endTime - this.mStartTime) / 1000);

        // Enable the ok button
        this.mTvOutput.post(new Runnable() {
            @Override
            public void run() {
                try {
                    // Draw the data one more time, and clean the queue (no more needed)
                    drawMessage(extractMsg(), true);
                    ExecutionDialog.this.mQueue.removeAll();
                } catch (EmptyQueueException eqex) {/**NON BLOCK**/}

                // Set the time and exit code
                ExecutionDialog.this.mTvTime.setText(
                        ExecutionDialog.this.mContext.getString(
                                R.string.execution_console_script_execution_time_text, diff));
                ExecutionDialog.this.mTvExitCode.setText(String.valueOf(exitCode));

                // Enable the Ok button
                ExecutionDialog.this.mDialog.setCancelable(true);
                Button button =
                        ExecutionDialog.this.mDialog.getButton(DialogInterface.BUTTON_NEUTRAL);
                button.setText(R.string.ok);
                button.setEnabled(true);
            }
        });
    }

