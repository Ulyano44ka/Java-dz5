/*1.Cоздать словарь HashMap. Обобщение <Integer, String>.
2. Заполнить пятью ключами (индекс, ФИО+Возраст+Пол "Иванов Иван Иванович 28 м"), добавить ключь, если не было!)
3. Изменить значения сделав пол большой буквой.
4. Пройти по коллекции и вывести значения в формате Фамилия инициалы "Иванов И.И."
5. *Сортировать значения по возрасту и вывести отсортированную коллекция как в четвёртом пункте.*/

import javax.naming.ldap.HasControls;
import java.util.*;

public class l {
    public static void main(String[] args) {

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Антонов Дмитрий Михайлович 34 м");
        hashMap.put(2, "Кузнецова Дарья Сергеевна 49 ж");
        hashMap.put(3, "Федорова Надежда Дмитриевна 26 ж");
        hashMap.put(4, "Сергеев Юрий Иванович 29 м");
        hashMap.putIfAbsent(5, "Волкова Светлана Владимировна 19 ж");

        Set<Integer> keys = hashMap.keySet();

        for (Integer key : keys) {
            String temp1 = hashMap.get(key).split(" ")[0];
            String tmp = temp1.toUpperCase().charAt(0) + temp1.toLowerCase().substring(1, temp1.length());
            temp1 = hashMap.get(key).split(" ")[1].toUpperCase().charAt(0) + ".";//вывести значения в формате Фамилия инициалы "Иванов И.И.
            tmp = tmp + " " + temp1;
            temp1 = hashMap.get(key).split(" ")[2].toUpperCase().charAt(0) + ".";
            tmp = tmp + temp1;
            temp1 = hashMap.get(key).split(" ")[3];
            tmp = tmp + " " + temp1;
            temp1 = hashMap.get(key).split(" ")[4].toUpperCase().charAt(0) + " ";//Изменить значения сделав пол большой буквой.
            tmp = tmp + " " + temp1;
            System.out.println(tmp);
        }

        ArrayList<Integer> toSortAge = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            toSortAge.add(Integer.valueOf(hashMap.get(keys.toArray()[i]).split(" ")[3]));

        }

        ArrayList<Integer> keySorted = new ArrayList<>(keys);
        for (int i = 0; i < toSortAge.size(); i++) {
            for (int j = 0; j < toSortAge.size() - 1; j++) {
                if (toSortAge.get(j) > toSortAge.get(j + 1)) {
                    int temp = toSortAge.get(j);
                    toSortAge.set(j, toSortAge.get(j + 1));
                    toSortAge.set(j + 1, temp);

                    temp = keySorted.get(j);
                    keySorted.set(j, keySorted.get(j + 1));
                    keySorted.set(j + 1, temp);
                }
            }
        }
        System.out.println();

        hMapOutput(hashMap, keySorted, "Коллекция отсортирована по возрасту:");

    }

    private static void hMapOutput(HashMap<Integer, String> map, ArrayList<Integer> lst, String str) {
        System.out.println(str);
        for (int i = 0; i < lst.size(); i++) {
            String [] temp = map.get(lst.toArray()[i]).split(" ");
            System.out.printf("%s %s.%s.\n", temp[0], temp[1].toUpperCase().charAt(0), temp[2].toUpperCase().charAt(0));
        }
    }
}