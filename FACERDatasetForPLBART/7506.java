    private void setSystemNotification( Message msg ) {
        if( notMan == null || msg == null ) return;
        String str;
        try {
            str = (String)msg.obj;
        } catch( Exception e ) {
            str = "Unknown Event";
        }
        Notification notification = new Notification( R.drawable.icon, str, System.currentTimeMillis() );
        
        Bundle b = new Bundle( 1 );
        b.putString( MSG, str );
        msg.obj = b; // pack not parcelable string message to parcelable bundle  
        notification.setLatestEventInfo( this, getString( R.string.app_name ), str, getPendingIntent( msg ) );
        notification.flags |= Notification.FLAG_ONLY_ALERT_ONCE | Notification.FLAG_AUTO_CANCEL;
        notMan.notify( NOTIF_DONE, notification );
    }

