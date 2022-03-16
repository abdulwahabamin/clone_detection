    protected void sendMessageToWidgetIconService(int action, int rotationsource) {
        Message completeMessage =
                handler.obtainMessage();
        completeMessage.arg1 = action;
        completeMessage.arg2 = rotationsource;
        completeMessage.sendToTarget();
    }

