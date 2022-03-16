    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_camera:
                pickImage(ImageUtils.PickType.CAMERA);
                break;
            case R.id.fab_album:
                pickImage(ImageUtils.PickType.ALBUM);
                break;
        }
    }

