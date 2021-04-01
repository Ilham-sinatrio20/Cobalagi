package First;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Output {
    public static void main(String[] args) {
        
        //Variabel
        
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukan jumlah elemen : ");
        n = sc.nextInt();
        System.out.println();
        String[] name = new String[n];
        String[] NIM = new String[n];
        float[] nilai1 = new float[n];
        float[] nilai2 = new float[n];
        float[] nilai3 = new float[n];
        float[] rerata = new float[n];
        
        //Proses
        for(int i=0;i<n;i++){
            System.out.println("Data ke-" + (i+1));
            System.out.print("Nama      : ");
            name[i] = sc.next();
            System.out.print("NIM       : ");
            NIM[i] = sc.next();
            System.out.print("Nilai 1   : ");
            nilai1[i] = sc.nextInt();
            System.out.print("Nilai 2   : ");
            nilai2[i] = sc.nextInt();
            System.out.print("Nilai 3   : ");
            nilai3[i] = sc.nextInt();
            rerata[i] = (nilai1[i] + nilai2[i] + nilai3[i])/3;
            System.out.println();
        }
        
        //Output
        Data drive = new Data(name, NIM, nilai1, nilai2, nilai3, rerata);
        System.out.println("Data awal sebelum diurutkan");
        drive.tampil();
        System.out.println("Sorting Bubble Sort berdasar nilai1 : ");
        drive.bubbleSort();
        drive.tampil();
        System.out.println("Sorting Selection Sort berdasar nilai2 : ");
        drive.selectionSort();
        drive.tampil();
        System.out.println("Sorting Insertion Sort berdasar nilai3 : ");
        drive.insertionSort();
        drive.tampil();
        System.out.println("Sorting Shell Sort berdasar rata-rata : ");
        drive.shellSort();
        drive.tampil();
        System.out.print("Data yang ingin dicari : ");
        float dicari = sc.nextInt();
        int place = drive.searching(dicari);
        if(place != -1){
            System.out.println("Rerata " + dicari + " ada di indeks ke " + place);
        } else {
            System.out.println("Rerata " + dicari + " tidak ditemukan");
        }
    }
}
