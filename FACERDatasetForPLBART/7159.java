    private final void createDesktopShortcut( Favorite f ) {
        if( f == null ) return;
        Uri uri = f.getUri();
        Intent shortcutIntent = new Intent();
        shortcutIntent.setClassName( ctx, commander.getClass().getName() );
        shortcutIntent.setAction( Intent.ACTION_VIEW );
        shortcutIntent.setData( uri );
        Credentials crd = f.getCredentials();
        if( crd != null )
            shortcutIntent.putExtra( Credentials.KEY, crd );

        Intent intent = new Intent();
        intent.putExtra( Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent );
        String name = f.getComment();
        if( name == null || name.length() == 0 )
            name = f.getUriString( true );
        intent.putExtra( Intent.EXTRA_SHORTCUT_NAME, name );
        Parcelable iconResource = Intent.ShortcutIconResource.fromContext( ctx, getDrawableIconId( uri ) );
        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconResource);
        intent.setAction( "com.android.launcher.action.INSTALL_SHORTCUT" );
        ctx.sendBroadcast( intent );
    }

