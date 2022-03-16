    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final int id = item.getItemId();

        switch (id) {
            case R.id.paste:
                try {
                    String src = clipboard.get(0);
                    startIOService(src, currentDir.getCanonicalPath() + File.separator + new File(src).getName(), clipboard.operation);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clipboard.clear();
                invalidateOptionsMenu();
                refresh();
                break;
            case R.id.newfile:
                createFile(FileType.REG);
                refresh();
                break;
            case R.id.newfolder:
                createFile(FileType.DIR);
                refresh();
                break;
            case R.id.refresh:
                refresh();
                break;
            case R.id.showhidden:
                settings.showHidden ^= true;
                refresh();
        }

        return true;
    }

