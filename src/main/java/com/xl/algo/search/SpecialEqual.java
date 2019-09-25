package com.xl.algo.search;

public class SpecialEqual {
    public int firstEqual(int[] data, int target) {
        int start = 0;
        int end = data.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) /2;
            if (data[mid] > target) {
                end = mid;
            } else if (data[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (data[start] == target) {
            return start;
        } else if (data[end] == target) {
            return end;
        } else {
            return -1;
        }
    }

    public int lastEqual(int[] data, int target) {
        int start = 0;
        int end = data.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) /2;
            if (data[mid] > target) {
                end = mid;
            } else if (data[mid] < target) {
                start = mid;
            } else {
                start = mid;
            }
        }

        if (data[end] == target) {
            return end;
        } else if (data[start] == target) {
            return start;
        } else {
            return -1;
        }
    }

    public int firstLarger(int[] data, int target) {
        int start = 0;
        int end = data.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) /2;
            if (data[mid] > target) {
                end = mid;
            } else if (data[mid] < target) {
                start = mid;
            } else {
                start = mid;
            }
        }

        if (data[start] > target) {
            return start;
        } else if (data[end] > target) {
            return end;
        } else {
            return -1;
        }
    }

    public int fistSmaller(int[] data, int target) {
        int start = 0;
        int end = data.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) /2;
            if (data[mid] > target) {
                end = mid;
            } else if (data[mid] < target) {
                start = mid;
            } else {
                start = mid;
            }
        }

        if (data[end] < target) {
            return end;
        } else if (data[start] < target) {
            return start;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        SpecialEqual fe = new SpecialEqual();
        System.out.println(fe.fistSmaller(new int[] {1, 1, 3, 5, 7, 9, 9, 11}, 11));
    }
}
