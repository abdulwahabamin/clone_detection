    private void setSystemOngoingNotification( String str, int p ) {
        if( notMan == null || str == null ) return;
        long cur_time = System.currentTimeMillis();
        if( notLastTime + 1000 > cur_time ) return;
        notLastTime = cur_time;
        Notification notification = new Notification( R.drawable.icon, getString( R.string.inprogress ), cur_time );
        notification.contentIntent = getPendingIntent( null );
        notification.flags |= Notification.FLAG_ONGOING_EVENT;
        RemoteViews not_view = new RemoteViews( getPackageName(), R.layout.progress );
        not_view.setTextColor( R.id.text, 0xFF000000 );
        not_view.setTextViewText( R.id.text, str.replace( "\n", " " ) );
        not_view.setProgressBar( R.id.progress_bar, 100, p, false );
        not_view.setTextColor( R.id.percent, 0xFF000000 );
        not_view.setTextViewText( R.id.percent, "" );
        notification.contentView = not_view;
        notMan.notify( NOTIF_PROGRESS, notification );
    }

