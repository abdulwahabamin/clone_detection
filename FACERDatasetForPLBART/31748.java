    private boolean checkIfReconciliationDbServiceIsNotBound() {
        if (reconciliationDbService != null) {
            return false;
        }
        try {
            bindReconciliationDBService();
        } catch (Exception ie) {
            appendLog(getBaseContext(), TAG, "weatherForecastServiceIsNotBound interrupted:", ie);
        }
        return (reconciliationDbService == null);
    }

