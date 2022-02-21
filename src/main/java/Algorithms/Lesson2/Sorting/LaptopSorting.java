package Algorithms.Lesson2.Sorting;

import Algorithms.Lesson2.Laptop.Laptop;

import java.util.ArrayList;
import java.util.List;

public class LaptopSorting {
    private static void sortByName(Laptop[] laptops) {
        int max = 0;

        for (Laptop laptop : laptops) { // ищем максимальный индекс первого символа названия Бренда
            int firstChar = (int) laptop.getBrandName().charAt(0);
            if (max < firstChar) {
                max = firstChar;
            }
        }

        SortList[] hashLists;

        hashLists = getHashListFromNotebookArrayByArrayLengthandBrand(laptops, max);
        setUsedSortListToArray(hashLists, laptops);


    }

    private static void setUsedSortListToArray(SortList[] hashLists, Laptop[] laptops) {
        int i = 0;

        for (SortList hashList : hashLists) {
            if (hashList != null) {

                for (Laptop laptop : hashList.list) {
                    laptops[i] = laptop;
                    i++;
                }
            }
        }
    }

    private static SortList[] getHashListFromNotebookArrayByArrayLengthandBrand(Laptop[] laptops, int max) {
        SortList[] generatedSortListArray = new SortList[max + 1];

        for (Laptop laptop : laptops) {
            int sortHashIndex = (int) laptop.getBrandName().charAt(0);
            if (generatedSortListArray[sortHashIndex] == null) {
                generatedSortListArray[sortHashIndex] = new SortList();
            }
            generatedSortListArray[sortHashIndex].list.add(laptop);

        }
        return generatedSortListArray;
    }


    private static void sortByRam(Laptop[] laptops) {
        int max = 0;

        for (Laptop laptop : laptops) { // ищем максимальный индекс первого символа названия Бренда
            int ramInstalled = laptop.getRamInstalled();
            if (max < ramInstalled) {
                max = ramInstalled;
            }
        }

        SortList[] sortList;
        sortList = getHashListFromNotebookArrayByArrayLengthAndRamInstalled(laptops, max);
        setUsedSortListToArray(sortList, laptops);

    }

    private static SortList[] getHashListFromNotebookArrayByArrayLengthAndRamInstalled(Laptop[] laptops, int max) {
        SortList[] generatedHashList = new SortList[max + 1];

        for (Laptop laptop : laptops) {
            int sortHashIndex = laptop.getRamInstalled();
            if (generatedHashList[sortHashIndex] == null) {
                generatedHashList[sortHashIndex] = new SortList();
            }
            generatedHashList[sortHashIndex].list.add(laptop);

        }
        return generatedHashList;
    }

    private static void sortByPrice(Laptop[] laptops) {
        int max = 0;

        for (Laptop laptop : laptops) { // ищем максимальный индекс первого символа названия Бренда
            int price = laptop.getPrice();
            if (max < price) {
                max = price;
            }
        }

        SortList[] sortList;
        sortList = getHashListFromNotebookArrayByArrayLengthAndPrice(laptops, max);
        setUsedSortListToArray(sortList, laptops);

    }

    private static SortList[] getHashListFromNotebookArrayByArrayLengthAndPrice(Laptop[] laptops, int max) {
        SortList[] generatedSortList = new SortList[max + 1];

        for (Laptop laptop : laptops) {
            int sortListIndex = laptop.getPrice();
            if (generatedSortList[sortListIndex] == null) {
                generatedSortList[sortListIndex] = new SortList();
            }
            generatedSortList[sortListIndex].list.add(laptop);

        }
        return generatedSortList;
    }

    public static void sort(Laptop[] laptops) {

        LaptopSorting.sortByName(laptops);
        LaptopSorting.sortByRam(laptops);
        LaptopSorting.sortByPrice(laptops);

    }

    public static void showArray(Laptop[] laptops) {
        for (int i = 0; i < laptops.length; i++) {
            System.out.println(i + 1 + ". " + laptops[i]);
        }
    }
}

class SortList {
    public List<Laptop> list = new ArrayList<>();
}
