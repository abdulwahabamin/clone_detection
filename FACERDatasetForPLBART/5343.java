    public void setDeleteButtonListener(){

        delete.setOnClickListener(view -> {
            new AlertDialog.Builder(this)
                    .setCancelable(false).setTitle("Delete")
                    .setMessage("Do you want to delete...?")
                    .setPositiveButton("Yup", (dialogInterface, i) -> {

                        for (FileDirectory fileDirectory : selectionList) {
                            fileEx.delete(fileDirectory.getPath());
                            fileList.remove(fileDirectory);
                        }

                        Toast.makeText(getApplicationContext(), "Files deleted.", Toast.LENGTH_SHORT).show();

                        mediaAdapter.disableSelection();
                        mediaAdapter.notifyDataSetChanged();

                    }).setNegativeButton("No", ((dialogInterface, i) -> {
            })).show();

        });
    }

