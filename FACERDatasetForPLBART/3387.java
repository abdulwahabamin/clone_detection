    public static void hide() {
        if(fab!=null) {
            addTrimLastKnownState(Boolean.FALSE);
            fab.hide(true);
        }
    }

