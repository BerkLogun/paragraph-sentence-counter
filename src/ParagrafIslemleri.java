import java.util.*;

public class ParagrafIslemleri {
    public void paragrafEkle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("3 adet paragraf giriniz.");
        System.out.println("Luten paragraf sonlarinda bosluk birakiniz. (1 adet space yeterli)");
        String paragraf1 = scanner.nextLine().toLowerCase();
        String paragraf2 = scanner.nextLine().toLowerCase();
        String paragraf3 = scanner.nextLine().toLowerCase();

        String tumParagraflar = paragraf1 + paragraf2 + paragraf3;  // tum paragraflari tek bir paragraf haline getirir
        tumParagraflar = tumParagraflar.replaceAll("[^a-zA-Z0-9\\s]", "");    // paragraflar icerisindeki noktalama isaretlerinden kurtulmak icin


        List<String> kelimeler = new ArrayList<String>();
        String[] tempKelime = tumParagraflar.split(" ");
        int kelimeSayisi = 0;

        for(int i = 0; i< tempKelime.length ; i++){
            kelimeler.add(tempKelime[i]);
            kelimeSayisi++;
        }

        System.out.println("--------------------------------\n");

        HashSet<String> hashset = new HashSet(kelimeler);


        System.out.println("Toplam girilen sozcuk: " + kelimeSayisi);
        System.out.println("Farkli sozcuk adedi: "+ hashset.size());
        System.out.println("\n");

        HashMap<String, Integer> kelimeVeSayilar = new HashMap<String, Integer>();

        int frekans = 0;
        for(int i = 0; i < kelimeSayisi; i++){
            if(!kelimeVeSayilar.containsKey(kelimeler.get(i))){
                kelimeVeSayilar.put(kelimeler.get(i), 1);
            }else{
                frekans = kelimeVeSayilar.get(kelimeler.get(i)) + 1;
                kelimeVeSayilar.remove(kelimeler.get(i));
                kelimeVeSayilar.put(kelimeler.get(i), frekans);
            }


        }
        System.out.println("Sozcuk frekanslari: ");
        kelimeVeSayilar.forEach((sozcukler, frekanslar) -> System.out.println(sozcukler + ":\t" + frekanslar));

        int mostFrequent = -1;
        String mostFreqWord = null;
        for(String word : hashset){
            int value = 0;
            if(kelimeVeSayilar.containsKey(word)){
                value = kelimeVeSayilar.get(word);
            }

            value = value + 1;
            kelimeVeSayilar.put(word,value);

            if(value > mostFrequent){
                mostFrequent = value;
                mostFreqWord = word;
            }
        }

        System.out.println("\n");
        System.out.println("En sik kelime: " + mostFreqWord);
        System.out.println("Frekansi: " + (mostFrequent - 1));




    }


}
