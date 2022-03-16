    public void processAddresses(List<Address> addresses) {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
        appendLog(context, TAG, "processUpdateOfLocation:addresses:", addresses);
        if ((addresses != null) && (addresses.size() > 0)) {
            sendIntent.putExtra("addresses", addresses.get(0));
        }
        appendLog(context, TAG, "processUpdateOfLocation:sendIntent:", sendIntent);
        context.sendBroadcast(sendIntent);
    }

