package ro.utcluj.service;
import ro.utcluj.model.Comparable;


public class ArraysService {

  public static void sort(Comparable[] array) {
    for (int i = 1; i < array.length; i++) {
      Comparable key = array[i];
      int j = i - 1;
      while (array[j].compareTo(key) == 1 && j>0 ) {
        Comparable aux = array[j];
        array[j + 1] = aux;
        j--;
      }
      if (j != i) {
        array[j] = key;
      }
    }
  }
}
