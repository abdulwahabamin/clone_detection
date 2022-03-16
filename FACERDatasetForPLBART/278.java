    /**
     * å¼¹å‡ºä¸?æ”¯æŒ?ä½ŽåŠŸè€—è“?ç‰™å¯¹è¯?æ¡†
     */
    private void showNotSupportBluetoothDialog() {
        AlertDialog dialog = new AlertDialog.Builder(this).setTitle("å½“å‰?è®¾å¤‡ä¸?æ”¯æŒ?BLE").create();
        dialog.show();
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                finish();
            }
        });

    }

