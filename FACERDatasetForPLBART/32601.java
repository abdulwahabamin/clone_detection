        private void bindReconciliationDBService() {
            getActivity().getApplicationContext().bindService(
                    new Intent(getActivity().getApplicationContext(), ReconciliationDbService.class),
                    reconciliationDbServiceConnection,
                    Context.BIND_AUTO_CREATE);
        }

