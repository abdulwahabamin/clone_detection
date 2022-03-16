  private void logBatch(List<BitmapHunter> copy) {
    if (copy == null || copy.isEmpty()) return;
    BitmapHunter hunter = copy.get(0);
    Picasso picasso = hunter.getPicasso();
    if (picasso.loggingEnabled) {
      StringBuilder builder = new StringBuilder();
      for (BitmapHunter bitmapHunter : copy) {
        if (builder.length() > 0) builder.append(", ");
        builder.append(Utils.getLogIdsForHunter(bitmapHunter));
      }
      log(OWNER_DISPATCHER, VERB_DELIVERED, builder.toString());
    }
  }

