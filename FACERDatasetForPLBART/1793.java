    public void onChatConnected()
    {
        isConnected=true;
        if (status.getText().length()==0) {
            TransitionManager.beginDelayedTransition(toolbar);
            status.setVisibility(View.VISIBLE);
        }

        if (btn_connect!=null) {
            btn_connect.setTitle(R.string.menu_disconnect);
            btn_connect.setEnabled(true);
        }
        Utils.showToast(this,name_other+" "+Constants.ERROR_MSG[Constants.STATUS_CONNECTED]);
        status.setText(Constants.ERROR_MSG[Constants.STATUS_CONNECTED]);

        title.setCompoundDrawablesWithIntrinsicBounds(0,0,android.R.drawable.presence_online,0);
    }

