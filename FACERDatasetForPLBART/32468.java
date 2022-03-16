    private void processScreenOn(Context context) {
        Message completeMessage =
                handler.obtainMessage();
        completeMessage.obj = context;
        completeMessage.sendToTarget();
        processScreenOnInBg(context);
    }

