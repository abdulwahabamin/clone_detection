        public void onServiceConnected(ComponentName className, IBinder binderService) {
            reconciliationDbService = new Messenger(binderService);
            reconciliationDbServiceLock.lock();
            try {
                while (!reconciliationDbUnsentMessages.isEmpty()) {
                    reconciliationDbService.send(reconciliationDbUnsentMessages.poll());
                }
            } catch (RemoteException e) {
                appendLog(getBaseContext(), TAG, e.getMessage(), e);
            } finally {
                reconciliationDbServiceLock.unlock();
            }
        }

