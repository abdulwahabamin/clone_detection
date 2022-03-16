    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_player, menu);
        this.menu = menu;
        updateMenu(PlayBackUtil.getCurrentPlayMode());
        return true;
    }

