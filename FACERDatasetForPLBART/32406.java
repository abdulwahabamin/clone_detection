    public void processAddresses(List<Address> addresses) {
        appendLog(context, TAG, "processUpdateOfLocation:addresses:", addresses);
        Address resolvedAddress = null;
        if ((addresses != null) && (addresses.size() > 0)) {
            resolvedAddress = addresses.get(0);
        }
        appendLog(context, TAG, "processUpdateOfLocation:location:", location, ", address=", resolvedAddress);
        mozillaLocationService.reportNewLocation(location, resolvedAddress);
    }

