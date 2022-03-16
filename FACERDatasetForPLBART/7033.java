    private final void createDesktopShortcut( ComponentName cn, String name, Bitmap ico ) {
        Intent shortcutIntent = new Intent();
        shortcutIntent.setComponent( cn );
        shortcutIntent.setData( uri );
        Intent intent = new Intent();
        intent.putExtra( Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent );
        intent.putExtra( Intent.EXTRA_SHORTCUT_NAME, name );
        if( ico != null )
            intent.putExtra( Intent.EXTRA_SHORTCUT_ICON, ico );
        intent.setAction( "com.android.launcher.action.INSTALL_SHORTCUT" );
        ctx.sendBroadcast( intent );
    }

