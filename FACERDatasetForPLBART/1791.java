    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void onStatusEvent(ChatStatusEvent statusEvent)
    {
        if (!statusEvent.macAddress.equals(macAddress_other)){
            return;
        }

        if (status.getText().length()==0) {
            TransitionManager.beginDelayedTransition(toolbar);
            status.setVisibility(View.VISIBLE);
        }

        status.setText(Constants.ERROR_MSG[statusEvent.status]);


        Log.d(TAG, "onStatusEvent: "+Constants.ERROR_MSG[statusEvent.status]);

        switch (statusEvent.status)
        {
            case Constants.STATUS_CONNECTING_FAILED:
                startThread(MODE_ACCEPT);

                break;
            case Constants.STATUS_CONNECTED:
                //useless as when connected in chat screen, the connection will be done in onSocketReceived and is handled else it will be on at onResume.
               onChatConnected();

                break;
            case Constants.STATUS_DISCONNECTED:
                onChatDisconnected();
                break;

            case Constants.STATUS_LISTENING_FAILED:
                onChatDisconnected();
        }
    }

