  public String getIntentType() {
    if (getType().equalsIgnoreCase(".htm") || getType().equalsIgnoreCase(".html") ||
        getType().equalsIgnoreCase(".htmls") || getType().equalsIgnoreCase(".htt") ||
        getType().equalsIgnoreCase(".htx") || getType().equalsIgnoreCase(".java") ||
        getType().equalsIgnoreCase(".js") || getType().equalsIgnoreCase(".pl") ||
        getType().equalsIgnoreCase(".txt") || getType().equalsIgnoreCase(".xml")) {
      return "text/*";
    }
    if (getType().equalsIgnoreCase(".doc") || getType().equalsIgnoreCase(".docx") ||
        getType().equalsIgnoreCase(".word")) {
      return "application/msword";
    }
    if (getType().equalsIgnoreCase(".pdf")) {
      return "application/pdf";
    }
    if (getType().equalsIgnoreCase(".mid") || getType().equalsIgnoreCase(".mp2") ||
        getType().equalsIgnoreCase(".mp3") || getType().equalsIgnoreCase(".wav")) {
      return "audio/*";
    }
    if (getType().equalsIgnoreCase(".bmp") || getType().equalsIgnoreCase(".g3") ||
        getType().equalsIgnoreCase(".gif") || getType().equalsIgnoreCase(".ico") ||
        getType().equalsIgnoreCase(".jpe") || getType().equalsIgnoreCase(".jpeg") ||
        getType().equalsIgnoreCase(".jpg") || getType().equalsIgnoreCase(".pic") ||
        getType().equalsIgnoreCase(".png") || getType().equalsIgnoreCase(".tif")) {
      return "image/*";
    }
    if (getType().equalsIgnoreCase(".avi") || getType().equalsIgnoreCase(".mjpg") ||
        getType().equalsIgnoreCase(".mpeg") || getType().equalsIgnoreCase(".mpg") ||
        getType().equalsIgnoreCase(".mp4")) {
      return "video/*";
    }
    if (getType().equalsIgnoreCase(".zip")) {
      return "application/zip";
    }
    return "view/*";
  }

