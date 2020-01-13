package dev.marcosfarias.pokedex.classes;

import android.os.Build;

import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class CollectionPractice {
    public CollectionPractice(){
        System.out.println("constructor CollectionPractice ");
    }

    public void sum(){
        System.out.println("inside CollectionPractice");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
//        B obj = new CollectionPractice();        // if the same methods dont find in parent class so it cannot be used, because taking refrence of that class
//        obj.sum();

        //map interface
        HashMap<Integer, Object> map = new HashMap<>();
        map.put(1, "A");
        map.put(3, 1);

        //list interface
        ArrayList list = new ArrayList();
        /*list.add("Value 1");
        list.add(obj);
        list.add("value 3");
        list.add(7);
        list.add("value 5");*/

        list.add(4);
        list.add(3);
        list.add(11);
        list.add(7);
        list.add(24);
        list.sort(null);
//        Collections.reverse(list);
        System.out.println("before rotate");
        for (int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

        Collections.rotate(list, 3);
        System.out.println("after rotate");
        for (int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

        System.out.println();
        System.out.println();

        Iterator hmIterator = map.entrySet().iterator();
        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            System.out.println(mapElement.getKey() + " : " + mapElement);
        }
//        System.out.println(map.get(1));


    }

}
