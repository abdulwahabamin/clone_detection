    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("文件�?作");
        menu.add(0,1,Menu.NONE,"�?制");
        menu.add(0,2,Menu.NONE,"删除");
        menu.add(0,3,Menu.NONE,"移动");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

