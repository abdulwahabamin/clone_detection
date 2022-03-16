        private void closeWithError(String msg) {
            try {
                mOut.close();
            } catch (IOException ex) {
                // Ignore
            }
            try {
                mIn.close();
            } catch (IOException ex) {
                // Ignore
            }
            try {
                mFdOut.closeWithError(msg);
            } catch (IOException ex) {
                // Ignore
            }
            try {
                mFdIn.close();
            } catch (IOException ex) {
                // Ignore
            }
        }

