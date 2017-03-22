package com.study.a;

import java.lang.reflect.Array;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class ArrayDemo {
    public static void main(String[] args) {
//        newArray();
        int [] arr = {49, 38, 65, 97, 76, 13, 27};
        pringArray("第0次排序：", arr);
//        maoPaoSort(arr);
//        quickSort(arr, 0, arr.length-1);
        _quickSort(arr, 0, arr.length-1);
    }


    public static void _quickSort(int [] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二
            _quickSort(list, low, middle - 1);        //对低字表进行递归排序
            _quickSort(list, middle + 1, high);       //对高字表进行递归排序
        }
    }

    public static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] > tmp) {
                high--;
            }
            list[low] = list[high];   //比中轴小的记录移到低端
            while (low < high && list[low] < tmp) {
                low++;
            }
            list[high] = list[low];   //比中轴大的记录移到高端
        }
        list[low] = tmp;              //中轴记录到尾
        pringArray("", list);
        return low;                   //返回中轴的位置
    }

    /**
     *  快速排序
     */
    public static void quickSort(int[] a, int low, int high){
        int start = low;
        int end = high;
        int key = a[low];
        while(end>start){
            //从后往前比较
            //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
            while(end>start&&a[end]>=key)
                end--;
            if(a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            //如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
            while(end>start&&a[start]<=key)
                start++;
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            pringArray("", a);
        }
        //递归
        if(start>low)
            quickSort(a, low, start-1);//左边序列。第一个索引位置到关键值索引-1
        if(end<high)
            quickSort(a,end+1, high);//右边序列。从关键值索引+1到最后一个
    }

    /**
     *  冒泡排序
     */
    public static void maoPaoSort(int [] arr){
        for(int i = 1; i < arr.length; i++){
            for(int j= 0; j < arr.length-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            pringArray("第"+(i+1)+"次排序：", arr);
        }
    }


    public static void pringArray(String msg, int [] arr){
        System.out.print(msg);
        for (Integer a : arr){
            System.out.print(a + "  ");
        }
        System.out.println();
    }


    public static void newArray(){
        int[]  arr= new int [3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        System.out.println(arr.length);
        System.out.println(Array.getInt(arr, 1));
        Array.set(arr, 1, 6);
        System.out.println(Array.getInt(arr, 1));

        String [] sArr = {"a", "b", "c","d"};
        for (String s : sArr) {
            System.out.print(s + " ");
        }
    }


}
