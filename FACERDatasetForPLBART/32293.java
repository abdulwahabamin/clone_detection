        @Override
        public void handleMessage(Message msg) {
            int wakeUpSource = msg.arg1;
            appendLog(getBaseContext(), TAG, "handleMessage:", msg.what, ":", wakeUpSource);
            switch (msg.what) {
                case WAKE_UP:
                    startWakeUp(wakeUpSource);
                    break;
                case FALL_DOWN:
                    stopWakeUp(wakeUpSource);
                    break;
                default:
                    super.handleMessage(msg);
            }
        }

