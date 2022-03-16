    private void showNotSupportBluetoothDialog() {
        AlertDialog dialog = new AlertDialog.Builder(this).setTitle("å½“å‰?è®¾å¤‡ä¸?æ”¯æŒ?è“?ç‰™").create();
        dialog.show();
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                finish();
            }
        });

    }

