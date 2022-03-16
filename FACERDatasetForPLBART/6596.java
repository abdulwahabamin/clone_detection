    /**
     * Borrowed from TimSort.binarySort(), but modified to sort two column
     * dataset.
     */
    private static void binarySort(int[] position, String[] value) {
        final int count = position.length;
        for (int start = 1; start < count; start++) {
            final int pivotPosition = position[start];
            final String pivotValue = value[start];

            int left = 0;
            int right = start;

            while (left < right) {
                int mid = (left + right) >>> 1;

                final String lhs = pivotValue;
                final String rhs = value[mid];
                final int compare;
                if (lhs == null) {
                    compare = -1;
                } else if (rhs == null) {
                    compare = 1;
                } else {
                    compare = lhs.compareToIgnoreCase(rhs);
                }

                if (compare < 0) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            int n = start - left;
            switch (n) {
                case 2:
                    position[left + 2] = position[left + 1];
                    value[left + 2] = value[left + 1];
                case 1:
                    position[left + 1] = position[left];
                    value[left + 1] = value[left];
                    break;
                default:
                    System.arraycopy(position, left, position, left + 1, n);
                    System.arraycopy(value, left, value, left + 1, n);
            }

            position[left] = pivotPosition;
            value[left] = pivotValue;
        }
    }

