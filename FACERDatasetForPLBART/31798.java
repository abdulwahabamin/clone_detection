    private String getLocationNickname(Context context, Location location) {
        String locationNickname = location.getNickname();
        if ((locationNickname == null) || "".equals(locationNickname)) {
            if (location.getOrderId() == 0) {
                if (!location.isEnabled()) {
                    return " - " + context.getString(R.string.locations_disabled);
                } else {
                    return " - " + context.getString(R.string.locations_automatically_discovered);
                }
            } else {
                return "";
            }
        }
        return " - " + locationNickname;
    }

