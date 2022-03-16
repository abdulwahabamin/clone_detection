    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getSongs();
                    Toast.makeText(context,"Permission granted",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context,"Permission denied",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

