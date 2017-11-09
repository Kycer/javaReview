package com.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class MergeTrays {

    static class Tray {
        int id;
        List<Goods> goods;
    }

    static class Goods {
        int id;
        int count;
    }

    private static final int MAX_TRAYS = 10;
    private static final int MAX_TRAY_ID = 6;
    private static final int MAX_GOODS = 3;
    private static final int MAX_GOODS_ID = 10;
    private static final int MAX_GOODS_COUNT = 3;

    public static void main(String[] args) {
        List<Tray> trays = genTrays();
        printTrays("原始数据", trays);
        List<Tray> result = mergeTrays(trays);
        printTrays("处理结果", result);
    }

    private static List<Tray> genTrays() {
        List<Tray> trays = new ArrayList<>();
        for (int i = 0; i < MAX_TRAYS; ++i) {
            Tray tray = genTray();
            trays.add(tray);
        }
        return trays;
    }

    private static Random rnd = new Random();

    private static Tray genTray() {
        Tray tray = new Tray();
        tray.id = rnd.nextInt(MAX_TRAY_ID);
        tray.goods = genGoods();
        return tray;
    }

    private static List<Goods> genGoods() {
        List<Goods> result = new ArrayList<>();
        int goodsSize = rnd.nextInt(MAX_GOODS) + 1;
        for (int i = 0; i < goodsSize; ++i) {
            Goods g = new Goods();
            g.id = rnd.nextInt(MAX_GOODS_ID);
            g.count = rnd.nextInt(MAX_GOODS_COUNT) + 1;
            result.add(g);
        }
        return result;
    }

    private static void printTrays(String title, List<Tray> list) {
        System.out.println(title);
        for (Tray t : list) {
            if (t == null)
                continue;
            System.out.print("\tTray_" + t.id + ": ");
            if (t.goods != null) {
                for (Goods g : t.goods) {
                    if (g == null)
                        continue;
                    System.out.print("(Goods_" + g.id + ", " + g.count + "), ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static List<Tray> mergeTrays(List<Tray> list) {
        //TODO 请补充代码
        return list;
    }
}
