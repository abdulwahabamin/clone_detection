    private void renameFileDialog(String name, final int position) {
        AlertDialog.Builder renameFileDialog = new AlertDialog.Builder(this);
        renameFileDialog.setTitle("Rename");
        final EditText input = new EditText(this);
        input.setText(name);
        renameFileDialog.setView(input);
        renameFileDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                File old_file = new File(current_path, files[position]);
                File new_file = new File(current_path, input.getText().toString());
                old_file.renameTo(new_file);
                updateList();
            }
        });
        renameFileDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        renameFileDialog.show();
    }

