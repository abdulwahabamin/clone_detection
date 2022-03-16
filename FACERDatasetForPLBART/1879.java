    @Override
    public void onTaskRemoved(Intent rootIntent) {
        try {
            RealmManager.getRealm().close();
            Realm.compactRealm(RealmHelper.getRealmConfig());
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        try {
            if (BLUETOOTHSERVICE!=null) {
                BLUETOOTHSERVICE.close();
            }
            Utils.showToast(getApplicationContext(), "BlueChat Disconnected");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        Utils.log("app killed");
        stopSelf();
        super.onTaskRemoved(rootIntent);

    }

