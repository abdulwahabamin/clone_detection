        @Override
        public void onCreateContextMenu(ContextMenu menu, View v,
                                        ContextMenu.ContextMenuInfo menuInfo) {
            int position = getAdapterPosition();
            menu.setHeaderTitle(getFile(position).getName());

            //menu.add(Menu.NONE, R.id.get_info, Menu.NONE, R.string.view_file_info);
            menu.add(Menu.NONE, R.id.rename, Menu.NONE, R.string.rename_menu_item);
            menu.add(Menu.NONE, R.id.delete, Menu.NONE, R.string.delete_menu_item);

        }

