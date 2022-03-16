    private boolean checkIfLocationUpdateServiceIsNotBound(Context context) {
        if (locationUpdateService != null) {
            return false;
        }
        try {
            bindLocationUpdateService(context);
        } catch (Exception ie) {
            appendLog(context, TAG, "locationUpdtaeServiceIsNotBound interrupted:", ie);
        }
        return (locationUpdateService == null);
    }

