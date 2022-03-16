    private void calculateUsageByType(File root, Map<MimeTypeCategory, Long> groupUsageMap) {
        File[] dirs = root.listFiles(new DirectoryOnlyFileFilter());
        File[] files = root.listFiles(new FileOnlyFileFilter());
        if (dirs != null) {
            // Recurse directories
            for (File dir : dirs) {
                long size = dir.length();
                if (!groupUsageMap.containsKey(MimeTypeCategory.NONE)) {
                    groupUsageMap.put(MimeTypeCategory.NONE, size);
                } else {
                    long newSum = groupUsageMap.get(MimeTypeCategory.NONE) + size;
                    groupUsageMap.put(MimeTypeCategory.NONE, newSum);
                }
                calculateUsageByType(dir, groupUsageMap);
            }
        }
        if (files != null) {
            // Iterate every file
            for (File file : files) {
                MimeTypeCategory category = MimeTypeHelper.getCategory(this, file);
                long size = file.length();
                if (!groupUsageMap.containsKey(category)) {
                    groupUsageMap.put(category, size);
                } else {
                    long newSum = groupUsageMap.get(category) + size;
                    groupUsageMap.put(category, newSum);
                }
            }
        }
    }

