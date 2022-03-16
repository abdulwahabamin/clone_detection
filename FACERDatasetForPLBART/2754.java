    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.menu_main, m);
        pasteOption = m.findItem(R.id.paste);
        showHiddenOption = m.findItem(R.id.showhidden);
        return true;
    }

