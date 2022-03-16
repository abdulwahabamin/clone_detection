    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
            int[] grandResults) {
        boolean allowed = true;
        switch (requestCode) {
            case REQUEST_CODE_STORAGE_PERMS:
                for (int res : grandResults) {
                    allowed = allowed && (res == PackageManager.PERMISSION_GRANTED);
                }
                break;
            default:
                allowed = false;
                break;
        }
        if (allowed) {
            finishOnCreate();
            if (mDrawerToggle != null) {
                mDrawerToggle.syncState();
            }
        } else {
            if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                String text = getResources().getString(R.string.storage_permissions_denied);
                final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                        .findViewById(android.R.id.content)).getChildAt(0);
                if (viewGroup != null) {
                    Snackbar snackbar = Snackbar.make(viewGroup, text,
                            Snackbar.LENGTH_INDEFINITE, 3);
                    snackbar.setAction(android.R.string.ok, new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            requestNecessaryPermissions();
                        }
                    });
                    snackbar.show();
                }
            } else {
                StringBuilder builder = new StringBuilder(getString(R.string
                        .storage_permissions_denied));
                builder.append("\n\n");
                builder.append(getString(R.string.storage_permissions_explanation));
                final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                        .findViewById(android.R.id.content)).getChildAt(0);
                if (viewGroup != null) {
                    Snackbar snackbar = Snackbar.make(viewGroup, builder.toString(),
                            Snackbar.LENGTH_INDEFINITE, 7);
                    snackbar.setAction(R.string.snackbar_settings, new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startInstalledAppDetailsActivity(NavigationActivity.this);
                            finish();
                        }
                    });
                    snackbar.show();
                }
            }

        }

    }

