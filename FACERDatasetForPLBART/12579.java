        private void close() {
            try {
                mOut.close();
            } catch (IOException ex) {
                // Ignore
            }
            try {
                mFdOut.close();
            } catch (IOException ex) {
                // Ignore
            }
        }

