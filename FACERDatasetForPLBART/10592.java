    /**
     * Method that formats a filetime date with the specific system settings
     *
     * @param ctx The current context
     * @param filetime The filetime date
     * @return String The filetime date formatted
     */
    public static String formatFileTime(Context ctx, Date filetime) {
        synchronized (DATETIME_SYNC) {
            if (sReloadDateTimeFormats) {
                String defaultValue =
                        ((ObjectStringIdentifier)FileManagerSettings.
                                    SETTINGS_FILETIME_FORMAT_MODE.getDefaultValue()).getId();
                String id = FileManagerSettings.SETTINGS_FILETIME_FORMAT_MODE.getId();
                sFiletimeFormatMode =
                        FileTimeFormatMode.fromId(
                                Preferences.getSharedPreferences().getString(id, defaultValue));
                if (sFiletimeFormatMode.compareTo(FileTimeFormatMode.SYSTEM) == 0) {
                    sDateTimeFormatOrder = ctx.getString(R.string.datetime_format_order);
                    sDateFormat = android.text.format.DateFormat.getDateFormat(ctx);
                    sTimeFormat = android.text.format.DateFormat.getTimeFormat(ctx);
                } else if (sFiletimeFormatMode.compareTo(FileTimeFormatMode.LOCALE) == 0) {
                    sDateFormat =
                            DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
                } else {
                    sDateFormat = new SimpleDateFormat(sFiletimeFormatMode.getFormat());
                }
                sReloadDateTimeFormats = false;
            }
        }

        // Apply the user settings
        if (sFiletimeFormatMode.compareTo(FileTimeFormatMode.SYSTEM) == 0) {
            String date = sDateFormat.format(filetime);
            String time = sTimeFormat.format(filetime);
            return String.format(sDateTimeFormatOrder, date, time);
        } else {
            return sDateFormat.format(filetime);
        }
    }

