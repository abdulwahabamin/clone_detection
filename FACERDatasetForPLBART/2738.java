    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case android.content.DialogInterface.BUTTON_POSITIVE:
                newName = nameInput.getText().toString();
                File newFile = new File(f.getParent() + File.separator + newName);

                if (FileHelpers.isValidFilename(newName)) {
                    if (!newFile.exists()) {
                        if (!f.renameTo(newFile)) {
                            Toast.makeText(getContext(), "Failed to rename file!", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(getContext(), "Invalid filename!", Toast.LENGTH_SHORT).show();
                }
        }
        dismiss();
    }

