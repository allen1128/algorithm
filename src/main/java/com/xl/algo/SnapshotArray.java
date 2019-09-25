package com.xl.algo;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SnapshotArray {


    List<TreeMap<Integer, Integer>> treeMap = new ArrayList<>();

    int currVer = 0;

    public SnapshotArray(int length) {
        for (int i = 0; i < length; i++) {
            treeMap.add(new TreeMap<>());
            treeMap.get(i).put(0, 0);
        }
    }

    public void set(int index, int val) {
        treeMap.get(index).put(currVer, val);
    }

    public int snap() {
        return currVer++;
    }

    public int get(int index, int snap_id) {
        return treeMap.get(index).floorEntry(snap_id).getKey();
    }

//    public class SnapShot {
//        List<Integer> val = new ArrayList<>();
//        List<Integer> ver = new ArrayList<>();
//    }
//
//    private SnapShot[] dataholder = null;
//    private int snapId = 0;
//
//    public SnapshotArray(int length) {
//        dataholder = new SnapShot[length];
//    }
//
//    public void set(int index, int val) {
//        if (dataholder[index] == null) {
//            dataholder[index] = new SnapShot();
//        }
//        if (dataholder[index].ver.size() > 0) {
//            int v = dataholder[index].ver.get(dataholder[index].ver.size()-1);
//            if (v == snapId) {
//                int o = dataholder[index].ver.size() - 1;
//                dataholder[index].val.set(o, val);
//                return;
//            }
//        }
//        dataholder[index].val.add(val);
//        dataholder[index].ver.add(snapId);
//    }
//
//    public int snap() {
//        return snapId++;
//    }
//
//    public int get(int index, int snap_id) {
//        int left = 0;
//        if (dataholder[index] == null) {
//            return 0;
//        }
//        int right = dataholder[index].ver.size() - 1;
//
//        while (left + 1 < right) {
//            int mid = left + (right - left) / 2;
//            if (dataholder[index].ver.get(mid) == snap_id) {
//                return dataholder[index].val.get(mid);
//            } else if (dataholder[index].ver.get(mid) > snap_id) {
//                right = mid;
//            } else {
//                left = mid;
//            }
//        }
//
//        if (dataholder[index].ver.get(right) <= snap_id) {
//            return dataholder[index].val.get(right);
//        } else if (dataholder[index].ver.get(left) <= snap_id) {
//            return dataholder[index].val.get(left);
//        } else {
//            return 0;
//        }
//    }

    public static void main(String[] args) {

        SnapshotArray ssa = new SnapshotArray(1);
        ssa.set(0, 4);
        ssa.set(0, 2);
        ssa.set(0,  17);
        ssa.snap();
        ssa.set(0, 2);
        ssa.snap();
        ssa.get(0,  0);
        ssa.set(0,  19);
        ssa.set(0,  3);
        ssa.set(0,  15);
        ssa.set(0,  20);
        ssa.get(0,  0);
        ssa.set(0,  1);
        System.out.println(ssa.get(0, 1));
    }
}
