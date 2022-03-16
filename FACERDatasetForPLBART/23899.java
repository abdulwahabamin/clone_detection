    private void logSuffleOrder(String name, Integer[] order) {

        if (false) {
            String logStr = name + "={";
            for (int i = 0; i < order.length; i++) {
                if (i != 0)
                    logStr += ",";
                logStr += order[i];
            }
            logStr += "}";
            Log.d(TAG, logStr);
        }
    }

