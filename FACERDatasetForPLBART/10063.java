        private void adjustLines(Rect pageRect, int charsPerRow) {
            if (mReader.getDocumentMode() == 2) {
                return;
            }
            mAdjustedLines = new ArrayList<String>(mLines);
            for (int i = 0; i < mAdjustedLines.size(); i++) {
                String line = mAdjustedLines.get(i);
                if (line.length() > charsPerRow) {
                    int prevSpace = line.lastIndexOf(" ", charsPerRow);
                    if (prevSpace != -1) {
                        // Split in the previous word
                        String currentLine = line.substring(0, prevSpace + 1);
                        String nextLine = line.substring(prevSpace + 1);
                        mAdjustedLines.set(i, currentLine);
                        mAdjustedLines.add(i + 1, nextLine);
                    } else {
                        // Just split at margin
                        String currentLine = line.substring(0, charsPerRow);
                        String nextLine = line.substring(charsPerRow);
                        mAdjustedLines.set(i, currentLine);
                        mAdjustedLines.add(i + 1, nextLine);
                    }
                }
            }
        }

