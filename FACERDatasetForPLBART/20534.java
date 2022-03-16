  /** Prints out this {@link StatsSnapshot} into log. */
  @SuppressWarnings("UnusedDeclaration") public void dump() {
    StringWriter logWriter = new StringWriter();
    dump(new PrintWriter(logWriter));
    Log.i(TAG, logWriter.toString());
  }

