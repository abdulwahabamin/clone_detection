    public static void showPermissionDialog(final Context context){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context, R.style.RhythmAlertDialog);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View dialogView = inflater.inflate(R.layout.dialog_storage_permission, null);
        dialogBuilder.setView(dialogView);

        AlertDialog b = dialogBuilder.create();
        b.show();
    }

