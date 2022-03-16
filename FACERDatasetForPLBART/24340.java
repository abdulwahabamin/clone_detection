    @Override
    protected void extraNotifyChange(String what) {
        // Share this notification directly with our widgets
        MediaAppWidgetProvider.getInstance().notifyChange(this, what);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) { // does not work in Lollipop
            updateRemoteControl();
        }
    }

