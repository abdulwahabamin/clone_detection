        @Override
        protected Void doInBackground(Void... params) {
            while (!ExecutionDialog.this.mFinished) {
                // Extract the message
                try {
                    while (!ExecutionDialog.this.mQueue.isEmpty()) {
                        // Extract all items from the queue
                        List<String> l = ExecutionDialog.this.mQueue.peekAll();
                        StringBuilder sb = new StringBuilder();
                        for (String s : l) {
                            sb.append(s);
                            sb.append("\n"); //$NON-NLS-1$
                        }

                        // Extract the message and redraw
                        publishProgress(extractMsg());

                        // Don't kill the processor
                        try {
                            Thread.yield();
                            Thread.sleep(250L);
                        } catch (Throwable _throw) {/**NON BLOCK**/}
                    }
                } catch (Exception e) {/**NON BLOCK**/}
            }
            return null;
        }

