  public String getType() {
    String type = getName();
    int a = 0;
    for (int i = type.length() - 1; i >= 0; i--) {
      if (type.charAt(i) == '.') {
        a = i;
        break;
      }
    }
    return type.substring(a);
  }

