        public void cancel() {
            writtenMsg=null;
            try {
                mmSocket.close();
            } catch (IOException e) {
                Log.e(TAG, "Could not close the connect socket", e);
            }
            EventBus.getDefault().postSticky(new ChatStatusEvent(Constants.STATUS_DISCONNECTED,macAddress));

        }

