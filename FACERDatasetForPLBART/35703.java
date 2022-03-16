    public void resetTimeMonitor(int id) {
        if (timeMonitorList.get(id) != null) {
            timeMonitorList.remove(id);
        }

        getTimeMonitor(id);
    }

