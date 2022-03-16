    protected void sendMessageToReconciliationDbService(boolean force) {
        appendLog(this,
                TAG,
                "going run reconciliation DB service");
        reconciliationDbServiceLock.lock();
        try {
            Message msg = Message.obtain(
                    null,
                    ReconciliationDbService.START_RECONCILIATION,
                    force?1:0
            );
            if (checkIfReconciliationDbServiceIsNotBound()) {
                //appendLog(getBaseContext(), TAG, "WidgetIconService is still not bound");
                reconciliationDbUnsentMessages.add(msg);
                return;
            }
            //appendLog(getBaseContext(), TAG, "sendMessageToService:");
            reconciliationDbService.send(msg);
        } catch (RemoteException e) {
            appendLog(getBaseContext(), TAG, e.getMessage(), e);
        } finally {
            reconciliationDbServiceLock.unlock();
        }
    }

