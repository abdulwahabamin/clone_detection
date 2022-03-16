  private void shareMultiple(ArrayList<Uri> files, Context context) {
    final Intent intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
    intent.setType("*/*");
    intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, files);
    context.startActivity(Intent.createChooser(intent, "Share via"));
  }

