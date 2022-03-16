    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        getMenuInflater().inflate(R.menu.menu_cast, menu);

        if (playServicesAvailable) {
            CastButtonFactory.setUpMediaRouteButton(getApplicationContext(),
                    menu,
                    R.id.media_route_menu_item);
        }

        if (!TimberUtils.hasEffectsPanel(BaseActivity.this)) {
            menu.removeItem(R.id.action_equalizer);
        }
        ATE.applyMenu(this, getATEKey(), menu);
        return true;
    }

