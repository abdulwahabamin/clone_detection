    public static void showHideNavClose() {
        if(fab!=null) {
            if (!lastKnownState.isEmpty() && lastKnownState.get(0) == Boolean.TRUE)
                show();
            else
                hide();
        }
    }

