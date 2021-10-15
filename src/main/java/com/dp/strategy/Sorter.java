package com.dp.strategy;

public class Sorter<T> {
    public void sort(T[] arr,Comparator<T> comparator){
        for (int i = 0; i < arr.length - 1; i++) {
            if (comparator.compare(arr[i],arr[i+1]) == 1){
                swap(arr,i,i+1);
            }
        }
    }
    void swap(T[] arr,int i,int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
