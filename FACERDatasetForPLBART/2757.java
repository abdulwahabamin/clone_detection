    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        lView.setTag(position); // allows position of file in list to be known in onContextItemSelected
        registerForContextMenu(lView);
        openContextMenu(lView);
        return true;
    }

