    public static boolean isUpdateLocationEnabled(Context context, Location currentLocation) {
        if ((currentLocation == null) || (currentLocation.getOrderId() != 0) || !currentLocation.isEnabled()) {
            return false;
        }
        return true;
    }

