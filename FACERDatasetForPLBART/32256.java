    private void bindReconciliationDBService() {
        getApplicationContext().bindService(
                new Intent(getApplicationContext(), ReconciliationDbService.class),
                reconciliationDbServiceConnection,
                Context.BIND_AUTO_CREATE);
    }

