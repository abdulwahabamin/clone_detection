    public static void appendLogSensorsCheck(Context context,
                                             String tag,
                                             String reasonText,
                                             float currentLength,
                                             double countedLength,
                                             double countedAcc,
                                             float dT) {
        checkPreferences(context);
        if (!logToFileEnabled || (logFilePathname == null)) {
            return;
        }
        appendLog(context, tag, reasonText, ", currentLength = ", String.format("%.8f", currentLength),
                ":counted length = ", String.format("%.8f", countedLength), ":countedAcc = ",
                String.format("%.8f", countedAcc),
                ", dT = ", String.format("%.8f", dT));
    }

