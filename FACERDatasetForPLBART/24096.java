    public static void reportError(Context context, String text, Throwable t) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        if (t != null) {
            CharArrayWriter buffer = new CharArrayWriter();
            PrintWriter pw = new PrintWriter(buffer);
            pw.append(text);
            pw.append('\n');
            t.printStackTrace(pw);
            pw.flush();
            intent.putExtra(Intent.EXTRA_TEXT, buffer.toString());
        } else {
            intent.putExtra(Intent.EXTRA_TEXT, text);
        }
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"djdplayer@staldal.nu"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Error report from DJD Player");

        Intent chooser = Intent.createChooser(intent, context.getString(R.string.report_error));
        chooser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(chooser);
    }

