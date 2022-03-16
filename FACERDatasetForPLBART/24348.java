    /**
     * Workaround to avoid stacked Action Bar.
     * <p>
     * http://developer.android.com/guide/topics/ui/actionbar.html#Tabs
     */
    private void disableStackedActionBar(ActionBar actionBar) {
        try {
            Method setHasEmbeddedTabsMethod = actionBar.getClass()
                    .getDeclaredMethod("setHasEmbeddedTabs", boolean.class);
            setHasEmbeddedTabsMethod.setAccessible(true);
            setHasEmbeddedTabsMethod.invoke(actionBar, true);
        } catch (Exception e) {
            Log.w(LOGTAG, "Unable to configure ActionBar tabs", e);
        }
    }

