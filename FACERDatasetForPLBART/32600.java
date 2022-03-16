        private boolean checkIfReconciliationDbServiceIsNotBound() {
            if (reconciliationDbService != null) {
                return false;
            }
            try {
                bindReconciliationDBService();
            } catch (Exception ie) {
                appendLog(getActivity(), TAG, "weatherForecastServiceIsNotBound interrupted:", ie);
            }
            return (reconciliationDbService == null);
        }

