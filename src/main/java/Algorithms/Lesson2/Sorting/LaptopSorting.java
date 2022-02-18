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

        HashList[] hashLists ;

        hashLists = getHashListFromNotebookArrayByArrayLengthandBrand(laptops, max);
         setHashListtoArray(hashLists,laptops);


    }

    private static void setHashListtoArray(HashList[] hashLists, Laptop[] laptops) {
        int i = 0;
        Laptop[] laptopsTemp = new Laptop[1000];
        for (HashList hashList : hashLists) {
            if (hashList!=null){

                for (Laptop laptop : hashList.list) {
                    laptops[i]=laptop;
                    i++;
                }
            }
        }
    }

    private static HashList[] getHashListFromNotebookArrayByArrayLengthandBrand(Laptop[] laptops, int max) {
        HashList[] generatedHashList = new HashList[max+1];

        for (Laptop laptop : laptops) {
            int sortHashIndex = (int) laptop.getBrandName().charAt(0);
            if (generatedHashList[sortHashIndex]==null) {
                generatedHashList[sortHashIndex]= new HashList();
            }
            generatedHashList[sortHashIndex].list.add(laptop);

        }
        return generatedHashList;
    }


    private static void sortByRam(Laptop[] laptops) {
        int max = 0;

        for (Laptop laptop : laptops) { // ищем максимальный индекс первого символа названия Бренда
            int ramInstalled =  laptop.getRamInstalled();
            if (max < ramInstalled) {
                max = ramInstalled;
            }
        }

        HashList[] hashLists ;
        hashLists = getHashListFromNotebookArrayByArrayLengthAndRamInstalled(laptops, max);
      setHashListtoArray(hashLists,laptops);

    }

    private static HashList[] getHashListFromNotebookArrayByArrayLengthAndRamInstalled(Laptop[] laptops, int max) {
        HashList[] generatedHashList = new HashList[max+1];

        for (Laptop laptop : laptops) {
            int sortHashIndex =  laptop.getRamInstalled();
            if (generatedHashList[sortHashIndex]==null) {
                generatedHashList[sortHashIndex]= new HashList();
            }
            generatedHashList[sortHashIndex].list.add(laptop);

        }
    return generatedHashList;
    }

    private static void sortByPrice(Laptop[] laptops) {
        int max = 0;

        for (Laptop laptop : laptops) { // ищем максимальный индекс первого символа названия Бренда
            int price =  laptop.getPrice();
            if (max < price) {
                max = price;
            }
        }

        HashList[] hashLists ;
        hashLists = getHashListFromNotebookArrayByArrayLengthAndPrice(laptops, max);
        setHashListtoArray(hashLists,laptops);

    }

    private static HashList[] getHashListFromNotebookArrayByArrayLengthAndPrice(Laptop[] laptops, int max) {
        HashList[] generatedHashList = new HashList[max+1];

        for (Laptop laptop : laptops) {
            int sortHashIndex =  laptop.getPrice();
            if (generatedHashList[sortHashIndex]==null) {
                generatedHashList[sortHashIndex]= new HashList();
            }
            generatedHashList[sortHashIndex].list.add(laptop);

        }
        return generatedHashList;
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

class HashList {
    public List<Laptop> list = new ArrayList<>();
}
