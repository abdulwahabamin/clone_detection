    /**
     * Request permissions.
     *
     * @param permissions  -String Array of permissions to request, for eg: new String[]{PermissionManager.CAMERA} or multiple new String[]{PermissionManger.CAMERE,PermissionManager.CONTACTS}
     * @param request_code - Request code to check on callback.
     */
    public void requestPermission(@NonNull String[] permissions, int request_code) {
        deniedpermissions.clear();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && isViewAttached()) {
            boolean allPermissionGranted = true;

            for (String permission : permissions) {
                if (getActivity().checkSelfPermission(permission) == PackageManager.PERMISSION_DENIED) {
                    allPermissionGranted = false;
                    deniedpermissions.add(permission);
                    Log.d(TAG, "denied " + permission);
                }
            }

            if (!allPermissionGranted) {
                switch (TYPE) {
                    case ACTIVITY:
                        getActivityView().requestPermissions(deniedpermissions.toArray(new String[deniedpermissions.size()]), request_code);
                        break;
                    case FRAGMENT:
                        getFrag_view().requestPermissions(deniedpermissions.toArray(new String[deniedpermissions.size()]), request_code);
                        break;
                    case FRAGMENTv4:
                        getFrag_v4_view().requestPermissions(deniedpermissions.toArray(new String[deniedpermissions.size()]), request_code);
                }
            } else {
                getListener().onPermissionGranted(request_code);
            }
        } else {
            getListener().onPermissionGranted(request_code);
        }
    }

