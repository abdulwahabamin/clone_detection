    private void updateList() {
        directory = new File(current_path);
        files = directory.list();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, files);
        list.setAdapter(adapter);
    }

