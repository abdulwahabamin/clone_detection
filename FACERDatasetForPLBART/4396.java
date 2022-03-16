    public static void setActionBarBackV19(AppCompatActivity activity,ActionModeBack amb) {
        ActionBar ab = activity.getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setDisplayHomeAsUpEnabled(false);
        ab.show();
    }

