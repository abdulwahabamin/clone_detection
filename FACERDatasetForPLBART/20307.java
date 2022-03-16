  public void dispatchNextFromQueue() {

    while (!jobQueue.isEmpty()) {
      DispatchJob job = jobQueue.poll();

      if (job != null) {
        hunterMap.remove(job.getBitmapHunter());
        job.dispatch();
      }
    }
  }

