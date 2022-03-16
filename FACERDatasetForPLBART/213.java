    public void exitChatDialog(String text, boolean cancelable) {
        if (exit) {
            return;
        }

        exit = true;


        AlertDialog dialog = new AlertDialog.Builder(this)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        if (isClient) {
                            clientService.cancel();
                        }
                    }
                })
                .setMessage(text).create();


        dialog.setCancelable(cancelable);


        dialog.show();

        if (isClient) {
            clientService.cancel();
        }


    }

