    @Override
    public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
        File f = (File) fileAdapter.getItem(position);
        if (f.exists()) {
            openFile(f);
        } else {
            Toast.makeText(this, "Error: this file/folder no longer exists!", Toast.LENGTH_SHORT).show();
            refresh();
        }
    }

