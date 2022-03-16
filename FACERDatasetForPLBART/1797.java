    @Override
    protected void onResume() {
        super.onResume();
        MyApplication.currentWindow=macAddress_other;
        EventBus.getDefault().register(this);

        user=RealmManager.getAllStoredContacts().equalTo("macAddress",macAddress_other).findFirst();

        if (user!=null) {
            list.clear();
            Utils.log("Chat Activity on resume user found"+total_msg_count);
            loadMore();
        }

        try{
            int notify_id=MyApplication.notify_id.get(macAddress_other);
            NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.cancel(notify_id);
            MyApplication.notify_count.put(macAddress_other,0);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        if (MyApplication.getBLUETOOTHSERVICE()!=null && MyApplication.getBLUETOOTHSERVICE().macAddress.equals(macAddress_other))
        {
            connection=MyApplication.getBLUETOOTHSERVICE();
            TransitionManager.beginDelayedTransition(toolbar);
            status.setVisibility(View.VISIBLE);
            title.setCompoundDrawablesWithIntrinsicBounds(0,0,android.R.drawable.presence_online,0);
            status.setText(Constants.ERROR_MSG[Constants.STATUS_CONNECTED]);
            isConnected=true;
            if (!name_other.equals(device_other.getName()))
            {
                name_other=device_other.getName();
                title.setText(name_other);
            }
        }
    }

