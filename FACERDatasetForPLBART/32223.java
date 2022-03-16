        @Override
        public void handleMessage(Message inputMessage) {

            widgetRotationServiceLock.lock();
            try {
                Message msg = Message.obtain(null, inputMessage.arg1, inputMessage.arg2, 0);
                if (checkIfWidgetIconServiceIsNotBound()) {
                    //appendLog(getBaseContext(), TAG, "WidgetIconService is still not bound");
                    unsentMessages.add(msg);
                    return;
                }
                //appendLog(getBaseContext(), TAG, "sendMessageToService:");
                widgetRefreshIconService.send(msg);
            } catch (RemoteException e) {
                appendLog(getBaseContext(), TAG, e.getMessage(), e);
            } finally {
                widgetRotationServiceLock.unlock();
            }
        }

