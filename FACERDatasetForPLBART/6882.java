    private void editFileDialog(final String content, final File original_file)
    {
        AlertDialog.Builder editFileDialog = new AlertDialog.Builder(this);
        editFileDialog.setTitle("Edit");
        final EditText input = new EditText(this);
        input.setText(content);
        editFileDialog.setView(input);
        editFileDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try
                {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(original_file));
                    bufferedWriter.write(input.getText().toString());
                    bufferedWriter.close();
                }catch (Exception ex)
                {
                    Snackbar.make(findViewById(android.R.id.content), ex.getMessage(), Snackbar.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        editFileDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        editFileDialog.show();
    }

