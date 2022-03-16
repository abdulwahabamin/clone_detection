  public void dequeue(BitmapHunter hunter) {

    DispatchJob job = hunterMap.get(hunter);
    if (job != null) {
      // Remove the waiting jo from queue
      jobQueue.remove(job);
      hunterMap.remove(hunter);
    }
  }

