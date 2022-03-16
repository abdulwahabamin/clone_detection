    private void openFile(File f) {
        if (f.isDirectory()) {
            if (f.getName().equals("..")) {
                changeDir(parent);
                refresh();
            } else {
                changeDir(f.getAbsolutePath());
                refresh();
            }
        } else {
            String mimeType = FileHelpers.getMimeType(f.getAbsolutePath());

            if (mimeType != null) {
                fileViewIntent.setDataAndType(Uri.fromFile(f), mimeType);

                try {
                    startActivity(fileViewIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(this, "No applications were found for this type of file.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Can't open a file of unknown type", Toast.LENGTH_SHORT).show();
            }
        }
    }

