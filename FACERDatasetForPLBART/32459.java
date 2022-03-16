        @Override
        public void handleMessage(Message msg) {
            appendLog(getBaseContext(), TAG, "handleMessage:", msg.what, ":", msg.arg1);
            switch (msg.what) {
                case START_RECONCILIATION:
                    startReconciliation((msg.arg1 == 1)?true:false);
                    break;
                default:
                    super.handleMessage(msg);
            }
        }

