    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case R.id.action_create_directory:
                dialogCreate.show();
                break;
            case R.id.action_copy:
                copiedFile = adapter.getItem(curItem).file;
                break;
            case R.id.action_paste:
                try {
                    Paste(copiedFile, path);
                    LoadFiles(path);
                    adapter.notifyDataSetChanged();
                }catch (Exception ex){
                    Toast.makeText(this, ex.getMessage(),Toast.LENGTH_SHORT);
                }
                break;
            case R.id.action_delete:
                dialogYesNo.show();
                break;
            case R.id.action_rename:
                dialogRename.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

