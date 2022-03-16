    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void onStatusEvent(ChatStatusEvent statusEvent)
    {
        if (statusEvent.status==Constants.STATUS_DISCONNECTED)
        {
            closeBluetoothService(statusEvent.macAddress);
        }
    }

