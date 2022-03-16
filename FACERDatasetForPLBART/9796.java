        @Override
        public void onPartialResult(Object result) {
            try {
                if (result == null) return;
                byte[] partial = (byte[])result;
                mOut.write(partial);
                mOut.flush();
            } catch (Exception ex) {
                Log.w(TAG, "Failed to parse partial result data", ex);
                closeWithError("Failed to parse partial result data: " + ex.getMessage());
                if (mSignal != null) {
                    mSignal.cancel();
                }
            }
        }

