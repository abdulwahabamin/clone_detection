    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        //这个view就是当�?的View
        View view = info.targetView;
        ContextMenu.ContextMenuInfo menuInfo=item.getMenuInfo();
        int position= ((AdapterView.AdapterContextMenuInfo)menuInfo).position;
        File files=new File(getPathString());
        File file=files.listFiles()[position];
        switch (item.getItemId()){
            case 1:
                doCopy(file);
                break;
            case 2:
                file.delete();
                showChanged(getPathString());
                break;
            case 3:
                doCopy(file);
                file.delete();
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }

