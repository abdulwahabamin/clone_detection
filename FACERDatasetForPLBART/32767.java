    public static void appendLogWakeupSources(Context context, String tag, String wakeupdown, List<Integer> wakeUpSources) {
        checkPreferences(context);
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        StringBuilder wakeupSourcesList = new StringBuilder();
        wakeupSourcesList.append(wakeupdown);
        wakeupSourcesList.append(", wakeUpSources.size=");
        wakeupSourcesList.append(wakeUpSources.size());
        wakeupSourcesList.append(", WakeUp source list: ");
        for (Integer wakeupSource: wakeUpSources) {
            wakeupSourcesList.append(wakeupSource);
            wakeupSourcesList.append(",");
        }
        appendLog(context, tag, wakeupdown, "wakeUpSources:", wakeupSourcesList.toString());
    }

