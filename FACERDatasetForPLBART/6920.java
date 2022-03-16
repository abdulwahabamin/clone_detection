        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.more_rename:
                    doRename();
                    break;
                case R.id.more_copy:
                    doCopy();
                    break;
                case R.id.more_remove:
                    doRemove();;
                    break;
                default:
                    break;
            }
            return true;
        }

