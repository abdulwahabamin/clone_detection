        @Override
        public void handleMessage(Message msg) {
            appendLog(getBaseContext(), TAG, "handleMessage:", msg.what);
            int rotationSource = msg.arg1;
            switch (msg.what) {
                case START_ROTATING_UPDATE:
                    startRotatingUpdateIcon(rotationSource);
                    break;
                case STOP_ROTATING_UPDATE:
                    stopRotatingUpdateIcon(rotationSource);
                    break;
                default:
                    super.handleMessage(msg);
            }
        }

