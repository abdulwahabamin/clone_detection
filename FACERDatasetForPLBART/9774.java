    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case AlertDialog.BUTTON_POSITIVE:
                performUserFlow();
                break;
            default:
                break;
        }
    }

