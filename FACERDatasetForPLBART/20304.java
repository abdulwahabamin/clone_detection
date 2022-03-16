  private void scheduleJob(DispatchJob job) {
    boolean added = jobQueue.offer(job);

    if (added) {
      hunterMap.put(job.getBitmapHunter(), job);
    }
  }

