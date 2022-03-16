    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //menu item secleted
        switch (item.getItemId()){
            case R.id.action_shuffle:
                //shuffle
                break;
            case R.id.action_end:
                stopService(playIntent);
                musicSrv = null;
                System.exit(0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

