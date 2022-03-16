    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case PICK_DIRECTORY:
                if (data != null) {
                    Uri folder = data.getData();
                    if (folder != null) {
                        setMusicFolder(folder.getPath());
                    }
                }
                finish();
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }

