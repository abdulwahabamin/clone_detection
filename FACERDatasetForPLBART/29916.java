    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.location:
                permission = new Permissions(context());
                requestPermissions(new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION}, Constants.READ_COARSE_LOCATION);
                break;
        }
        return true;
    }

