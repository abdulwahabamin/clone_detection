    public void onChatDisconnected()
    {
        isConnected=false;
        connection=null;
        if (btn_connect!=null) {
            btn_connect.setTitle(R.string.menu_connect);
            btn_connect.setEnabled(true);
        }//Utils.showToast(this,name_other+" "+Constants.ERROR_MSG[Constants.STATUS_DISCONNECTED]);
        title.setCompoundDrawablesWithIntrinsicBounds(0,0,android.R.drawable.presence_invisible,0);
    }

