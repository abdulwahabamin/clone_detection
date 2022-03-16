        protected void unbindReconciliationDbService() {
            if (reconciliationDbService == null) {
                return;
            }
            getActivity().getApplicationContext().unbindService(reconciliationDbServiceConnection);
        }

