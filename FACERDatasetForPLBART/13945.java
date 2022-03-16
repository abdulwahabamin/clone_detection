    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem search = menu.findItem(R.id.action_search);
        MenuItem overflow = menu.findItem(R.id.action_overflow);
        // Theme chooser
        ThemeUtils.setActionBarItem(this, search, "apollo_search");
        ThemeUtils.setActionBarItem(this, overflow, "apollo_overflow");
        
        return super.onPrepareOptionsMenu(menu);
    }

